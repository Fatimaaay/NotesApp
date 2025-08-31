package com.example.notesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao{
@Insert
    suspend fun insertNote(note:Note)
    @Update
    suspend fun updateNote(note:Note)
    @Delete
    suspend fun deleteNote(note:Note)
    @Query("SELECT * FROM notes WHERE userId = :userId ORDER BY dateCreated DESC")
    fun getNotesByUser(userId: Int): Flow<List<Note>>  //“This function doesn’t just return the notes once, it returns a stream of notes.
                                             //  If notes in the database change, the UI can observe these changes automatically.

}
