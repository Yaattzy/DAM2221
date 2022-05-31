package com.example.crudpractica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.crudpractica.adapter.MusicAdapter
import com.example.crudpractica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mMusicViewModel: MusicViewModel
    // private var mMusicViewModel: MusicViewModel by viewModels<MusicViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mMusicViewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
        binding.mViewModel = mMusicViewModel
        binding.lifecycleOwner = this

        binding.fabAgregar.setOnClickListener {
            val intent = Intent(this, AgregarActivity::class.java)
            startActivity(intent)
        }

        configRV()

    }

    private fun configRV() {
        binding.rv.setHasFixedSize(true)
        // Pasarle los datos al rv por medio del adaptador
        displayData()
    }

    private fun displayData() {
        // Obsevador de live data con respecto a la lista

        mMusicViewModel.musicList.observe(this, Observer {
            binding.rv.adapter = MusicAdapter(it){
                music ->
                // Toast.makeText(this, music.name, Toast.LENGTH_SHORT).show()
                // Navegar a detalle del objeto
                val intent = Intent(this, DetalleActivity::class.java)
                intent.putExtra("mId", music.id)
                startActivity(intent)
            }
        })
    }
}