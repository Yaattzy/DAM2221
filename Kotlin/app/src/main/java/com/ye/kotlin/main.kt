package com.ye.kotlin

var numero = 3

fun incrementarNumero() {
    numero += 1
}

fun main() {
    println("**********************")
    println("VARIABLES")

    /*
    * int miVariable = 2;
    * */

    //Var: Variable mutable
    //Val: Variable inmutable

    var a: Int = 2 // Asignación inmediata
    a = 4
    var b = 3 // tipo inferido
    val c : Int
    c = 5   // Asignación diferida
    println(b)

    println("numero nuevo de arriba: $numero")
    incrementarNumero()
    println(" nuevo de arriba: $numero")

    val x = "mensaje"
    println("$x.length es ${x.length}")

    println("**********************")
    println("INSTANCIAS")

    //Class
    val persona: Persona = Persona("jose", 10)
    persona.nombre="Manuel"
    persona.presentacion()
    println(persona)

    //data class

    val usuario = Usuario("Mariana", "mariana@gmail.com")
    val usuario2 = usuario.copy(correo = "mariana@hotmail.com")
    println(usuario.correo)
    println("Los usuarios son iguales: ${if(usuario == usuario2) "si son" else "no son"}")


    // companion object
    println(hola.iva)

    // enum class
    println(Dias.Lunes.numeroDia)

}

// CLASE PERSONA

class Persona(var nombre: String, var edad: Int = 0) {
    fun presentacion() {
        println("El es $nombre y su edad es $edad")
    }
}

// DATA CLASS

data class Usuario(val nombre: String, val correo: String)

// Companion object

class hola {
    companion object {
        const val iva = "16%"
    }
}

// Enum class

enum class Dias(val numeroDia: Int, val otraCosa: String) {
    Lunes(1, "hola"),
    Martes(2, "adios"),
    Miercoles(3, "nose")
}