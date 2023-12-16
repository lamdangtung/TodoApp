package com.example.todoapp.navigation

import androidx.navigation.NavHostController
import com.example.todoapp.data.enums.Action
import com.example.todoapp.utils.AppConstraints

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}"){
            popUpTo(AppConstraints.LIST_SCREEN){
                inclusive = true
            }
        }
    }

    val note: (Int) -> Unit = {noteId -> navController.navigate(route = "note/$noteId")}
}