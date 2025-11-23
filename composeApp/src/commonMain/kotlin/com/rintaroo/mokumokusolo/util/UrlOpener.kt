package com.rintaroo.mokumokusolo.util

interface UrlOpener {
    fun openUrl(url: String)
}

expect fun createUrlOpener(): UrlOpener