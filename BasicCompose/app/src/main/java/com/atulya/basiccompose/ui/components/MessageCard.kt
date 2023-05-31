package com.atulya.basiccompose.ui.components

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atulya.basiccompose.R
import com.atulya.basiccompose.models.Message
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun MessageCard(
    msg: Message,
    modifier: Modifier = Modifier
) {

//    var isExpanded by remember { mutableStateOf(false) }

    /**
     * Add
     * import androidx.compose.runtime.getValue
     * import androidx.compose.runtime.setValue
     *
     * for this to work
     */
    var isExpanded by remember { mutableStateOf(false) }

    val surfaceColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
    )

    Row(
        modifier = modifier
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dace),
            contentDescription = "Profile Icon",
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
                .border(
                    width = 1.5.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                ),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.clickable {
                isExpanded = !isExpanded
            }
        ) {
            Text(
                text = msg.name,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 2.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp) // animate container size smoothly
            ) {
                Text(
                    text = msg.body,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MessageCardPreview() {
    MessageCard(
        msg = Message("Manus", "If I was not me then I'd still prefer to be me"),
    )
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    name = "Dark Mode", showSystemUi = false
)
@Composable
fun MessageCardDarkPreview() {
    MessageCard(
        msg = Message("Manus", "If I was not me then I'd still prefer to be me"),
    )
}