package com.atulya.mysootheuicodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.atulya.mysootheuicodelab.ui.components.BottomNavigationBar
import com.atulya.mysootheuicodelab.ui.screens.HomeScreen
import com.atulya.mysootheuicodelab.ui.theme.MySootheUIcodelabTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheUIcodelabTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    bottomBar = { BottomNavigationBar() }
                ) {
                    HomeScreen(modifier = Modifier.padding(it))
                }
            }
        }
    }
}
