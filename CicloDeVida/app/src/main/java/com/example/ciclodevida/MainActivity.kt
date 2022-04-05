package com.example.ciclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ciclodevida.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var mensaje: String = "HOLA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()

        binding.btnInicial.setOnClickListener {
            mensaje="OTRA COSA"
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }

    }
}