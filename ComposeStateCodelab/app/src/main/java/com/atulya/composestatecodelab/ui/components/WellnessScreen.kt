package com.atulya.composestatecodelab.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier
) {

    Column {
        StatefulWaterCounter(modifier = modifier)
        WellnessTasksList()
    }
}