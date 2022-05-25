package com.example.crudpractica

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "music_entity")
data class Music(
    @PrimaryKey(autoGenerate = true) val id: Long? = 0L,
    var name: String = "",
    var genre: String ="",
    var author: String ="",
    var year: String =""
)