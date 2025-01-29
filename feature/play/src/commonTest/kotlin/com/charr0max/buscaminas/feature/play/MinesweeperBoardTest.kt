package com.charr0max.buscaminas.feature.play

import TileState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.runComposeUiTest
import com.charr0max.buscaminas.feature.play.components.MinesweeperBoard
import kotlin.math.abs
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertTrue

class MinesweeperBoardTest {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun correctNumberOfTilesAreShown() = runComposeUiTest {
        val random = Random(1)
        val testCases = listOf(
            Pair(getRandomTileStatesForSize(0, 0, random), 0),
            Pair(getRandomTileStatesForSize(10, 10, random), 10 * 10),
            Pair(getRandomTileStatesForSize(30, 16, random), 30 * 16),
        )
        var tileStates: List<List<TileState>> by mutableStateOf(emptyList())
        setContent {
            MinesweeperBoard(
                modifier = Modifier.fillMaxSize(),
                tileStates = tileStates
            )
        }

        for (testCase in testCases) {
            tileStates = testCase.first
            waitForIdle()
            onAllNodes(
                hasTestTag(
                    "TILE"
                )
            ).assertCountEquals(testCase.second)
        }
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun allTilesAreSquare() = runComposeUiTest {
        val random = Random(12)
        val firstTileStates = getRandomTileStatesForSize(10, 10, random)
        val secondTileStates = getRandomTileStatesForSize(30, 16, random)
        var tileStates: List<List<TileState>> by mutableStateOf(firstTileStates)
        setContent {
            MinesweeperBoard(
                modifier = Modifier.fillMaxSize(),
                tileStates = tileStates
            )
        }

        fun testTileSizesAreEqual() {
            val tileSemanticNodes = onAllNodes(hasTestTag("TILE")).fetchSemanticsNodes()
            tileSemanticNodes.forEach {
                assertTrue(message = "${it.size.width} width does not equal ${it.size.height}") {
                    abs(it.size.width - it.size.height) <= 1
                }
            }
        }

        testTileSizesAreEqual()
        tileStates = secondTileStates
        waitForIdle()
        testTileSizesAreEqual()
    }

    private fun getRandomTileStatesForSize(
        width: Int,
        height: Int,
        random: Random
    ): List<List<TileState>> {
        val allTileStates = getAllTileStates()
        return buildList {
            for (x in 0 until width) {
                add(
                    buildList {
                        for (y in 0 until height) {
                            add(allTileStates.random(random))
                        }
                    })
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
}