package com.example.todoapp.ui.screens

import com.example.todoapp.utils.AppConstraints

sealed class Screen(val route: String) {
    object Home : Screen(AppConstraints.HOME_SCREEN)
    object Note : Screen(AppConstraints.NOTE_SCREEN)

    fun withArgs(vararg args: Long): String{
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}