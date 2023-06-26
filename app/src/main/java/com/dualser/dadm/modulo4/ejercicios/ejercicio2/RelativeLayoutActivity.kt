package com.dualser.dadm.modulo4.ejercicios.ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dualser.dadm.R

class RelativeLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        val btnFraeBack = findViewById<Button>(R.id.btnBack)

        btnFraeBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}