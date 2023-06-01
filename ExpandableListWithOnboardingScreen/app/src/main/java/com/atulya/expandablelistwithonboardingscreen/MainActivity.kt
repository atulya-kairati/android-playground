package com.atulya.expandablelistwithonboardingscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atulya.expandablelistwithonboardingscreen.ui.screens.OnboardingScreen
import com.atulya.expandablelistwithonboardingscreen.ui.theme.ExpandableListWithOnboardingScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableListWithOnboardingScreenTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var showOnboardingScreen by rememberSaveable {
        mutableStateOf(true)
    }

    if (showOnboardingScreen) {
        OnboardingScreen(onClickContinue = { showOnboardingScreen = false })
    } else {
        Greetings()
    }
}


@Composable
fun Greetings(modifier: Modifier = Modifier) {
    val names: List<String> = List(100) { "$it" }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = names) { name ->
                Greeting(name = name)
            }
        }

    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var isExpanded: Boolean by rememberSaveable {
        mutableStateOf(false)
    }

    val extraPadding by animateDpAsState(
        if (isExpanded) 48.dp else 0.dp,

        /**
         * Any animation created with animate*AsState is interruptible.
         * This means that if the target value changes in the middle of
         * the animation, animate*AsState restarts the animation and
         * points to the new value.
         */
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = modifier.padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        bottom = extraPadding.coerceAtLeast(0.dp) // to avoid -ve padding due to spring anim
                    )
            ) {
                Text(
                    text = "Hello,",
                )
                Text(
                    text = name,
                )
            }

            ElevatedButton(onClick = { isExpanded = !isExpanded }) {
                Text(text = if (isExpanded) "Show less" else "Show More")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExpandableListWithOnboardingScreenTheme {
        Greetings()
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    ExpandableListWithOnboardingScreenTheme {
        MyApp()
    }
}
