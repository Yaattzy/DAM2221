package com.example.crudpractica

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Music::class], version = 1)
abstract class MusicDatabase: RoomDatabase() {

    abstract fun musicDAO(): MusicDAO
}