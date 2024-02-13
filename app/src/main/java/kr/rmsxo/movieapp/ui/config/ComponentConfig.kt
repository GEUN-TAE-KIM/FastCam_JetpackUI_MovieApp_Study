package kr.rmsxo.movieapp.ui.config

import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import kr.rmsxo.movieapp.ui.theme.color.ColorSet

data class ComponentConfig(
    val colors: ColorSet,
    val typography: Typography,
    val shapes: Shapes,
    val isDarkTheme: Boolean
)