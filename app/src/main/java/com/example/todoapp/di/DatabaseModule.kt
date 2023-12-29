package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.models.Note
import com.example.todoapp.data.models.NoteDatabase
import com.example.todoapp.utils.AppConstraints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        AppConstraints.DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: NoteDatabase) = database.createNoteDAO()

}
