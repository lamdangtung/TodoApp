package com.example.todoapp.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.utils.AppUtils


@Composable
fun ActionButton(
    onPressed: () -> Unit, icon: Painter
) {
    Button(
        onClick = onPressed,
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
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewActionButton() {
    ActionButton(
        onPressed = {

        },
        icon = painterResource(R.drawable.ic_info_outline)
    )
}