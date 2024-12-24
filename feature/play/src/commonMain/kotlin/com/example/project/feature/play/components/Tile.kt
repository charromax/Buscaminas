package com.example.project.feature.play

import TileState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import buscaminas.feature.play.generated.resources.Res
import buscaminas.feature.play.generated.resources.mine
import com.example.project.ui.core.MinesweeperColorScheme
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Tile(
    state: TileState,
    revealedBorderWidth: Dp,
    hiddenBorderWidth: Dp,
    textStyle: TextStyle = TextStyle(),
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(color = MinesweeperColorScheme.current.background)
            .run {
                if (state is TileState.Revealed) {
                    border(
                        width = revealedBorderWidth,
                        color = MinesweeperColorScheme.current.borderDark
                    )
                } else {
                    hiddenTile(
                        borderThickness = hiddenBorderWidth,
                        borderLight = MinesweeperColorScheme.current.borderLight,
                        borderDark = MinesweeperColorScheme.current.borderDark
                    )
                }
            },
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is TileState.Hidden -> {
                if (state.flagged) {
                    // draw flag
                    Icon(
                        imageVector = Icons.Filled.Flag,
                        contentDescription = null,
                        tint = MinesweeperColorScheme.current.flag,
                        modifier = Modifier.fillMaxSize(fraction = .6f)
                    )
                }
            }

            is TileState.Revealed.Mine -> {
                Icon(
                    imageVector = vectorResource(Res.drawable.mine),
                    contentDescription = null,
                    tint = MinesweeperColorScheme.current.mine,
                    modifier = Modifier.fillMaxSize(fraction = .6f)
                )
            }

            is TileState.Revealed.Number -> {
                state.value?.let {
                    val color = when (it) {
                        1 -> MinesweeperColorScheme.current.one
                        2 -> MinesweeperColorScheme.current.two
                        3 -> MinesweeperColorScheme.current.three
                        4 -> MinesweeperColorScheme.current.four
                        5 -> MinesweeperColorScheme.current.five
                        6 -> MinesweeperColorScheme.current.six
                        7 -> MinesweeperColorScheme.current.seven
                        8 -> MinesweeperColorScheme.current.eight
                        else -> Color.Black
                    }

                    Text(
                        text = it.toString(),
                        color = color,
                        style = textStyle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxSize().wrapContentHeight(
                            align = Alignment.CenterVertically,
                        )
                    )
                }
            }

            else -> {}
        }
    }
}


private fun Modifier.hiddenTile(
    borderThickness: Dp,
    borderLight: Color,
    borderDark: Color,
) = drawWithContent {
    drawContent()
    val thicknessInPx = borderThickness.toPx()
    val width = size.width
    val height = size.height

    // top left
    drawPath(
        path = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, height)
            lineTo(thicknessInPx, height - thicknessInPx)
            lineTo(thicknessInPx, thicknessInPx)
            lineTo(width - thicknessInPx, thicknessInPx)
            lineTo(width, 0f)
            close()
        },
        color = borderLight
    )
    // bottom right
    drawPath(
        path = Path().apply {
            moveTo(0f, height)
            lineTo(width, height)
            lineTo(width, 0f)
            lineTo(width - thicknessInPx, thicknessInPx)
            lineTo(width - thicknessInPx, height - thicknessInPx)
            lineTo(thicknessInPx, height - thicknessInPx)
            close()
        },
        color = borderDark
    )
}

@Composable
@Preview
@OptIn(ExperimentalLayoutApi::class)
fun TilePreview() {
    val states = getAllTileStates()
    FlowRow {
        states.forEach {
            Tile(
                state = it,
                modifier = Modifier.size(32.dp),
                revealedBorderWidth = 2.dp,
                hiddenBorderWidth = 4.dp
            )
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