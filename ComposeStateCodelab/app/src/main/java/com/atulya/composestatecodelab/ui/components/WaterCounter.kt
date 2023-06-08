package com.atulya.composestatecodelab.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue


@Composable
fun StatelessWaterCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(modifier = modifier.padding(16.dp)) {

        if (count > 0) {
            Text(
                text = "You've had $count glasses.",
            )
        }

        Button(onClick = onIncrement, enabled = count < 10) {
            Text(text = "Add one")
        }


    }
}


@Composable
fun WaterCounter(
    modifier: Modifier = Modifier,
) {
    // this alone will not work since count will keep getting reassigned to 0 during recomposition
    // we need to use remember in conjunction so that old value of count is remembered during
    // recomposition
    // val count: MutableState<Int> = mutableStateOf(0)
    var count by rememberSaveable {
        mutableStateOf(0)
    }

    StatelessWaterCounter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier
    )
}