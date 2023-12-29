package com.example.todoapp.ui.screens.detail_note

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R
import com.example.todoapp.data.models.Note
import com.example.todoapp.ui.screens.home.components.ActionButton
import com.example.todoapp.ui.screens.home.components.AddButton
import com.example.todoapp.ui.screens.home.components.HeaderScreen
import com.example.todoapp.ui.screens.home.components.NoteCard
import com.example.todoapp.ui.viewmodels.SharedViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(noteId: Long) {
    Scaffold(
        content = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF252525),
            ) {
                Column {
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Spacer(modifier = Modifier.width(24.dp))
                        Box(Modifier.weight(1.0f)) {
                            Text(
                                "Notes: $noteId",
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
            }
        },
    )
}