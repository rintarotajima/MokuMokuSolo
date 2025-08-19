package com.example.mokumokusolo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform