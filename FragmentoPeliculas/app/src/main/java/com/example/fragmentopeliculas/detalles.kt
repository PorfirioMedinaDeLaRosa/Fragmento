package com.example.fragmentopeliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class detalles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)


        val index = intent.getIntExtra("INDEX", 0)
        val foto = findViewById<ImageView>(R.id.imagenpelicula)

        foto.setImageResource(FragmentoLista.peliculas?.get(index)?.imagenP!!)


    }
}