package com.example.rickandmorty.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val RickGreen   = Color(0xFF97CE4C)
private val PortalBlue  = Color(0xFF44CFFF)
private val DarkBg      = Color(0xFF0B0E13)
private val DarkSurface = Color(0xFF141820)
private val DarkSurface2= Color(0xFF1C2130)
private val TextPrimary = Color(0xFFE8EDF5)
private val TextDim     = Color(0xFF6B7A90)
private val ErrorRed    = Color(0xFFE45C5C)

private val DarkColorScheme = darkColorScheme(
    primary         = RickGreen,
    secondary       = PortalBlue,
    background      = DarkBg,
    surface         = DarkSurface,
    surfaceVariant  = DarkSurface2,
    onBackground    = TextPrimary,
    onSurface       = TextPrimary,
    onSurfaceVariant= TextDim,
    error           = ErrorRed,
)

private val LightColorScheme = lightColorScheme(
    primary         = RickGreen,
    secondary       = PortalBlue,
    background      = Color(0xFFF5F7FA),
    surface         = Color.White,
    surfaceVariant  = Color(0xFFEAEDF2),
    onBackground    = Color(0xFF0B0E13),
    onSurface       = Color(0xFF0B0E13),
    onSurfaceVariant= Color(0xFF6B7A90),
    error           = ErrorRed,
)

@Composable
fun RickandMortyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography  = Typography,
        content     = content
    )
}