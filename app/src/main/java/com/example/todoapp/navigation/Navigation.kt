package com.example.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.todoapp.destinations.listComposable
import com.example.todoapp.destinations.noteComposable
import com.example.todoapp.utils.AppConstraints


@Composable
fun SetupNavigation(navController: NavHostController){
    val screen = remember(navController){
        Screens(navController= navController)
    }

    NavHost(navController = navController, startDestination = AppConstraints.LIST_SCREEN){
        listComposable(
            navigateToNoteScreen = screen.note
        )

        noteComposable (
            navigateToListScreen = screen.list
                )
    }
}