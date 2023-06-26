package com.dualser.dadm.modulo4.ejercicios.ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dualser.dadm.R

class MultipleViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_views)

        val btnFraeBack = findViewById<Button>(R.id.btnBack)

        btnFraeBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}