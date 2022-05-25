package com.example.crudpractica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crudpractica.Music
import com.example.crudpractica.R
import com.example.crudpractica.databinding.ItemMusicBinding

class MusicAdapter(var dataset: List<Music>, private val listener: (Music) -> Unit): RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        // Vinculando los datos
        val binding = ItemMusicBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_music, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Obtener objeto a traves de posicion
        val music = dataset[position]

        // Set de los datos del objeto a los textviews a traves de la variable binding
        holder.binding.textItemName.text = music.name
        holder.binding.txtItemAuthor.text = music.author
        holder.binding.txtItemGenre.text = music.genre
        holder.binding.txtItemYear.text = music.year

        holder.binding.root.setOnClickListener {
            listener(music)
        }
    }

    override fun getItemCount(): Int = dataset.size
}