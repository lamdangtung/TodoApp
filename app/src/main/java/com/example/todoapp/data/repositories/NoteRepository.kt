package com.example.todoapp.data.repositories
import com.example.todoapp.data.NoteDAO
import com.example.todoapp.data.models.Note
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class NoteRepository @Inject constructor(private val noteDAO: NoteDAO){

    val getAllNotes: Flow<List<Note>> = noteDAO.getAllNotes()

    fun getNoteByID(noteID: Long) : Flow<Note>{
        return noteDAO.getNoteById(noteID)
    }

    suspend fun createNote(note: Note) : Long{
        return noteDAO.createNote(note)
    }

    suspend fun updateNote(note: Note): Int{
        return noteDAO.updateNote(note)
    }

    suspend fun deleteNote(note: Note): Int {
        return  noteDAO.deleteNote(note)
    }

    fun searchNotesByKeyword(keyword: String) : Flow<List<Note>>{
        return noteDAO.searchNoteByKeyword(keyword)
    }

    suspend fun clearAllNotes(): Int{
        return noteDAO.clearAllNotes()
    }

}