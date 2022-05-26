package com.example.crudpractica

class MusicRepository() {
    // Obtener las funciones del Dao

    val musicDao = MusicApplication.database.musicDAO()

    //Obtener todos los objetos
    val allMusic = musicDao.getAllMusic()

    // Obteniendo detalle
    // Una funcion suspendida solo se puede llamar desde otra funcion suspendida
    // o una corutina
    suspend fun singleMusic(id: Long) = musicDao.get(id)

    suspend fun insertMusic(music: Music){
        musicDao.insert(music)
    }

    suspend fun updateMusic(music: Music){
        musicDao.update(music)
    }

    suspend fun deleteMusic(music: Music) {
        musicDao.delete(music)
    }

    suspend fun deleteAllMusic(){
        musicDao.deleteAll()
    }

}