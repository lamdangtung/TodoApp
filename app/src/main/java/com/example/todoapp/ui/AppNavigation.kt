package com.example.todoapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todoapp.data.enums.Action
import com.example.todoapp.ui.screens.Screen
import com.example.todoapp.ui.screens.home.HomeScreen
import com.example.todoapp.ui.screens.note.NoteScreen
import com.example.todoapp.ui.viewmodels.SharedViewModel

@Composable
fun AppNavigation(vm: SharedViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController, vm = vm)
        }
        composable(Screen.Note.route + "/{noteId}/{actionId}", arguments = listOf(
            navArgument(
                "noteId"
            ) {
                type = NavType.LongType
                defaultValue = -1L
            },
            navArgument(
                "actionId"
            ) {
                type = NavType.LongType
                defaultValue = -1L
            }

        )) { param ->

            NoteScreen(
                navController = navController,
                noteId = param.arguments?.getLong("noteId") ?: -1L,
                vm = vm,
                action = Action.values()[(param.arguments?.getLong("actionId") ?: 0L).toInt()]
            )
        }
    }
}