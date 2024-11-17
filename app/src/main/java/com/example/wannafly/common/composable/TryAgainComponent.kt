package com.example.wannafly.common.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.wannafly.R
import com.example.wannafly.common.UiText

@Composable
fun TryAgainComponent(
    errorMessage: UiText?,
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        when {
            errorMessage != null -> Text(
                text = errorMessage.toString(LocalContext.current),
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            else -> Text(
                text = stringResource(R.string.try_again_message),
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier
            .width(8.dp)
            .height(8.dp))
    }
}