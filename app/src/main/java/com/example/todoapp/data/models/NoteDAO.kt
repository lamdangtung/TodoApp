package com.example.todoapp.data.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.utils.AppConstraints
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {
    @Query("SELECT * FROM ${AppConstraints.NOTE_TABLE} ORDER BY id ASC")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM ${AppConstraints.NOTE_TABLE} WHERE id=:noteId LIMIT 1")
    fun getNoteById(noteId: Long): Flow<Note>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createNote(note: Note): Long

    @Update
    suspend fun updateNote(note: Note): Int

    @Delete
    suspend fun deleteNote(note: Note): Int

    @Query("DELETE FROM ${AppConstraints.NOTE_TABLE}")
    suspend fun clearAllNotes(): Int

    @Query("SELECT * FROM ${AppConstraints.NOTE_TABLE} WHERE title LIKE :keyword OR content LIKE :keyword")
    fun searchNoteByKeyword(keyword: String) : Flow<List<Note>>

}