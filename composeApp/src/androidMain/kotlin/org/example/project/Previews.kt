package org.example.project

import TileState
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project.feature.play.MinesweeperBoard
import com.example.project.feature.play.Tile

@OptIn(ExperimentalLayoutApi::class)
@Composable
@Preview
fun TilePreview(modifier: Modifier = Modifier) {
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

@Composable
@Preview
fun BoardPreview() {
    val states = getAllTileStates()
    val tileStates = buildList {
        repeat(10) {
            add(
                buildList {
                    repeat(16) {
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