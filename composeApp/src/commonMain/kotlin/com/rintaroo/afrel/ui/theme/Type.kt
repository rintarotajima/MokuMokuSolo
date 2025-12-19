package com.rintaroo.afrel.ui.theme

import afrel.composeapp.generated.resources.Res
import afrel.composeapp.generated.resources.lato_regular
import afrel.composeapp.generated.resources.montserrat_bold
import afrel.composeapp.generated.resources.montserrat_medium
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font

val MontSerrat
    @Composable get() = FontFamily(
        Font(
            resource = Res.font.montserrat_bold,
            weight = FontWeight.Bold
        ),
        Font(
            resource = Res.font.montserrat_medium,
            weight = FontWeight.Medium
        )
    )

val Lato
    @Composable get() = FontFamily(
        Font(
            resource = Res.font.lato_regular,
            weight = FontWeight.Normal
        )
    )

val Typography: Typography
    @Composable get() = Typography(
        titleLarge = TextStyle(
            fontFamily = MontSerrat,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            lineHeight = 36.sp
        ),
        titleMedium = TextStyle(
            fontFamily = MontSerrat,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            lineHeight = 32.sp
        ),
        titleSmall = TextStyle(
            fontFamily = MontSerrat,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            lineHeight = 28.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontSize = 17.sp,
            lineHeight = 24.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            lineHeight = 20.sp
        ),
        bodySmall = TextStyle(
            fontFamily = Lato,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            lineHeight = 20.sp
        ),
    )