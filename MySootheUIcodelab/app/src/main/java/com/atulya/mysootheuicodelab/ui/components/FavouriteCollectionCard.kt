package com.atulya.mysootheuicodelab.ui.components

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atulya.mysootheuicodelab.R

@Composable
fun FavouriteCollectionCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    @StringRes text: Int,
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.size(width = 192.dp, height = 56.dp),
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .size(56.dp),
                contentScale = ContentScale.FillBounds
            )


            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}


@Preview
@Composable
fun FavouriteCollectionCardPreview() {
    FavouriteCollectionCard(
        image = R.drawable.fc1_short_mantras,
        text = R.string.fc1_short_mantras,
    )
}