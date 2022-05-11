package com.example.recyclerviewejemplo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewejemplo.R
import com.example.recyclerviewejemplo.databinding.ItemPersonaBinding
import com.example.recyclerviewejemplo.model.Persona

class PersonaAdapter(private val context: Context, private val dataset: List<Persona>)
    : RecyclerView.Adapter<PersonaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemPersonaBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Inflar vista
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_persona, parent, false)
        // Retorna una instancia de nuestra clase viewHolder y se pasa la vista en el constructor
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val persona = dataset[position]

        with(holder) {
            binding.txtPersonaNombre.text = persona.nombreCompleto
        }
    }

    override fun getItemCount(): Int = dataset.size
}