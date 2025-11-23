package com.rintaroo.mokumokusolo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform