package com.example.project.feature.menu.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.project.ui.core.LocalDimensions
import com.example.project.ui.core.LocalPadding

@Composable
internal fun MenuButton(modifier: Modifier = Modifier, label: String, action: () -> Unit) {
    TextButton(
        onClick = action,
        modifier = modifier
            .padding(LocalPadding.current.normal)
            .widthIn(max = LocalDimensions.current.maxWidthSmall)
            .fillMaxWidth()
    ) {
        Text(label)
    }
}