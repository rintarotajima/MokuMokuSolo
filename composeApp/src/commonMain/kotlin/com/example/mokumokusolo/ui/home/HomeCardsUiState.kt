package com.example.mokumokusolo.ui.home

import com.example.mokumokusolo.data.database.entity.App
import com.example.mokumokusolo.data.database.entity.Expenditure

data class HomeCardsUiState(
    val balance: Int,
    val targetExpenditure: com.example.mokumokusolo.data.database.entity.Expenditure?,
    val progressRatio: Float,
    val totalIncome: Long,
    val totalExpenditure: Long,
)

fun updateHomeCardsUiState(
    apps: List<App>,
    expenditures: List<Expenditure>
): HomeCardsUiState {
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