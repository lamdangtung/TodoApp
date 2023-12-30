package com.example.todoapp.ui.screens.note

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.R
import com.example.todoapp.data.enums.Action
import com.example.todoapp.data.models.createEmptyNote
import com.example.todoapp.ui.screens.note.components.HeaderNoteScreen
import com.example.todoapp.ui.viewmodels.SharedViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(navController: NavController, noteId: Long, vm: SharedViewModel, action: Action) {

    LaunchedEffect(Unit) {
        vm.init(action = action, noteId = noteId)
    }
    Scaffold(
        content = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF252525),
            ) {
                Column {
                    Spacer(modifier = Modifier.height(24.dp))
                    HeaderNoteScreen(navController = navController, vm = vm)
                    Spacer(modifier = Modifier.height(40.dp))
                    TitleNote(vm = vm)
                    Spacer(modifier = Modifier.height(16.dp))
                    ContentNote(vm = vm)

                }
            }
        },
    )

    if (vm.isShowDialog.value) {
        CustomDialog(
            onDismiss = {
                vm.closeDialog()
            },
            onCancel = {
                vm.closeDialog()
            },
            onOk = {
                if (vm.action.value == Action.ADD) {
                    vm.onSaveNote()
                } else if (vm.action.value == Action.UPDATE) {
                    vm.onUpdateNote()
                }
            },
            message = vm.messageDialog.value
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleNote(vm: SharedViewModel) {
    if (vm.action.value == Action.VIEW) {
        Text(
            vm.currentNote.value.title,
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
    } else {
        TextField(
            value = vm.title.value,
            onValueChange = {
                // Update the text field state when the value changes
                vm.title.value = it
            },
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 48.sp,
                fontWeight = FontWeight.Normal
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    "Title",
                    fontSize = 48.sp,
                    style = TextStyle(

                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF9A9A9A)
                    ),
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 27.dp) // Add padding for spacing
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTitleNote() {
    val note = createEmptyNote()
//    TitleNote(note, Action.ADD)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentNote(vm: SharedViewModel) {
    if (vm.action.value == Action.VIEW) {
        Text(
            vm.currentNote.value.content, fontSize = 23.sp,
            style = TextStyle(
                fontWeight = FontWeight.Light,
                color = Color.White
                // Add other style properties as needed (e.g., fontSize, letterSpacing, etc.)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 27.dp)
        )
    } else {
        TextField(
            value = vm.content.value,
            onValueChange = {
                // Update the text field state when the value changes
                vm.content.value = it
            },
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 23.sp,
                fontWeight = FontWeight.Normal
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    "Type something...",
                    fontSize = 23.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF9A9A9A)
                    ),
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 27.dp) // Add padding for spacing
        )
    }


}

@Composable
@Preview
fun PreviewNoteScreen() {
    val navController = rememberNavController()
//    NoteScreen(navController = navController, noteId = 10)
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomDialog(
    onDismiss: () -> Unit,
    onOk: () -> Unit,
    onCancel: () -> Unit,
    message: String,
    okTitle: String = "Save",
    cancelTitle: String = "Discard",
) {
    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Surface(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(),
            color = Color(0xFF252525),
            shape = MaterialTheme.shapes.large
        ) {
            Column(
                modifier = Modifier.padding(24.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = onCancel,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .background(
                            color = Color(0xFF3B3B3B),
                            shape = RoundedCornerShape(15.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Transparent
                    ),
                    contentPadding = PaddingValues(13.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_info_outline),
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    message, fontSize = 23.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFCFCFCF)
                        // Add other style properties as needed (e.g., fontSize, letterSpacing, etc.)
                    ),
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row {
                    Button(
                        onClick = onCancel,
                        modifier = Modifier
                            .height(39.dp)
                            .wrapContentWidth()
                            .background(
                                color = Color(0xFFFF0000),
                                shape = RoundedCornerShape(15.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            cancelTitle,
                            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal

                            )
                        )
                    }
                    Spacer(modifier = Modifier.width(32.dp))
                    Button(
                        onClick = onOk,
                        modifier = Modifier
                            .height(39.dp)
                            .wrapContentWidth()
                            .background(
                                color = Color(0xFF30BE71),
                                shape = RoundedCornerShape(15.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            okTitle,

                            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal

                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomDialog() {
    CustomDialog(
        onOk = {

        },
        onCancel = {

        },
        onDismiss = {

        },
        message = "Save changes ?"
    )
}