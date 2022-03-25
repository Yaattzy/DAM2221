package com.example.miprimerapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textoMensaje: TextView = findViewById(R.id.textoMensaje)
        val editTextNombre = findViewById<EditText>(R.id.edtNombre)
        val botonAceptar = findViewById<Button>(R.id.btnAceptar)
        val editTextColor = findViewById<EditText>(R.id.edtColor)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.ConstraintLayout)


        textoMensaje.text = "Bienvenido"

        var nombre: String? = null
        var color: String? = null

        botonAceptar.setOnClickListener {
            nombre = editTextNombre.text.toString()
            color = editTextColor.text.toString()
            Toast.makeText(this, "Bienvenido de nuevo $nombre", Toast.LENGTH_SHORT).show()
            constraintLayout.setBackgroundColor(Color.parseColor(color))
        }

    }
}