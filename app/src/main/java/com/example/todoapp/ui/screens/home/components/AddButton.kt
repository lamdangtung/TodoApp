package com.example.todoapp.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoapp.R
import com.example.todoapp.ui.screens.Screen
import com.example.todoapp.utils.AppUtils

@Composable
fun AddButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(Screen.Note.withArgs(10))
        },
        modifier = Modifier
            .height(70.dp)
            .width(70.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = AppUtils.randomColor()
        ),
        shape = CircleShape,
        contentPadding = PaddingValues(24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = null,
            modifier = Modifier
                .height(48.dp)
                .width(48.dp)
        )
    }
}