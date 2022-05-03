package com.example.navegacion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navegacion.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaBinding
    private var detalle: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let { bundle ->
            detalle = bundle.getString("mensaje").toString()
        }

        binding.textSegunda.text = detalle

        binding.btnRegresar.setOnClickListener {
            // val intent = Intent(this, MainActivity::class.java)
            // startActivity(intent)

            val intent = Intent()
            intent.putExtra("mensajeRegreso", "Regresando valor de segunda actividad")
            setResult(Activity.RESULT_OK, intent) // codigo de resultado + intent
            finish()
        }
    }
}