package com.atulya.composestatecodelab.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf

data class WellnessTask(
    val id: Int,
    val label: String,
    var initialCheck: Boolean = false
){
    var checked by mutableStateOf(initialCheck)
}
