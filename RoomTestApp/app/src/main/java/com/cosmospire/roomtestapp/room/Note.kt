package com.cosmospire.roomtestapp.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note constructor(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val title: String,
        val description: String,
        val priority: Int
)