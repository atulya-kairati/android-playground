package com.atulya.lazylayouts.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


/**
 * [Warning]:
 * Don't use 0 sized children in LazyLayouts
 */

@Composable
fun LazyRowExample(
    modifier: Modifier = Modifier,
) {

    val state = rememberLazyListState() // to remember scroll position across recomposition
    val coroutineScope = rememberCoroutineScope()

    val showStaringItem by remember {
        derivedStateOf {
            state.layoutInfo.totalItemsCount > 4
        }
    }

    LazyRow(
        /**
         * [Arrangement.Horizontal] can be implemented
         * to create custom arrangement object.
         */
        horizontalArrangement = Arrangement.spacedBy(8.dp), // space between children
        contentPadding = PaddingValues(8.dp), // padding without clipping children
        verticalAlignment = Alignment.CenterVertically,
        state = state
    ) {
        items(10) {
            SquareCard(
                cardColors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }

        if (showStaringItem) {
            item {
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            // scroll to start
                            state.animateScrollToItem(index = 0)
                        }
                    },
                ) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)
                }
            }
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFCDDC39)
@Composable
fun LazyRowExamplePreview() {
    LazyRowExample()
}