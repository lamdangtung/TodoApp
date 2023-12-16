package com.example.todoapp.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoapp.utils.AppConstraints


fun NavGraphBuilder.listComposable(
    navigateToNoteScreen: (Int) -> Unit
){
    composable(
        route=  AppConstraints.LIST_SCREEN,
        arguments = listOf(navArgument(AppConstraints.LIST_SCREEN_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ){

    }
}

