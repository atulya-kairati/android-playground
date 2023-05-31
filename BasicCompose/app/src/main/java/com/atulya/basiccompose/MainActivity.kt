package com.atulya.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.atulya.basiccompose.models.Message
import com.atulya.basiccompose.models.sampleMessages
import com.atulya.basiccompose.ui.components.Conversation
import com.atulya.basiccompose.ui.components.MessageCard
import com.atulya.basiccompose.ui.theme.BasicComposeTheme

// https://developer.android.com/courses/pathways/jetpack-compose-for-android-developers-1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Conversation(sampleMessages())
                }
            }
        }
    }
}