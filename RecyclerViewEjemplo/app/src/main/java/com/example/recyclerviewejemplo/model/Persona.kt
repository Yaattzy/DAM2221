package com.example.recyclerviewejemplo.model

data class Persona(
    val id: Int,
    var nombre: String,
    var apellido: String,
    var telefono: String,
    var foto: String
) {
    val nombreCompleto: String = "$nombre $apellido"
}
