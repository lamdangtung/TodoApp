package com.example.todoapp.data.repositories

import com.example.todoapp.data.models.Note
import com.example.todoapp.data.models.NoteDAO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDAO: NoteDAO) {
    val getAllNotes: Flow<List<Note>> = noteDAO.getAllNotes();
    fun getNoteById(noteId: Long): Flow<Note> {
        return noteDAO.getNoteById(noteId = noteId);
    }

    suspend fun addNote(note: Note) {
        noteDAO.createNote(note)
    }

    suspend fun updateNote(note: Note) {
        noteDAO.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDAO.deleteNote(note)
    }

    fun searchNotesByKeyword(searchQuery: String): Flow<List<Note>> {
        return noteDAO.searchNoteByKeyword(keyword = searchQuery);
    }
}