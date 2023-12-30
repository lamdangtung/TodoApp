package com.example.todoapp.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.enums.Action
import com.example.todoapp.data.models.Note
import com.example.todoapp.data.models.createEmptyNote
import com.example.todoapp.data.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    private val _allNotes = MutableStateFlow<List<Note>>(emptyList())
    val allNotes: StateFlow<List<Note>> = _allNotes
    var isShowDialog = mutableStateOf(false)
    var currentNote = mutableStateOf(createEmptyNote())
    var messageDialog = mutableStateOf("")
    var title = mutableStateOf("")
    var content = mutableStateOf("")
    var action = mutableStateOf(Action.NOTHING)
    fun getAllNotes() {
        viewModelScope.launch {
            repository.getAllNotes.collect {
                _allNotes.value = it
            }
        }
    }

    private fun getNoteById(noteId: Long): Note {
        return _allNotes.value.first {
            it.id == noteId
        }
    }

    fun closeDialog() {
        isShowDialog.value = false;
    }

    fun onSaveNote() {
        viewModelScope.launch {
            val newNote = Note(
                content = content.value,
                title = title.value,
                createdAt = Date(),
                updatedAt = Date(),
                status = 0
            )
            val newNoteId = repository.addNote(note = newNote)
            isShowDialog.value = false
            repository.getNoteById(newNoteId).collect {
                currentNote.value = it
                action.value = Action.VIEW
            }

        }
    }

    fun onUpdateNote() {
        viewModelScope.launch {
            val updateNote = currentNote.value
            updateNote.content = content.value
            updateNote.title = title.value
            updateNote.updatedAt = Date()
            repository.updateNote(note = updateNote)
            isShowDialog.value = false
            repository.getNoteById(updateNote.id).collect {
                currentNote.value = it
                action.value = Action.VIEW
            }
        }
    }

    fun onEnableEditMode(): Unit {
        this.action.value = Action.UPDATE
        title.value = currentNote.value.title
        content.value = currentNote.value.content
    }

    fun showSaveNoteDialog() {
        isShowDialog.value = true;
        messageDialog.value = "Save changes ?";
    }

    fun init(action: Action, noteId: Long) {
        this.action.value = action;
        if (action != Action.ADD && noteId != -1L) {
            currentNote.value = getNoteById(noteId)
        }
    }

    fun reset() {
        action.value = Action.NOTHING;
        title.value = ""
        content.value = ""
        isShowDialog.value = false
    }


}