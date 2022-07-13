package com.example.tallerejecutandoservicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.example.tallerejecutandoservicios.Services.DogsImageService
import com.example.tallerejecutandoservicios.Services.RetroFitGeneration
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Llamado de servicio y ejecicion

        val retrofit = RetroFitGeneration.getInstance()

        //Llamada del contenedor de la imagen
        val image = findViewById<ImageView>(R.id.Image)

        //Creacion del proceso de ejecucion del servicio
        val dogImageService = retrofit.create(DogsImageService::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = dogImageService.getRandomDogImage()
            if (response.isSuccessful) {
                val randomDogImageDto = response.body()
                Log.d("Developer", "Response:  $randomDogImageDto")
                runOnUiThread{
                    Picasso.get().load(randomDogImageDto?.message).into(image)
                }
            }
        }

    }
}