package com.example.todoapp.ui.screens.note.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.R
import com.example.todoapp.data.enums.Action
import com.example.todoapp.ui.screens.home.components.ActionButton
import com.example.todoapp.ui.viewmodels.SharedViewModel


@Composable
fun HeaderNoteScreen(navController: NavController, vm: SharedViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(1.0f)) {
                ActionButton(
                    onPressed = {
                        vm.reset();
                        navController.popBackStack()
                    },
                    icon = painterResource(R.drawable.ic_back)
                )
            }
            if (vm.action.value == Action.VIEW) {
                ActionButton(
                    onPressed = {
                        vm.onEnableEditMode()
                    },
                    icon = painterResource(R.drawable.ic_pen)
                )
            } else {
                ActionButton(
                    onPressed =
                    {},
                    icon = painterResource(R.drawable.ic_eye)
                )
                Spacer(modifier = Modifier.width(21.dp))
                ActionButton(
                    onPressed = {
                        vm.showSaveNoteDialog()
                    },
                    icon = painterResource(R.drawable.ic_save)
                )
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHeaderScreen() {
    val navController = rememberNavController()
//    HeaderNoteScreen(navController = navController, action = Action.VIEW)
}

@Preview(showBackground = true)
@Composable
fun PreviewHeaderScreenADD() {
    val navController = rememberNavController()
//    HeaderNoteScreen(navController = navController, action = Action.ADD)
}