package com.dualser.dadm.modulo4.sesion20230623

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dualser.dadm.R
import com.dualser.dadm.modulo4.ejercicios.ejercicio1.IntentExplicitoFirstActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btCallFirstActivity = findViewById<Button>(R.id.btCallFirstActivity)

        btCallFirstActivity.setOnClickListener {
            val intentFirstActivity = Intent(this, IntentExplicitoFirstActivity::class.java)
            startActivity(intentFirstActivity)
        }
    }
}