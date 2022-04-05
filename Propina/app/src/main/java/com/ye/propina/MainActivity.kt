package com.ye.propina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ye.propina.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* setContentView(R.layout.activity_main)

        val botonCalcular: Button = findViewById(R.id.btnCalcular)
        val textoPropina = findViewById<TextView>(R.id.textTotal)

        botonCalcular.setOnClickListener {
            textoPropina.text = "Hola"
        } */

        binding.btnCalcular.setOnClickListener {
            calcularPropina()
        }
    }

    private fun calcularPropina() {
       val textCostoServicio = binding.edtImporte.text.toString()

        val costoServicio: Double? = textCostoServicio.toDoubleOrNull()

        val idSeleccion = binding.rgOpciones.checkedRadioButtonId

        val porcentajePropina= when(idSeleccion) {
            R.id.rbExcelente -> 0.20
            R.id.rbBueno -> 0.16
            else -> 0.10
        }

        var propina = costoServicio?.times(porcentajePropina)
         if(binding.swRedondear.isChecked){
             propina = propina?.let { ceil(it) }
         }

        binding.textTotal.text = propina.toString()




    }

}