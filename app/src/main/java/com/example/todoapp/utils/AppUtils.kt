package com.example.todoapp.utils

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class AppUtils {
    companion object {
        val letters = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        private fun randomString(length: Int): String {
            return List(length) { letters.random() }.joinToString("")
        }

        fun randomTitle(): String {
            return randomString(16)
        }

        fun randomContent(): String {
            return randomString(32)
        }

        fun randomColor(): Color {
            val random = Random.Default
            return Color(
                red = random.nextFloat(),
                green = random.nextFloat(),
                blue = random.nextFloat(),
            )
        }
    }


}