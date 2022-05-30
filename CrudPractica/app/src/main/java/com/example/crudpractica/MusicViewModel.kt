package com.example.crudpractica

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MusicViewModel : ViewModel() {

    private val musicRepository: MusicRepository = MusicRepository()

    var _id = MutableLiveData<Long>()
    var name = MutableLiveData<String>()
    var author = MutableLiveData<String>()
    var genre = MutableLiveData<String>()
    var year = MutableLiveData<String>()

    val musicList = musicRepository.allMusic // Obtener todos los objetos


    fun save() {
        insert(
            Music(
                id= null,
                name.value.toString(),
                author.value.toString(),
                genre.value.toString(),
                year.value.toString()
            )
        )
        clean()
    }

    fun clean() {
        _id.value = 0
        name.value = ""
        author.value = ""
        year.value = ""
        genre.value = ""
    }

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

    fun deleteAll(){
        viewModelScope.launch {
            musicRepository.deleteAllMusic()
        }
    }
}