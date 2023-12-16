package com.example.todoapp.data.models

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.todoapp.data.NoteDAO
import com.example.todoapp.data.NoteDatabase
import com.example.todoapp.utils.AppRandom
import junit.framework.TestCase
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date

@RunWith(AndroidJUnit4::class)
class NoteDatabaseTest : TestCase() {

    private lateinit var noteDatabase: NoteDatabase
    private lateinit var noteDAO: NoteDAO


    @Before
    public override fun setUp(): Unit {
        super.setUp()
        noteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), NoteDatabase::class.java
        ).build();
        noteDAO = noteDatabase.createNoteDAO()
    }

    @After
    public override fun tearDown(): Unit {
        noteDatabase.close()
    }

    @Test
    fun testCreateNote() {
        createRandomNote()
    }

    @Test
    fun testUpdateNote() {
        val newNote = createRandomNote()
        val newContent = AppRandom.randomContent();
        newNote.content = newContent
        runBlocking {
            val numberOfUpdatedNote = noteDAO.updateNote(newNote)
            assertTrue(numberOfUpdatedNote >= 0)
            val updatedNote = noteDAO.getNoteById(newNote.id).take(1).first()
            assertEquals(updatedNote.content, newContent)
        }
    }

    @Test
    fun testDeleteNote() {
        val newNote = createRandomNote()
        runBlocking {
            val numberOfDeletedNote = noteDAO.deleteNote(newNote)
            assertTrue(numberOfDeletedNote >= 0)
            val updatedNote = noteDAO.getNoteById(newNote.id).take(1).first()
            assertNull(updatedNote)
        }
    }

    fun testGetAllNotes() {
        val numberOfNewNotes = 10
        for (i in 0..numberOfNewNotes){
            createRandomNote()
        }
        runBlocking {
            val notes = noteDAO.getAllNotes()
            assertEquals(notes.count(), numberOfNewNotes)
        }
    }

    private fun createRandomNote(): Note = runBlocking {
        val now = Date()
        val note = Note(AppRandom.randomTitle(), AppRandom.randomContent(), now, now, 0)

        val newNoteId = noteDAO.createNote(note)
        val gotNote = noteDAO.getNoteById(newNoteId).take(1).first()
        assertEquals(gotNote.title, note.title)
        assertEquals(gotNote.content, note.content)
        assertEquals(gotNote.id, newNoteId)
        assertNotNull(gotNote.updatedAt)
        assertNotNull(gotNote.createdAt)
        assertEquals(gotNote.status, 0)
        gotNote
    }


}