package com.atulya.composestatecodelab.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatelessWellnessTaskItem(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
            modifier = Modifier.weight(1f)
        )

        Checkbox(checked = checked, onCheckedChange = onCheckedChange)

        IconButton(onClick = onClose) {
            Icon(imageVector = Icons.Default.Close, contentDescription = null)
        }
    }
}

@Composable
fun StatefulWellnessTaskItem(
    text: String,
    modifier: Modifier = Modifier,
) {

    var checkedState by rememberSaveable {
        mutableStateOf(false)
    }
    StatelessWellnessTaskItem(
        text = text,
        checked = checkedState,
        onCheckedChange = { checkedState = it },
        onClose = {},
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    StatelessWellnessTaskItem(
        text = "Poo poo pee paa",
        onClose = {},
        checked = true,
        onCheckedChange = {},
    )
}