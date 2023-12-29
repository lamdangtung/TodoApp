package com.example.todoapp.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoapp.data.models.Note
import com.example.todoapp.ui.screens.Screen
import com.example.todoapp.utils.AppUtils

@Composable
fun NoteCard(navController: NavController, note: Note) {
    Box(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .background(color = AppUtils.randomColor(), shape = RoundedCornerShape(15.dp))
            .padding(24.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(Screen.Note.withArgs(note.id))
            }
    ) {
        Text(
            note.title, fontSize = 25.sp,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                color = Color.Black
                // Add other style properties as needed (e.g., fontSize, letterSpacing, etc.)
            ),
        )
    }
}