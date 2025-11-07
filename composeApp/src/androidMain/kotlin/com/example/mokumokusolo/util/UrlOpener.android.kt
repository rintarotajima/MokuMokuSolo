package com.example.mokumokusolo.util

import android.content.Context
import android.content.Intent
import android.net.Uri

class AndroidUrlOpener(private val context: Context) : UrlOpener {
    override fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}

// This function will be provided by DI
actual fun createUrlOpener(): UrlOpener {
    throw IllegalStateException("UrlOpener should be provided by DI")
}