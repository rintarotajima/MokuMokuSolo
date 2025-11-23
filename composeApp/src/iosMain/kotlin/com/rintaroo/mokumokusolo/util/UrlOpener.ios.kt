package com.rintaroo.mokumokusolo.util

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

class IosUrlOpener : UrlOpener {
    override fun openUrl(url: String) {
        val nsUrl = NSURL.URLWithString(url)
        if (nsUrl != null && UIApplication.sharedApplication.canOpenURL(nsUrl)) {
            UIApplication.sharedApplication.openURL(nsUrl)
        }
    }
}

// This function will be provided by DI
actual fun createUrlOpener(): UrlOpener {
    throw IllegalStateException("UrlOpener should be provided by DI")
}