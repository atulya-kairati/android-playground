package com.atulya.composestatecodelab.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.atulya.composestatecodelab.model.WellnessTask

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier
) {

    val list = remember {
        getWellnessTasksList(30).toMutableStateList()
    }

    Column {
        StatefulWaterCounter(modifier = modifier)
        WellnessTasksList(
            list = list.toList(),
            onCloseTask = { task ->
                list.remove(task)
            }
        )
    }
}


private fun getWellnessTasksList(n: Int) = List(n) { index ->
    WellnessTask(id = index, label = "#$index Task")
}