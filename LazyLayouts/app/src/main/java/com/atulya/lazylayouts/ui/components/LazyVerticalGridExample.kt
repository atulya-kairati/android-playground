package com.atulya.lazylayouts.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp


@Composable
fun LazyVerticalGridFixedItemCountExample(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
        state = rememberLazyGridState()
    ) {
        items(20) { idx ->
            ColoredBox(
                modifier = Modifier
                    .size(200.dp),
                color = if (idx % 3 == 0) Color.Red else Color.Yellow
            )
        }
    }
}


@Composable
fun LazyVerticalGridAdaptiveItemCountExample(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp), // set width of children
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
        state = rememberLazyGridState()
    ) {
        items(20) { idx ->
            ColoredBox(
                modifier = Modifier
                    .size(200.dp),
                color = if (idx % 3 == 0) Color.Red else Color.Yellow
            )
        }
    }
}


@Composable
fun LazyVerticalGridCustomExample(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = object : GridCells {
            override fun Density.calculateCrossAxisCellSizes(
                availableSize: Int,
                spacing: Int
            ): List<Int> {
                // returns a list of column widths

                val firstColumn = (availableSize - spacing) * 2 / 3
                val secondColumn = availableSize - spacing - firstColumn

                return listOf(firstColumn, secondColumn)
            }
        },

        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
        state = rememberLazyGridState()
    ) {
        items(20) { idx ->
            ColoredBox(
                modifier = Modifier
                    .size(200.dp),
                color = if (idx % 3 == 0) Color.Red else Color.Yellow
            )
        }
    }
}


@Composable
fun LazyVerticalGridCategoriesExample(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
        state = rememberLazyGridState()
    ) {
        item(
            span = {
                GridItemSpan(maxLineSpan)
                // also available: [maxCurrentLineSpan]
            }
        ){
            HorizontalCard()
        }
        items(10) { idx ->
            ColoredBox(
                modifier = Modifier
                    .size(200.dp),
                color = if (idx % 3 == 0) Color.Red else Color.Yellow
            )
        }
        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ){
            HorizontalCard()
        }
        items(10) { idx ->
            ColoredBox(
                modifier = Modifier
                    .size(200.dp),
                color = if (idx % 3 == 0) Color.Red else Color.Yellow
            )
        }
    }
}


@Preview(device = "spec:width=411dp,height=891dp")
@Composable
fun LazyVerticalGridFixedItemCountExamplePreview() {
    LazyVerticalGridFixedItemCountExample()
}

@Preview(
    device = "spec:width=1280dp,height=800dp,dpi=480,orientation=portrait",
    showSystemUi = true
)
@Composable
fun LazyVerticalGridAdaptiveItemCountExamplePreview() {
    LazyVerticalGridAdaptiveItemCountExample()
}

@Preview(device = "spec:width=411dp,height=891dp")
@Composable
fun LazyVerticalGridCustomExamplePreview() {
    LazyVerticalGridCustomExample()
}

@Preview(device = "spec:width=411dp,height=891dp")
@Composable
fun LazyVerticalGridCategoriesExamplePreview() {
    LazyVerticalGridCategoriesExample()
}