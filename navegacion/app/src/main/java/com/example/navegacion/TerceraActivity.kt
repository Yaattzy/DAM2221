package com.example.navegacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.navegacion.databinding.ActivityTerceraBinding

class TerceraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTerceraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTerceraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
            Toast.makeText(this, it.getString("tercero"), Toast.LENGTH_SHORT).show()
        }

        binding.btnEnviar.setOnClickListener {
            var editText = binding.edtTercera.text.toString()
            val intent = Intent()
            intent.putExtra("valorEnviar", editText)
            setResult(20, intent)
            finish()
        }

        binding.btnCancelar.setOnClickListener {
            val intent = Intent()
            intent.putExtra("cancelar", "Acción de cancelar")
            setResult(38, intent)
            finish()
        }


    }
}