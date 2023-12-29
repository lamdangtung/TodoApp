package com.example.todoapp.ui.screens.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R

@Composable
fun HeaderScreen() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.width(24.dp))
        Box(Modifier.weight(1.0f)) {
            Text(
                "Notes",
                fontSize = 43.sp,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                    // Add other style properties as needed (e.g., fontSize, letterSpacing, etc.)
                ),
            )
        }
        Row(
        ) {
            ActionButton(
                onPressed = {
                },
                icon = painterResource(R.drawable.ic_search)
            )
            Spacer(modifier = Modifier.width(21.dp))
            ActionButton(
                onPressed = {

                },
                icon = painterResource(R.drawable.ic_info_outline)
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
    }
}