package com.example.todoapp.utils

class AppRandom {
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
    }


}