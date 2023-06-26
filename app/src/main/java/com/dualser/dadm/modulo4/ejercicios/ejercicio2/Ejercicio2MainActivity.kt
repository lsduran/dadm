package com.dualser.dadm.modulo4.ejercicios.ejercicio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dualser.dadm.R

class Ejercicio2MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2_main)

        val btnFrame = findViewById<Button>(R.id.btnFrame)
        val btnLinear = findViewById<Button>(R.id.btnLinear)
        val btnRelative = findViewById<Button>(R.id.btnRelative)
        val btnConstraint = findViewById<Button>(R.id.btnConstraint)
        val btnViews = findViewById<Button>(R.id.btnViews)
        val btnRecycler = findViewById<Button>(R.id.btnRecycler)

        btnFrame.setOnClickListener {
            val intent = Intent(this, FrameLayoutActivity::class.java)
            startActivity(intent)
        }

        btnLinear.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }

        btnRelative.setOnClickListener {
            val intent = Intent(this, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }

        btnConstraint.setOnClickListener {
            val intent = Intent(this, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }

        btnViews.setOnClickListener {
            val intent = Intent(this, MultipleViewsActivity::class.java)
            startActivity(intent)
        }

        btnRecycler.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }
}