package com.example.wannafly.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.wannafly.ui.theme.Blue
import com.example.wannafly.ui.theme.SecondaryText
import com.example.wannafly.ui.theme.WannaFlyTheme

@Composable
fun NewsBottomNavigation(
    items: List<BottomNavigationItem>,
    selectedItem: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
    //            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            .heightIn(min = 52.dp, max = 62.dp),
//            .border(1.dp, Color.Transparent, RoundedCornerShape(16.dp))
//            .clip(RoundedCornerShape(16.dp)),
        containerColor = Color.White,
        tonalElevation = 16.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedItem,
                onClick = { onItemClick(index) },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            imageVector = item.imageVector,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = item.text, style = MaterialTheme.typography.labelSmall)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Blue,
                    selectedTextColor = Blue,
                    unselectedIconColor = SecondaryText,
                    unselectedTextColor = SecondaryText,
                    indicatorColor = Color.Transparent
                ),
            )
        }
    }
}

data class BottomNavigationItem(
//    @DrawableRes val icon: Int,
    val imageVector: ImageVector,
    val text: String
)

@PreviewLightDark
@Composable
fun NewsBottomNavigationPreview() {
    WannaFlyTheme(dynamicColor = false) {
        NewsBottomNavigation(items = listOf(
            BottomNavigationItem(imageVector = Icons.Default.Search, text = "Busca"),
            BottomNavigationItem(imageVector = Icons.Default.Star, text = "Favoritos"),
            BottomNavigationItem(imageVector = Icons.Default.AccountCircle, text = "Usuário")
        ), selectedItem = 0, onItemClick = {})
    }
}