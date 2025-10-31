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

    companion object {
        /**
         * Converts ItemType to String for navigation
         */
        fun ItemType.toNavigationString(): String = when (this) {
            is App -> "app"
            is Expenditure -> "expenditure"
        }

        /**
         * Converts String from navigation back to ItemType
         * @throws IllegalArgumentException if the string is not a valid ItemType
         */
        fun fromNavigationString(value: String): ItemType = when (value.lowercase()) {
            "app" -> App
            "expenditure" -> Expenditure
            else -> throw IllegalArgumentException("Unknown ItemType: $value")
        }
    }
}
