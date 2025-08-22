package com.example.mokumokusolo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.ui.theme.Typography

val LightColorTheme = lightColorScheme(
    primary = Primary,
    surface = Surface,
    surfaceContainerLowest = SurfaceLowest,
    background = Background,
    onSurface = OnSurface,
    onSurfaceVariant = OnSurfaceVariant
)

val DarkColorTheme = darkColorScheme(
    primary = PrimaryDark,
    surface = SurfaceDark,
    surfaceContainerLowest = SurfaceLowestDark,
    background = BackgroundDark,
)

@Composable
fun MokuMokuSoloTheme(
    content: @Composable () -> Unit
) {
    val theme = if (isSystemInDarkTheme()) {
        DarkColorTheme
    } else {
        LightColorTheme
    }
    MaterialTheme(
        colorScheme = theme,
        typography = Typography,
        content = content
    )
}


//private val mediumContrastLightColorScheme = lightColorScheme(
//    primary = primaryLightMediumContrast,
//    onPrimary = onPrimaryLightMediumContrast,
//    primaryContainer = primaryContainerLightMediumContrast,
//    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
//    secondary = secondaryLightMediumContrast,
//    onSecondary = onSecondaryLightMediumContrast,
//    secondaryContainer = secondaryContainerLightMediumContrast,
//    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
//    tertiary = tertiaryLightMediumContrast,
//    onTertiary = onTertiaryLightMediumContrast,
//    tertiaryContainer = tertiaryContainerLightMediumContrast,
//    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
//    error = errorLightMediumContrast,
//    onError = onErrorLightMediumContrast,
//    errorContainer = errorContainerLightMediumContrast,
//    onErrorContainer = onErrorContainerLightMediumContrast,
//    background = backgroundLightMediumContrast,
//    onBackground = onBackgroundLightMediumContrast,
//    surface = surfaceLightMediumContrast,
//    onSurface = onSurfaceLightMediumContrast,
//    surfaceVariant = surfaceVariantLightMediumContrast,
//    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
//    outline = outlineLightMediumContrast,
//    outlineVariant = outlineVariantLightMediumContrast,
//    scrim = scrimLightMediumContrast,
//    inverseSurface = inverseSurfaceLightMediumContrast,
//    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
//    inversePrimary = inversePrimaryLightMediumContrast,
//    surfaceDim = surfaceDimLightMediumContrast,
//    surfaceBright = surfaceBrightLightMediumContrast,
//    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
//    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
//    surfaceContainer = surfaceContainerLightMediumContrast,
//    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
//    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
//)

//private val mediumContrastDarkColorScheme = darkColorScheme(
//    primary = primaryDarkMediumContrast,
//    onPrimary = onPrimaryDarkMediumContrast,
//    primaryContainer = primaryContainerDarkMediumContrast,
//    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
//    secondary = secondaryDarkMediumContrast,
//    onSecondary = onSecondaryDarkMediumContrast,
//    secondaryContainer = secondaryContainerDarkMediumContrast,
//    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
//    tertiary = tertiaryDarkMediumContrast,
//    onTertiary = onTertiaryDarkMediumContrast,
//    tertiaryContainer = tertiaryContainerDarkMediumContrast,
//    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
//    error = errorDarkMediumContrast,
//    onError = onErrorDarkMediumContrast,
//    errorContainer = errorContainerDarkMediumContrast,
//    onErrorContainer = onErrorContainerDarkMediumContrast,
//    background = backgroundDarkMediumContrast,
//    onBackground = onBackgroundDarkMediumContrast,
//    surface = surfaceDarkMediumContrast,
//    onSurface = onSurfaceDarkMediumContrast,
//    surfaceVariant = surfaceVariantDarkMediumContrast,
//    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
//    outline = outlineDarkMediumContrast,
//    outlineVariant = outlineVariantDarkMediumContrast,
//    scrim = scrimDarkMediumContrast,
//    inverseSurface = inverseSurfaceDarkMediumContrast,
//    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
//    inversePrimary = inversePrimaryDarkMediumContrast,
//    surfaceDim = surfaceDimDarkMediumContrast,
//    surfaceBright = surfaceBrightDarkMediumContrast,
//    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
//    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
//    surfaceContainer = surfaceContainerDarkMediumContrast,
//    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
//    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
//)
//

//@Immutable
//data class ColorFamily(
//    val color: Color,
//    val onColor: Color,
//    val colorContainer: Color,
//    val onColorContainer: Color
//)
//
//val unspecified_scheme = ColorFamily(
//    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
//)
//
//@Composable
//fun AppTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
//    content: @Composable() () -> Unit
//) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> darkScheme
//        else -> lightScheme
//    }
//
//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = AppTypography,
//        content = content
//    )
//}

