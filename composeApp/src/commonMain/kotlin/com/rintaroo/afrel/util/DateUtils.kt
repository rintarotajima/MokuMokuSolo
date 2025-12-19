package com.rintaroo.afrel.util

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.LocalDate
import kotlinx.datetime.atStartOfDayIn

object DateUtils {
    /**
     * Get current date as epoch milliseconds (midnight of today)
     */
    fun getCurrentDateMillis(): Long {
        val now = Clock.System.now()
        val localDate = now.toLocalDateTime(TimeZone.currentSystemDefault()).date
        return localDate.atStartOfDayIn(TimeZone.currentSystemDefault()).toEpochMilliseconds()
    }

    /**
     * Get start of current month as epoch milliseconds
     */
    fun getStartOfCurrentMonth(): Long {
        val now = Clock.System.now()
        val localDate = now.toLocalDateTime(TimeZone.currentSystemDefault()).date
        val startOfMonth = LocalDate(localDate.year, localDate.month, 1)
        return startOfMonth.atStartOfDayIn(TimeZone.currentSystemDefault()).toEpochMilliseconds()
    }

    /**
     * Get start of next month as epoch milliseconds
     */
    fun getStartOfNextMonth(): Long {
        val now = Clock.System.now()
        val localDateTime = now.toLocalDateTime(TimeZone.currentSystemDefault())
        val localDate = localDateTime.date

        val nextMonth = if (localDate.monthNumber == 12) {
            LocalDate(localDate.year + 1, 1, 1)
        } else {
            LocalDate(localDate.year, localDate.monthNumber + 1, 1)
        }

        return nextMonth.atStartOfDayIn(TimeZone.currentSystemDefault()).toEpochMilliseconds()
    }

    /**
     * Convert epoch milliseconds to LocalDate
     */
    fun millisToLocalDate(millis: Long): LocalDate {
        val instant = kotlinx.datetime.Instant.fromEpochMilliseconds(millis)
        return instant.toLocalDateTime(TimeZone.currentSystemDefault()).date
    }

    /**
     * Convert LocalDate to epoch milliseconds (midnight)
     */
    fun localDateToMillis(date: LocalDate): Long {
        return date.atStartOfDayIn(TimeZone.currentSystemDefault()).toEpochMilliseconds()
    }
}