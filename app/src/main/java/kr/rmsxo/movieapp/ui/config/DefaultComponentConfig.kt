package kr.rmsxo.movieapp.ui.config

import kr.rmsxo.movieapp.ui.theme.Shapes
import kr.rmsxo.movieapp.ui.theme.color.ColorSet
import kr.rmsxo.movieapp.ui.theme.Typography

object DefaultComponentConfig {
    val RED_THEME = ComponentConfig(
        colors = ColorSet.Red,
        shapes = Shapes,
        typography = Typography,
        isDarkTheme = false
    )

    val BLUE_THEME = ComponentConfig(
        colors = ColorSet.Blue,
        shapes = Shapes,
        typography = Typography,
        isDarkTheme = false
    )

    private var currentConfig = RED_THEME
    private var themeColorSet: ColorSet = ColorSet.Red
}