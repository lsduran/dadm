package com.dualser.dadm.modulo4.ejercicios.ejercicio1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dualser.dadm.R

class IntentImplicitoActivity : AppCompatActivity() {
    var btnSendEmail : Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_implicito)

        val btnSend = findViewById<Button>(R.id.btnSend)
        val btnUrl = findViewById<Button>(R.id.btnUrl)

        btnSend.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Aviso")
                putExtra(Intent.EXTRA_TEXT, "Esto es una prueba para enviar correo mediante un intent implícito")
            }

            startActivity(Intent.createChooser(emailIntent, "Enviar email usando..."))
        }

        btnUrl.setOnClickListener {
            var urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.unam.mx/"))
            startActivity(urlIntent)
        }
    }
}