package com.example.fragmentopeliculas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast


class FragmentoLista : Fragment() {

    companion object{
        var peliculas : ArrayList<Pelicula>? = null
    }


    var nombrePeliculas : ArrayList<String>? = null

    var lista : ListView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_fragmento_lista, container, false)
      // return view = inflater.inflate(R.layout.fragment_fragmento_lista, container, false)
        peliculas = ArrayList()
        peliculas?.add(Pelicula("La quinta ola", R.drawable.laola))
        peliculas?.add(Pelicula("La muejer maravilla", R.drawable.mujermaravilla))
        peliculas?.add(Pelicula("Scorpion", R.drawable.scorpion))
        peliculas?.add(Pelicula("Hawail 5 0", R.drawable.hawail))
        peliculas?.add(Pelicula("Kick Ass  2", R.drawable.kick))

        nombrePeliculas = obtenerNombrePelicula(peliculas!!)

        val adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, nombrePeliculas!!)

        lista = view.findViewById(R.id.listaP)

        lista?.adapter = adapter

        lista?.setOnItemClickListener { parent, view, position, id ->

            //Toast.makeText(view.context, nombrePeliculas?.get(position), Toast.LENGTH_LONG).show()

            val intent = Intent(view.context, detalles::class.java)
            intent.putExtra("INDEX", position)
            startActivity(intent)

        }

            return view
    }

    fun obtenerNombrePelicula(peliculas : ArrayList<Pelicula>) : ArrayList<String>{
        val nombres = ArrayList<String>()
        for(pelicula in peliculas){
            nombres.add(pelicula.nombreP)
        }

        return nombres
    }


}