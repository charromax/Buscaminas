package com.charr0max.buscaminas.ui.core

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class MinesweeperBoardColorScheme(
    val background: Color,
    val borderLight: Color,
    val borderDark: Color,
    val mine: Color,
    val flag: Color,
    val one: Color,
    val two: Color,
    val three: Color,
    val four: Color,
    val five: Color,
    val six: Color,
    val seven: Color,
    val eight: Color,
    val timerText: Color,
)

val MinesweeperColorScheme = compositionLocalOf {
    MinesweeperBoardColorScheme(
        background = Color(0xFFCBCBCB),
        borderLight = Color(0xFFFFFFFF),
        borderDark = Color(0xFF8F8F8F),
        mine = Color(0xFF000000),
        flag = Color(0xFFEB392A),
        one = Color(0xFF0000F5),
        two = Color(0xFF377E22),
        three = Color(0xFFFA3323),
        four = Color(0xFF00007B),
        five = Color(0xFF75140C),
        six = Color(0xFF377E7F),
        seven = Color(0xFF75147C),
        eight = Color(0xFF808080),
        timerText = Color(0xFFEA3324),
    )
}