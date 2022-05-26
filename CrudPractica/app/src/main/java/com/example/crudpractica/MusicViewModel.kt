package com.example.crudpractica

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MusicViewModel : ViewModel() {

        private val musicRepository: MusicRepository = MusicRepository()

    val musicList = musicRepository.allMusic // Obtener todos los objetos

    // Métodos del repositorio

    fun insert(music: Music) {
        viewModelScope.launch {
            musicRepository.insertMusic(music)
        }
    }

    fun update(music: Music){
        viewModelScope.launch {
            musicRepository.updateMusic(music)
        }
    }

    fun delete(music: Music){
        viewModelScope.launch {
            musicRepository.deleteMusic(music)
        }
    }

    fun deleteAll(music: Music){
        viewModelScope.launch {
            musicRepository.deleteAllMusic()
        }
    }
}