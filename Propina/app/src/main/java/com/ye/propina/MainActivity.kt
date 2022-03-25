package com.ye.propina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonCalcular: Button = findViewById(R.id.btnCalcular)
        val textoPropina = findViewById<TextView>(R.id.textTotal)

        botonCalcular.setOnClickListener {
            textoPropina.text = "Hola"
        }
    }
}