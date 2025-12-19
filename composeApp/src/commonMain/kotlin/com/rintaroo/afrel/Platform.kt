package com.rintaroo.afrel

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform