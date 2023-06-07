package com.atulya.composestatecodelab.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.atulya.composestatecodelab.model.WellnessTask

private fun getWellnessTasksList(n: Int) = List(n) { index ->
    WellnessTask(id = index, label = "#$index Task")
}

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(getWellnessTasksList(30)) { task ->
            StatefulWellnessTaskItem(text = task.label)
        }
    }
}