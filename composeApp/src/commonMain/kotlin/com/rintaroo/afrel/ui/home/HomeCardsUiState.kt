package com.rintaroo.afrel.ui.home

import com.rintaroo.afrel.data.database.entity.App
import com.rintaroo.afrel.data.database.entity.Expenditure

data class HomeCardsUiState(
    val balance: Int,
    val targetExpenditure: Expenditure?,
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
        (totalIncome.toFloat() / targetExpenditure.amount).coerceAtMost(1.0f)
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