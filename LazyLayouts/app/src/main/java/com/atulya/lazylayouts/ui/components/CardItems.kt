package com.atulya.lazylayouts.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atulya.lazylayouts.R

@Composable
fun HorizontalCard(
    modifier: Modifier = Modifier,
    cardColors: CardColors = CardDefaults.cardColors()
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = cardColors,
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.putar),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(64.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds
            )


            Column {
                Text(
                    text = "Big ass title",
                    style = MaterialTheme.typography.titleSmall,
                )
                Text(
                    text = "Puny lorem ipsum dolor manus chaubey bing chilling",
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

@Composable
fun SquareCard(
    modifier: Modifier = Modifier,
    cardColors: CardColors = CardDefaults.cardColors()
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = cardColors,
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.putar),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(120.dp),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = "Hari Putar",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
            )
        }
    }
}

@Composable
fun ColoredBox(
    modifier: Modifier = Modifier,
    color: Color = Color.Magenta
){
    Surface(
        color = color,
        shape = MaterialTheme.shapes.medium
    ) {
        Box(
            modifier = modifier
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFCDDC39)
@Composable
fun HorizontalCardPreview() {
    HorizontalCard(
        modifier = Modifier.padding(4.dp)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFCDDC39)
@Composable
fun SquareCardPreview() {
    SquareCard(
        modifier = Modifier.padding(4.dp)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFCDDC39)
@Composable
fun ColoredBoxPreview() {
    ColoredBox(
        modifier = Modifier.size(200.dp)
    )
}
