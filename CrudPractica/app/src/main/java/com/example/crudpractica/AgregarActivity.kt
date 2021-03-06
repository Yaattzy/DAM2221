package com.example.crudpractica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.crudpractica.databinding.ActivityAgregarBinding
import com.example.crudpractica.databinding.ActivityMainBinding

class AgregarActivity : AppCompatActivity() {

    lateinit var binding: ActivityAgregarBinding
    lateinit var mMusicViewModel: MusicViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_agregar)

        mMusicViewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
        binding.mViewModel = mMusicViewModel
        binding.lifecycleOwner = this

        binding.btnAgregarItem.setOnClickListener {
            // Guardar nuestro objeto y validaciones

            var error = false
            if(TextUtils.isEmpty(mMusicViewModel.name.value)){
                binding.edtNombre.error= "El nombre es obligatorio"
                error = true
            } else {
                binding.edtNombre.error = null
            }

            if(!error ){
                mMusicViewModel.save()
                finish()
            }
        }

    }
}