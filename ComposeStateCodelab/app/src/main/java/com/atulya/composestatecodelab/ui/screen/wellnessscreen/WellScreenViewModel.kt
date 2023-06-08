package com.atulya.composestatecodelab.ui.screen.wellnessscreen

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.atulya.composestatecodelab.model.WellnessTask

class WellScreenViewModel : ViewModel() {
    private val _task = getWellnessTasksList(30).toMutableStateList()
    val task: List<WellnessTask>
        get() = _task

    fun removeTask(task: WellnessTask) {
        _task.remove(task)
    }

    fun changeTaskChecked(taskId: Int, checked: Boolean) {
        _task.find { it.id == taskId }?.let { task ->
            task.checked = checked
        }
    }
}

private fun getWellnessTasksList(n: Int) = List(n) { index ->
    WellnessTask(id = index, label = "#$index Task")
}