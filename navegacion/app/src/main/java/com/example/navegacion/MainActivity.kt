package com.example.navegacion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
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

        binding.btnNavegar2.setOnClickListener {
            navegarTerceraActividad()
        }
    }

    private fun navegarTerceraActividad() {
        val intent = Intent(this, TerceraActivity::class.java)
        intent.putExtra("tercero", "Navegando a tercera actividad")
        getResult.launch(intent)
    }

    private fun navegarSegundaActividad() {
        val intent: Intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("mensaje", "Bienvenido a segunda actividad.")
        intent.putExtra("mensaje2", "DOS DOS DOS.")
        // startActivity(intent)
        getResult.launch(intent)
    }

    private val getResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if(it.resultCode === Activity.RESULT_OK) {
            var mensaje = it.data?.getStringExtra("mensajeRegreso")
            binding.texto.text = mensaje
        }

        if(it.resultCode === 20) {
            Toast.makeText(this, it.data?.getStringExtra("valorEnviar"), Toast.LENGTH_LONG).show()
        }

        if(it.resultCode === 38) {
            Toast.makeText(this, it.data?.getStringExtra("cancelar"), Toast.LENGTH_LONG).show()
        }
    }
}