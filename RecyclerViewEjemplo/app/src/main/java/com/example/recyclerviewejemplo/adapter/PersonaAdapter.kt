package com.example.recyclerviewejemplo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.recyclerviewejemplo.R
import com.example.recyclerviewejemplo.databinding.ItemPersonaBinding
import com.example.recyclerviewejemplo.model.Persona
// Lambda
// (Tipos de datos de parametros) -> TipoDeDato de Retorno

class PersonaAdapter(private val context: Context, private val dataset: List<Persona>, private val listener: (Persona) -> Unit)
    : RecyclerView.Adapter<PersonaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Vincular los componentes del layout con nuestra clase
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
            binding.root.setOnClickListener {
                listener(persona)
            }

            binding.txtPersonaNombre.text = persona.nombreCompleto

            Glide.with(context)
                .load(persona.foto)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.ivPersonaFoto)
        }

    }

    override fun getItemCount(): Int = dataset.size


}