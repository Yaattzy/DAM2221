package com.example.navegacion

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
            detalle = bundle.getString("mensaje2").toString()
        }

        binding.textSegunda.text = detalle
    }
}