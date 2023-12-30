package com.example.todoapp.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoapp.ui.screens.home.components.AddButton
import com.example.todoapp.ui.screens.home.components.HeaderScreen
import com.example.todoapp.ui.screens.home.components.NoteCard
import com.example.todoapp.ui.viewmodels.SharedViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, vm: SharedViewModel) {
    LaunchedEffect(Unit) {
        vm.getAllNotes()
    }
    val allNotes = vm.allNotes.collectAsState().value
    Scaffold(
        content = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF252525),
            ) {
                Column {
                    Spacer(modifier = Modifier.height(24.dp))
                    HeaderScreen()
                    Spacer(modifier = Modifier.height(36.dp))
                    LazyColumn {
                        items(allNotes) {
                            NoteCard(navController = navController, note = it, vm = vm)
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            AddButton(
                navController = navController,
                vm = vm
            )
        }
    )
}


@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
//    HomeScreen(
//        vm = SharedViewModel()
//    )
}




