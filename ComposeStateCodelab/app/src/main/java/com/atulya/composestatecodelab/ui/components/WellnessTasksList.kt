package com.atulya.composestatecodelab.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.atulya.composestatecodelab.model.WellnessTask


@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn {

        /**
         * By default,
         * each item's state is keyed against
         * the position of the item in the list.
         *
         * This can present a problem is an element
         * is deleted. Its state will be assigned to
         * different element which has not moved to
         * the deleted element's place.
         *
         * We can solve this issue using key argument
         * in [items].
         */
        items(
            list,
            key = { task -> task.id }
        ) { task ->
            StatefulWellnessTaskItem(
                text = task.label,
                onClose = { onCloseTask(task) }
            )
        }
    }
}