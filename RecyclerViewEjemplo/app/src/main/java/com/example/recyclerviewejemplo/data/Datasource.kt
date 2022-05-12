package com.example.recyclerviewejemplo.data

import com.example.recyclerviewejemplo.model.Persona

class Datasource {

    fun cargarDatos(): List<Persona> {
        return listOf<Persona>(
            Persona(1, "Ana", "Lopez", "66737847585", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"),
            Persona(2, "Jorge", "Perez", "6672345673", "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg")
        )
    }
}