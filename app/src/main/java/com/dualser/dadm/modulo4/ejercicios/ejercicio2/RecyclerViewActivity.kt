package com.dualser.dadm.modulo4.ejercicios.ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dualser.dadm.R
import com.dualser.dadm.modulo4.componentesgraficos.Person
import com.dualser.dadm.modulo4.componentesgraficos.PersonAdapter

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val btnFraeBack = findViewById<Button>(R.id.btnBack)

        btnFraeBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val rvContent = findViewById<RecyclerView>(R.id.rvContent)
        val contentAdapter = ContentAdapter(arrayListOf(
            Content("0", "Película 1", "Película", arrayOf("Plataforma 1", "Plataforma 2", "Plataforma 3")),
            Content("1", "Serie 1", "Serie", arrayOf("Plataforma 1")),
            Content("2", "Película 2", "Película", arrayOf("Plataforma 2")),
            Content("3", "Película 3", "Película", arrayOf("Plataforma 2", "Plataforma 3")),
            Content("4", "Serie 2", "Serie", arrayOf("Plataforma 1", "Plataforma 3")),
            Content("5", "Serie 3", "Serie", arrayOf("Plataforma 1", "Plataforma 3")),
            Content("6", "Serie 4", "Serie", arrayOf("Plataforma 1")),
            Content("7", "Película 4", "Película", arrayOf("Plataforma 3")),
            Content("8", "Película 5", "Película", arrayOf("Plataforma 2")),
            Content("9", "Película 6", "Película", arrayOf("Plataforma 2")),
            Content("10", "Película 7", "Película", arrayOf("Plataforma 1", "Plataforma 2", "Plataforma 3")),
            Content("11", "Serie 5", "Serie", arrayOf("Plataforma 2", "Plataforma 3")),
            Content("12", "Serie 6", "Serie", arrayOf("Plataforma 1", "Plataforma 3")),
            Content("13", "Película 8", "Película", arrayOf("Plataforma 1", "Plataforma 3")),
            Content("14", "Película 9", "Película", arrayOf("Plataforma 2", "Plataforma 3")),
            Content("15", "Serie 7", "Serie", arrayOf("Plataforma 3")),
            Content("16", "Serie 8", "Serie", arrayOf("Plataforma 1", "Plataforma 2")),
        ))

        rvContent.adapter = contentAdapter
        rvContent.layoutManager = LinearLayoutManager(this)
    }
}