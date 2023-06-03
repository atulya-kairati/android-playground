package com.atulya.mysootheuicodelab.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atulya.mysootheuicodelab.model.alignYourBodyData

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp
        ), // prevents children getting cut off when scrolling
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyCard(
                image = item.drawable,
                text = item.text,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AlignYourBodyRowPreview(){
    AlignYourBodyRow()
}