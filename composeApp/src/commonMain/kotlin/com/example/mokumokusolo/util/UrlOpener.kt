package com.example.mokumokusolo.util

interface UrlOpener {
    fun openUrl(url: String)
}

expect fun createUrlOpener(): UrlOpener