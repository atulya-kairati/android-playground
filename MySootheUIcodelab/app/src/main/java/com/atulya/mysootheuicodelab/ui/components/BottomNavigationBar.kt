package com.atulya.mysootheuicodelab.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.atulya.mysootheuicodelab.R


@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        modifier = Modifier,
    ) {

        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(imageVector = Icons.Default.Spa, contentDescription = null)
            },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_home))
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_profile))
            }
        )

    }
}

@Preview
@Composable
fun BottomNavigationBarPreview(){
    BottomNavigationBar()
}