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

    println("**********************")
    println("FUNCIONES")

    println(suma(2,3))
    println(suma2(2,3))
    imprimirSuma(4,7)

    println("**********************")
    println("CONTROL DE FLUJO")

    println("----IF/ELSE")

    var num1 = 1
    var num2 = 5
    var numMax: Int

    numMax = if(num1 > num2) {
        num1
    } else {
        num2
    }

    println("El mayor es $numMax")

    num1 = 6
    if(num1 > num2) numMax = num1 else numMax = num2

    println("El mayor es $numMax")

    num1 = 3
    numMax = if (num1 > num2) num1 else num2

    println("El mayor es $numMax")

    val numEstudiantes = 20

    if(numEstudiantes in 1..100){
        println(numEstudiantes)
    }

    println("---WHEN")

    var r = 20

    when(r){
        1 -> {println("r es 1")}
        2 -> {println("r es 2")}
        3 -> {println("r es 3")}
        5, 6 -> {println("r es 5 o 6")}
        else -> {println("r no es ninguna de las opciones")}
    }

    when(r) {
        in 1..10 -> println("r esta en el rango")
        !in 10..20 -> println("r no esta en este rango")
        else -> println("No se encontro una opcion")
    }



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

// Funciones

fun suma(numero1: Int, numero2: Int): Int {
    return numero1 + numero2
}

fun suma2(numero1: Int, numero2: Int) = numero1 + numero2

fun imprimirSuma(a: Int, b: Int) : Unit {
    println("La suma de a: $a y b: $b es ${a+b}")
}
