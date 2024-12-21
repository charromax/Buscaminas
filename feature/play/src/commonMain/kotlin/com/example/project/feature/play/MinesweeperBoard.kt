package com.example.project.feature.play

import TileState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun MinesweeperBoard(
    modifier: Modifier = Modifier,
    tileStates: List<List<TileState>>,
    textStyle: TextStyle = TextStyle()
) {
    if (tileStates.isNotEmpty()) {
        val boardHeight = remember { tileStates.first().size }
        val boardWidth = remember { tileStates.size }
        BoxWithConstraints(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            val requiredRatio = boardWidth / boardHeight.toFloat()
            val currentRatio = maxWidth / maxHeight
            val tileLength = if (requiredRatio > currentRatio) {
                // should fill width
                maxWidth / boardWidth
            } else {
                // should fill height
                maxHeight / boardHeight
            }
            val sizeAdjustedTextStyle = textStyle.copy(
                fontSize = tileLength.value.sp * .6f
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(tileLength * boardWidth)
                    .height(tileLength * boardHeight)
            ) {
                // move through columns
                for (x in tileStates.indices) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        // move through lines
                        for (y in tileStates[x].indices) {
                            val tileState = tileStates[x][y]
                            val revealedBorderWidth = tileLength / 32
                            val hiddenBorderWidth = tileLength / 8
                            Tile(
                                state = tileState,
                                revealedBorderWidth = revealedBorderWidth,
                                hiddenBorderWidth = hiddenBorderWidth,
                                textStyle = sizeAdjustedTextStyle,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}