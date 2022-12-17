package com.example.loginapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [pgdata::class], version = 1)
@TypeConverters(Convertor::class)
abstract class pgmaindatabase : RoomDatabase() {
    abstract fun pgDao(): pgmaindatabase

    companion object {

        val migration_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student ADD COLUMN isPresent INTEGER NOT NULL DEFAULT(1)")
            }
        }

        @Volatile
        private var INSTANCE: pgmaindatabase? = null


        fun getDatabase(context: Context): pgmaindatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        pgmaindatabase::class.java,
                        "studentDB"
                    )
                        .addMigrations(migration_1_2)
                        .build()
                }
            }

            return INSTANCE!!
        }
    }