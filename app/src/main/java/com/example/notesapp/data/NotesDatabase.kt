package com.example.notesapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities= [Note::class, Task::class], version = 1, exportSchema = false   )  //Entities → These are the tables in the database //Version → Room database version. You increment it when you change the schema.
abstract class AppDatabase: RoomDatabase() { //AppDatabase is your Room database class.Purpose:connect all DAOs to database
    abstract fun notesDao(): NoteDao//“Generate code that gives me an implementation of NotesDao and TasksDao when I access the database
    abstract fun tasksDao(): TaskDao // You call these functions in your code to get the DAO, which is what your UI/ViewModel/Repository will use to interact with the database

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
            }
            return INSTANCE!!
        }
    }
}
