package com.example.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalDivider() {
    Box(
        modifier = Modifier
            .height(56.dp)
            .width(1.dp)
            .background(
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
            )
    )
}
