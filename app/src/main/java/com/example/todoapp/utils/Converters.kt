package com.example.todoapp.utils

import androidx.room.TypeConverter
import java.util.Date

public class Converters {
    @TypeConverter
    public fun fromTimestamp(value: Long): Date {
        return Date(value)

    }

    @TypeConverter
    public fun toTimestamp(date: Date): Long {
        return date.time
    }


}