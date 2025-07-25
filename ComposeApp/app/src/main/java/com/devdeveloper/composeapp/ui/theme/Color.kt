package com.devdeveloper.composeapp.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val veryLightGrey = Color(0x60DCDCDC)

val lightGreen200 = Color(0x9932CD32)

val skyBlue100 = Color(0xFF36C5D3)

val ColorScheme.skyBlue: Color
    @Composable
    get() = skyBlue100

val ColorScheme.lightGreen: Color
    @Composable
    get() = lightGreen200