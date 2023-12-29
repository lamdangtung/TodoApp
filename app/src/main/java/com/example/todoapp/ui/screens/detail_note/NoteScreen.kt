package com.example.todoapp.ui.screens.detail_note

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.screens.detail_note.components.HeaderNoteScreen
import com.example.todoapp.ui.viewmodels.SharedViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(navController: NavController, noteId: Long, vm: SharedViewModel) {
    val note by remember { mutableStateOf(vm.getNoteById(noteId)) }
    Scaffold(
        content = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF252525),
            ) {
                Column {
                    Spacer(modifier = Modifier.height(24.dp))
                    HeaderNoteScreen(navController = navController)
                    Spacer(modifier = Modifier.height(48.dp))
                    Text(

                        note.title,
                        fontSize = 35.sp,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                            // Add other style properties as needed (e.g., fontSize, letterSpacing, etc.)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 27.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        note.content, fontSize = 23.sp,
                        style = TextStyle(
                            fontWeight = FontWeight.Light,
                            color = Color.White
                            // Add other style properties as needed (e.g., fontSize, letterSpacing, etc.)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 27.dp)
                    )
                }
            }
        },
    )
}

@Composable
@Preview
fun PreviewNoteScreen() {
    val navController = rememberNavController()
//    NoteScreen(navController = navController, noteId = 10)
}