package com.atulya.mysootheuicodelab.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atulya.mysootheuicodelab.R
import java.util.Locale


@Composable
fun HomeSection(
    @StringRes title: Int,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
){
    Column {
        Text(
            text = stringResource(title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(bottom = 8.dp, top = 40.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeSectionComposable(){
    HomeSection(
        title = R.string.align_your_body,
        content = {
            AlignYourBodyRow()
        }
    )
}