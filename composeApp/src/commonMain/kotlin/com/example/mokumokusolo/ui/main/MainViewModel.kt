package com.example.mokumokusolo.ui.main

import androidx.lifecycle.ViewModel
import com.example.mokumokusolo.model.App
import com.example.mokumokusolo.model.Expenditure
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class MainViewModel : ViewModel() {
    private val _apps = MutableStateFlow<List<App>>(emptyList())
    val apps: StateFlow<List<App>> = _apps

    private val _expenditures = MutableStateFlow<List<Expenditure>>(emptyList())
    val expenditures: StateFlow<List<Expenditure>> = _expenditures

    fun updateApps(newApp: App) {
        _apps.value = _apps.value + newApp
    }

    fun updateExpenditures(newExpenditure: Expenditure) {
        _expenditures.value = _expenditures.value + newExpenditure
    }

}