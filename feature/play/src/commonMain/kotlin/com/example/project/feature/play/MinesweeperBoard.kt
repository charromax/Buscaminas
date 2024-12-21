package com.example.project.feature.play

import TileState
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

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

private fun getAllTileStates(): Set<TileState> = setOf(
    TileState.Hidden(true),
    TileState.Hidden(false),
    TileState.Revealed.Mine,
    TileState.Revealed.Number(1),
    TileState.Revealed.Number(2),
    TileState.Revealed.Number(3),
    TileState.Revealed.Number(4),
    TileState.Revealed.Number(5),
    TileState.Revealed.Number(6),
    TileState.Revealed.Number(7),
    TileState.Revealed.Number(8),
)

@Composable
@Preview
fun BoardPreview() {
    val states = getAllTileStates()
    val tileStates = buildList {
        repeat(10) {
            add(
                buildList {
                    repeat(6) {
                        add(states.random())
                    }
                }
            )
        }
    }
    MinesweeperBoard(
        tileStates = tileStates,
        modifier = Modifier.fillMaxSize()
    )
}