package com.atulya.expandablelistwithonboardingscreen.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atulya.expandablelistwithonboardingscreen.ui.theme.ExpandableListWithOnboardingScreenTheme

@Composable
fun OnboardingScreen(
    onClickContinue: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Welcome to the sandaas!")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onClickContinue,
        ) {
            Text(text = "Continue")
        }
    }
}


@Preview
@Composable
fun OnboardingScreenPreview() {
    ExpandableListWithOnboardingScreenTheme {
        OnboardingScreenPreview()
    }
}