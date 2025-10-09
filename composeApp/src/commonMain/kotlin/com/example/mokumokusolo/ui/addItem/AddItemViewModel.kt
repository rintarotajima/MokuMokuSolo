package com.example.mokumokusolo.ui.addItem

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class AddItemFormState(
    val selectedIndex: Int = 0,
    val incomeData: IncomeData = IncomeData(),
    val expenseData: ExpenseData = ExpenseData()
)

data class IncomeData(
    val name: String = "",
    val amount: String = ""
)

data class ExpenseData(
    val name: String = "",
    val amount: String = ""
)

class AddItemViewModel : ViewModel() {
    private val _addItemFormState = MutableStateFlow(AddItemFormState())
    val addItemFormState: StateFlow<AddItemFormState> = _addItemFormState

    fun updateSelectedIndex(index: Int) {
        _addItemFormState.value = _addItemFormState.value.copy(selectedIndex = index)
    }

    fun updateIncomeName(name: String) {
        _addItemFormState.value = _addItemFormState.value.copy(
            incomeData = _addItemFormState.value.incomeData.copy(name = name)
        )
    }

    fun updateIncomeAmount(amount: String) {
        _addItemFormState.value = _addItemFormState.value.copy(
            incomeData = _addItemFormState.value.incomeData.copy(amount = amount)
        )
    }

    fun updateExpenseName(name: String) {
        _addItemFormState.value = _addItemFormState.value.copy(
            expenseData = _addItemFormState.value.expenseData.copy(name = name)
        )
    }

    fun updateExpenseAmount(amount: String) {
        _addItemFormState.value = _addItemFormState.value.copy(
            expenseData = _addItemFormState.value.expenseData.copy(amount = amount)
        )
    }

    fun resetForm() {
        _addItemFormState.value = AddItemFormState()
    }
}