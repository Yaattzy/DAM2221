package com.example.navegacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navegacion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavegar1.setOnClickListener {
            navegarSegundaActividad()
        }

    }

    private fun navegarSegundaActividad() {

        val intent: Intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("mensaje", "Bienvenido a segunda actividad.")
        intent.putExtra("mensaje2", "DOS DOS DOS.")
        startActivity(intent)

    }
}