package com.example.mokumokusolo.model

import kotlinx.serialization.Serializable

/**
 * Represents the type of item being edited or displayed.
 * Using a sealed interface provides type safety and exhaustive when checking.
 */
@Serializable
sealed interface ItemType {
    /**
     * Represents an App/Revenue item
     */
    @Serializable
    data object App : ItemType

    /**
     * Represents an Expenditure/Expense item
     */
    @Serializable
    data object Expenditure : ItemType
}
