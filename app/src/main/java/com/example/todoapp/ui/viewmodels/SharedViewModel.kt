package com.example.todoapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.models.Note
import com.example.todoapp.data.repositories.NoteRepository
import com.example.todoapp.utils.AppUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

val notes =
    List(10) {
        Note(
            id = it.toLong(),
            title = AppUtils.randomTitle(),
            content = AppUtils.randomContent(),
            status = 0,
            createdAt = Date(),
            updatedAt = Date()
        );
    }

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    private val _allNotes =
        MutableStateFlow<List<Note>>(emptyList())
    val allNotes: StateFlow<List<Note>> = _allNotes

    fun getAllNotes() {
        viewModelScope.launch {
            repository.getAllNotes.collect {
                _allNotes.value = notes
            }
        }
    }

    fun getNoteById(noteId: Long): Note {
        return _allNotes.value.first {
            it.id == noteId
        }
    }

}