package com.example.ciclodevida

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ciclodevida.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var mensaje: String = "HOLA"
    private var mediaPlayer: MediaPlayer? = null
    var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("Ciclo de vida", "onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()

        binding.btnInicial.setOnClickListener {
            mensaje="OTRA COSA"
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
         Log.i("Ciclo de vida", "onStart")

        mediaPlayer = MediaPlayer.create(this, R.raw.musica)
    }

    override fun onResume() {
        super.onResume()
        Log.i("Ciclo de vida", "onResume")
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()
        Log.i("Ciclo de vida", "onPause")
        mediaPlayer?.pause()

        if(mediaPlayer != null) {
            position = mediaPlayer!!.currentPosition
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i("Ciclo de vida", "onStop")
        // Liberación de recursos
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Ciclo de vida", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Ciclo de vida", "onDestroy")
    }
}