package com.example.recyclerviewejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recyclerviewejemplo.adapter.PersonaAdapter
import com.example.recyclerviewejemplo.data.Datasource
import com.example.recyclerviewejemplo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val personaAdapter = PersonaAdapter(this, Datasource().cargarDatos()){
            Toast.makeText(this, it.nombreCompleto, Toast.LENGTH_LONG).show()
            // intent
        }

        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter= personaAdapter
        }
    }
}