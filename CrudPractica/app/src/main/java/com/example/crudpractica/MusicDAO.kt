package com.example.crudpractica

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MusicDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(music: Music) : Long

    @Update
    suspend fun update(music: Music)

    @Delete
    suspend fun delete(music: Music)

    @Query("DELETE FROM music_entity")
    suspend fun deleteAll()

    @Query("SELECT * FROM music_entity WHERE id = :key")
    suspend fun get(key: Long): Music? // en caso de no encontrar nada retorna nulo

    @Query("SELECT * FROM music_entity")
    fun getAllMusic(): LiveData<List<Music>>
}