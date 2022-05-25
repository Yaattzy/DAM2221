package com.example.crudpractica

import android.app.Application
import androidx.room.Room

class MusicApplication: Application() {

    companion object{
        lateinit var database: MusicDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this,
        MusicDatabase::class.java,
        "MusicDatabase").build()
    }

}