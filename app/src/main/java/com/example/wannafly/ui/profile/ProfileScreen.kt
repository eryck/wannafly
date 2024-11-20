package com.example.wannafly.ui.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wannafly.data.remote.response.UserDataResponse

@Composable
fun ProfileScreen(
    userData: UserDataResponse?,
    onSignOut: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (userData?.profileImageUrl != null) {
                    AsyncImage(
                        model = userData.profileImageUrl,
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                            .border(BorderStroke(1.dp, MaterialTheme.colorScheme.primary), CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                if (userData?.username != null) {
                    Text(
                        text = userData.username,
                        textAlign = TextAlign.Center,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = TextUnit(36f, TextUnitType.Sp)
                    )
                }
                Button(
                    onClick = onSignOut
                ) {
                    Text(text = "Sign out")
                }
            }
        }
    }
}