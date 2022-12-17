package com.example.loginapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "PGdata")
data class pgdata(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name: String,
    val age: Int,
    val createdDate: Date,
    val isPresent: Int

)
