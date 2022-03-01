package com.ye.nullsaflambdahof

fun main() {

    /****NULL SAFETY***/
    var mensaje: String? = "hola"

    println(mensaje?.length ?: "adios".length)

    mensaje?.let {
        println(it)
    }

    /******EXPRESIONES LAMBDA*****/




    val texto: (String) -> String = {palabra -> palabra}

    println(texto("notengoidea"))

    val cuadrado: (Int) -> Int = {numero -> numero * numero}
    println(cuadrado(2))

    /* val suma: (Int, Int) -> String = { numero1, numero2 -> "La suma es ${numero1 + numero2}"}
    println(suma(2, 4))*/

    voyAPasarUnLambda(){
        pa -> println("Mi parametro pa es: $pa")
    }

}

fun voyAPasarUnLambda(lambda: (Int) -> Unit){
    // codigo
    // mas codigo ...
    lambda(4)
}





