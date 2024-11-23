package com.example.wannafly.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.wannafly.R
import com.example.wannafly.presentation.common.SearchBar
import com.example.wannafly.ui.theme.AccentBlue
import com.example.wannafly.ui.theme.Blue
import com.example.wannafly.ui.theme.DarkBlue


@PreviewLightDark
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val brushDark = Brush.verticalGradient(listOf(DarkBlue, Blue))
    val brushLight = Brush.verticalGradient(listOf(AccentBlue, Blue))
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) brushDark else brushLight)
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Olá, ".plus("Usuário"),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) Color.White else DarkBlue,
                )
            }
            Image(
                painter = painterResource(id = R.mipmap.ic_plane_ticket_foreground),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(48.dp),
                contentDescription = null,
            )
        }
        SearchBar(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = {}
        )
        Card(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
        }
    }
}