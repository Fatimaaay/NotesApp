package com.example.notesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task:Task)
    @Update
    suspend fun updateTask(task:Task)
    @Delete
    suspend fun deleteTask(task:Task)
    @Query("SELECT* FROM tasks ORDER BY dueDate DESC")
    fun getALLTASK(): Flow<List<Task>>
}

