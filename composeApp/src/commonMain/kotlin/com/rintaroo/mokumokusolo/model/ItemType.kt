package com.rintaroo.mokumokusolo.model

/**
 * Represents the type of item being edited or displayed.
 * Using a sealed interface provides type safety and exhaustive when checking.
 */
sealed interface ItemType {
    /**
     * Represents an App/Revenue item
     */
    data object App : ItemType

    /**
     * Represents an Expenditure/Expense item
     */
    data object Expenditure : ItemType
}

/**
 * Converts ItemType to String for navigation
 */
fun ItemType.toNavigationString(): String = when (this) {
    is ItemType.App -> "app"
    is ItemType.Expenditure -> "expenditure"
}

/**
 * Converts String from navigation back to ItemType
 * @throws IllegalArgumentException if the string is not a valid ItemType
 */
fun String.toItemType(): ItemType = when (this.lowercase()) {
    "app" -> ItemType.App
    "expenditure" -> ItemType.Expenditure
    else -> throw IllegalArgumentException("Unknown ItemType: $this")
}
