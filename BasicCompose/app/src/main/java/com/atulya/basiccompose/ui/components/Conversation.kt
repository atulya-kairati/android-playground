package com.atulya.basiccompose.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.atulya.basiccompose.models.Message
import com.atulya.basiccompose.models.sampleMessages

@Composable
fun Conversation(
    messages: List<Message>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {

        items(messages) { msg ->
            MessageCard(
                msg = msg,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ConversationPreview(){
    Conversation(messages = sampleMessages())
}