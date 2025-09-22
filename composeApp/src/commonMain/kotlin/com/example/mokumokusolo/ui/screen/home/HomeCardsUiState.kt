package com.example.mokumokusolo.ui.screen.home

import com.example.mokumokusolo.model.App
import com.example.mokumokusolo.model.Expenditure

data class HomeCardsUiState(
    val balance: Int,
    val targetExpenditure: Expenditure?,
    val progressRatio: Float,
    val totalIncome: Double,
    val totalExpenditure: Double,
)

fun updateHomeCardsUiState(apps: List<App>, expenditures: List<Expenditure>): HomeCardsUiState {
    val totalIncome = apps.sumOf { it.amount }
    val totalExpenditureAmount = expenditures.sumOf { it.amount }
    val currentBalance = (totalIncome - totalExpenditureAmount).toInt()

    val candidates = expenditures.filter { it.amount > totalIncome }.sortedBy { it.amount }
    val targetExpenditure = candidates.firstOrNull()

    val progressRatio = if (targetExpenditure != null && targetExpenditure.amount > 0) {
        (totalIncome / targetExpenditure.amount).toFloat().coerceAtMost(1.0f)
    } else {
        0f
    }

    return HomeCardsUiState(
        balance = currentBalance,
        targetExpenditure = targetExpenditure,
        progressRatio = progressRatio,
        totalIncome = totalIncome,
        totalExpenditure = totalExpenditureAmount
    )
}