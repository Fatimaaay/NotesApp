package com.example.notesapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity = Table
//represent single note in database
//Create tables:
//
//Notes (id, title, description, category, dateCreated, colorTag)
//
//Tasks (id, title, description, dueDate, isCompleted)

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int,
    val title: String,
    val description: String,
    val category: String,
    val dateCreated: Long = System.currentTimeMillis(),
    val colorTag: String
)
@Entity(tableName = "Tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id :Int = 0,
    val userId: Int,
    val title: String,
    val description: String,
    val dueDate: Long,
    val isCompleted: Boolean = false
)
