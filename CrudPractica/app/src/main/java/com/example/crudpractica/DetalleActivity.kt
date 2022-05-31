package com.example.crudpractica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.crudpractica.databinding.ActivityAgregarBinding
import com.example.crudpractica.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetalleBinding
    lateinit var mMusicViewModel: MusicViewModel

    var id: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detalle)

        mMusicViewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
        binding.mViewModel = mMusicViewModel
        binding.lifecycleOwner = this

        intent.extras?.let {
            id = it.getLong("mId")
        }

        mMusicViewModel.editOrDelete(id)

        binding.btnEliminarUno.setOnClickListener {
            mMusicViewModel.deleteOne()
            finish()
        }

        binding.btnActualizarItem.setOnClickListener {
            // Guardar nuestro objeto y validaciones

            var error = false
            if(TextUtils.isEmpty(mMusicViewModel.name.value)){
                binding.edtNombre.error= "El nombre es obligatorio"
                error = true
            } else {
                binding.edtNombre.error = null
            }

            if(!error ){
                mMusicViewModel.edit()
                finish()
            }
        }
    }
}