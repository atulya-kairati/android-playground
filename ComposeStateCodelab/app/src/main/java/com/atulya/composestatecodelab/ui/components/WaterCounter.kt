package com.atulya.composestatecodelab.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@SuppressLint("UnrememberedMutableState")
@Composable
fun WaterCounter(
    modifier: Modifier = Modifier,
) {
    // this alone will not work since count will keep getting reassigned to 0 during recomposition
    // we need to use remember in conjunction so that old value of count is remembered during
    // recomposition
    // val count: MutableState<Int> = mutableStateOf(0)

    var count by remember {
        mutableStateOf(0)
    }

    Column(modifier = modifier.padding(16.dp)) {

        if (count > 0) {

            var showTask by remember {
                mutableStateOf(true)
            }

            if (showTask) {
                WellnessTaskItem(text = "Go on son, have a wank.", onClose = { showTask = false })
            }

            Text(
                text = "You've had $count glasses.",
            )
        }

        Row {
            Button(onClick = { count++ }, enabled = count < 10) {
                Text(text = "Add one")
            }

            Button(onClick = { count = 0 }) {
                Text(text = "Clear water counter")
            }
        }
    }
}