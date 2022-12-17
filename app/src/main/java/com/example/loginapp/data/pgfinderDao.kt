package com.example.loginapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.loginapp.data.pgdata

@Dao
interface StudentDAO {

    @Insert
    suspend fun insertStudent(PGdata: pgdata)

    @Delete
    suspend fun deleteStudent(PGdata: pgdata)

    @Query("SELECT * FROM PGdata")
    fun getAllStudent(): LiveData<List<pgdata>>
}