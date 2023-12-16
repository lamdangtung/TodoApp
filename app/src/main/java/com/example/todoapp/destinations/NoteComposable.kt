package com.example.todoapp.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoapp.data.enums.Action
import com.example.todoapp.utils.AppConstraints


fun NavGraphBuilder.noteComposable(
    navigateToListScreen: (Action) -> Unit
){
    composable(
        route=  AppConstraints.NOTE_SCREEN,
        arguments = listOf(navArgument(AppConstraints.NOTE_SCREEN_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ){

    }
}