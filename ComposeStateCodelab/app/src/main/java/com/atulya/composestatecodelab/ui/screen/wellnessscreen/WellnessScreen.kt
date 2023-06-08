package com.atulya.composestatecodelab.ui.screen.wellnessscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.atulya.composestatecodelab.ui.components.WaterCounter
import com.atulya.composestatecodelab.ui.components.WellnessTasksList

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellScreenViewModel = viewModel()
) {

    Column {
        WaterCounter(modifier = modifier)
        WellnessTasksList(
            list = wellnessViewModel.task,
            onCloseTask = { task ->
                wellnessViewModel.removeTask(task)
            },
            onCheckChanged = { task, checked ->
                wellnessViewModel.changeTaskChecked(task.id, checked)
            }
        )
    }
}

