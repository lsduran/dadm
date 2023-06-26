package com.dualser.dadm.modulo4.ejercicios.ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.dualser.dadm.R

class MultipleViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_views)

        val btnFraeBack = findViewById<Button>(R.id.btnBack)

        btnFraeBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val spCategories = findViewById<Spinner>(R.id.spCategories)
        val categories = arrayListOf("Acción", "Aventura", "Infantil", "Terror", "Drama", "Suspenso", "Documental", "Deportes")
        val catergoryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        catergoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCategories.adapter = catergoryAdapter
    }
}