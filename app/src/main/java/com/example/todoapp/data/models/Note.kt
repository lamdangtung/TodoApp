package com.example.todoapp.data.models

import androidx.compose.ui.unit.Constraints
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.todoapp.utils.AppConstraints
import com.example.todoapp.utils.Converters
import java.util.Date

@Entity(tableName = AppConstraints.NOTE_TABLE)
@TypeConverters(Converters::class)
data class Note(

    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "content")
    var content: String,
    @ColumnInfo(name = "created_at")
    val createdAt: Date,
    @ColumnInfo(name = "updated_at")
    var updatedAt: Date,
    @ColumnInfo(name = "status")
    var status: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}
