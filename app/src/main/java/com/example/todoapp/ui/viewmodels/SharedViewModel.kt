package com.example.todoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.models.Note
import com.example.todoapp.data.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel(){
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes : StateFlow<List<Note>> = _notes

    fun getAllNotes(){
        viewModelScope.launch {
            noteRepository.getAllNotes.collect{
                _notes.value = it
            }
        }
    }

}