package kr.rmsxo.movieapp.ui.theme.color

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.lightColorScheme

data class MyColors(
    // Material Design 3 ColorScheme 정의
    val material: ColorScheme = lightColorScheme(),
    val tertiary: Color = material.tertiary,
    val onPrimaryAlt: Color = material.onPrimary,
    val success: Color = Color(0xFF4CAF50), // Material 3에 맞게 색상 코드 사용
    val checked: Color = Color.White,
    val unchecked: Color = Color.White,
    val checkmark: Color = material.primary,
    val disabledSecondary: Color = material.secondary.copy(alpha = 0.5f),
    val textFiledBackground: Color = Color(0xFFBDBDBD), // Material 3 색상 코드 사용
    val textFiledBackgroundVariant: Color = Color(0xFF616161), // Material 3 색상 코드 사용
    val launcherScreenBackground: Color = material.primary,
    val progressItemColor: Color = Color.Black
) {
    val primary: Color get() = material.primary
    val primaryVariant: Color get() = material.primaryContainer // primaryVariant -> primaryContainer
    val secondary: Color get() = material.secondary
    val secondaryVariant: Color get() = material.secondaryContainer // secondaryVariant -> secondaryContainer
    val background: Color get() = material.background
    val surface: Color get() = material.surface
    val error: Color get() = material.error
    val onPrimary: Color get() = material.onPrimary
    val onSecondary: Color get() = material.onSecondary
    val onBackground: Color get() = material.onBackground
    val onSurface: Color get() = material.onSurface
    val onError: Color get() = material.onError
    val isLight: Boolean get() = material.background.luminance() > 0.5 // isLight는 Material 3에서 직접 지원하지 않음, 적절한 처리 필요

    private fun Color.luminance(): Float {
        // sRGB luminance formula를 사용하여 밝기를 계산합니다.
        val r = red * 0.299
        val g = green * 0.587
        val b = blue * 0.114
        return (r + g + b).toFloat()
    }
}