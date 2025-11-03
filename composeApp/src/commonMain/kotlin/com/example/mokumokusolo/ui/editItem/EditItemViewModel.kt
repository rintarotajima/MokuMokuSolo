package com.example.mokumokusolo.ui.editItem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mokumokusolo.data.database.entity.App
import com.example.mokumokusolo.data.database.entity.Expenditure
import com.example.mokumokusolo.data.repository.AppRepository
import com.example.mokumokusolo.data.repository.ExpenditureRepository
import com.example.mokumokusolo.model.ItemType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

data class EditItemUiState(
    val itemType: ItemType = ItemType.App,
    val name: String = "",
    val amount: String = "",
    val isLoading: Boolean = true,
    val itemId: Int? = null
)

class EditItemViewModel(
    private val appRepository: AppRepository,
    private val expenditureRepository: ExpenditureRepository,
    private val itemId: Int,
    private val itemType: ItemType
) : ViewModel() {

    private val _uiState = MutableStateFlow(EditItemUiState(itemType = itemType))
    val uiState: StateFlow<EditItemUiState> = _uiState

    init {
        loadItem()
    }

    private fun loadItem() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            when (itemType) {
                ItemType.App -> {
                    val app = appRepository.getAppById(itemId).firstOrNull()
                    app?.let {
                        _uiState.value = EditItemUiState(
                            itemType = itemType,
                            name = it.name,
                            amount = it.amount.toString(),
                            isLoading = false,
                            itemId = it.id
                        )
                    }
                }

                ItemType.Expenditure -> {
                    val expenditure = expenditureRepository.getExpenditureById(itemId).firstOrNull()
                    expenditure?.let {
                        _uiState.value = EditItemUiState(
                            itemType = itemType,
                            name = it.name,
                            amount = it.amount.toString(),
                            isLoading = false,
                            itemId = it.id
                        )
                    }
                }
            }
        }
    }

    fun updateName(newName: String) {
        _uiState.value = _uiState.value.copy(name = newName)
    }

    fun updateAmount(newAmount: String) {
        _uiState.value = _uiState.value.copy(amount = newAmount)
    }

    fun saveItem(onSuccess: () -> Unit) {
        viewModelScope.launch {
            val state = _uiState.value
            val id = state.itemId ?: return@launch

            when (state.itemType) {
                ItemType.App -> {
                    val app = App(
                        id = id,
                        name = state.name,
                        amount = state.amount.toLongOrNull() ?: 0L
                    )
                    appRepository.updateApp(app)
                }

                ItemType.Expenditure -> {
                    val expenditure = Expenditure(
                        id = id,
                        name = state.name,
                        amount = state.amount.toLongOrNull() ?: 0L
                    )
                    expenditureRepository.updateExpenditure(expenditure)
                }
            }
            onSuccess()
        }
    }

    fun deleteItem(onSuccess: () -> Unit) {
        viewModelScope.launch {
            val id = _uiState.value.itemId ?: return@launch

            when (_uiState.value.itemType) {
                ItemType.App -> appRepository.deleteAppById(id)
                ItemType.Expenditure -> expenditureRepository.deleteExpenditureById(id)
            }
            onSuccess()
        }
    }
}