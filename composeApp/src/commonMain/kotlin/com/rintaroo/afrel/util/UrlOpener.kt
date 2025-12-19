package com.rintaroo.afrel.util

interface UrlOpener {
    fun openUrl(url: String)
}

expect fun createUrlOpener(): UrlOpener