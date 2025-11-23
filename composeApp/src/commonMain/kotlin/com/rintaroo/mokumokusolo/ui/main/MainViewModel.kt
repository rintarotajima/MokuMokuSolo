package com.rintaroo.mokumokusolo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rintaroo.mokumokusolo.data.database.entity.App
import com.rintaroo.mokumokusolo.data.database.entity.Expenditure
import com.rintaroo.mokumokusolo.data.repository.AppRepository
import com.rintaroo.mokumokusolo.data.repository.ExpenditureRepository
import com.rintaroo.mokumokusolo.util.DateUtils
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class MainViewModel(
    private val appRepository: AppRepository,
    private val expenditureRepository: ExpenditureRepository
) : ViewModel() {
    private val startOfMonth = DateUtils.getStartOfCurrentMonth()
    private val startOfNextMonth = DateUtils.getStartOfNextMonth()

    val apps: StateFlow<List<App>> = appRepository.getAppsForMonth(startOfMonth, startOfNextMonth)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val expenditures: StateFlow<List<Expenditure>> = expenditureRepository.getExpendituresForMonth(startOfMonth, startOfNextMonth)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addApp(app: App) {
        viewModelScope.launch {
            appRepository.insertApp(app)
        }
    }

    fun addExpenditure(expenditure: Expenditure) {
        viewModelScope.launch {
            expenditureRepository.insertExpenditure(expenditure)
        }
    }

    fun updateApp(app: App) {
        viewModelScope.launch {
            appRepository.updateApp(app)
        }
    }

    fun deleteApp(app: App) {
        viewModelScope.launch {
            appRepository.deleteApp(app)
        }
    }

    fun updateExpenditure(expenditure: Expenditure) {
        viewModelScope.launch {
            expenditureRepository.updateExpenditure(expenditure)
        }
    }

    fun deleteExpenditure(expenditure: Expenditure) {
        viewModelScope.launch {
            expenditureRepository.deleteExpenditure(expenditure)
        }
    }
}