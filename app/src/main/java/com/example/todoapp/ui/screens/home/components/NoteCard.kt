package com.example.todoapp.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoapp.R
import com.example.todoapp.data.enums.Action
import com.example.todoapp.data.models.Note
import com.example.todoapp.ui.screens.Screen
import com.example.todoapp.ui.viewmodels.SharedViewModel
import com.example.todoapp.utils.AppUtils
import kotlin.math.roundToInt

@Composable
@ExperimentalMaterial3Api

fun NoteCard(navController: NavController, note: Note, vm: SharedViewModel) {
    var isDeleting by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        isDeleting = !isDeleting;
                    },
                    onTap = {
                        if (!isDeleting) {
                            navController.navigate(
                                Screen.Note.withArgs(
                                    note.id,
                                    Action
                                        .values()
                                        .indexOf(Action.VIEW)
                                        .toLong()
                                )
                            )
                        } else {
                            vm.deleteNote(note = note)
                            isDeleting = false;
                        }
                    }
                )
            }
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .background(color = AppUtils.randomColor(), shape = RoundedCornerShape(15.dp))
            .padding(24.dp)
            .fillMaxWidth()

    ) {
        if (isDeleting) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_delete), contentDescription = null,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                )
            }
        } else {
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
}