package com.dualser.dadm.modulo4.ejercicios.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.dualser.dadm.R

class IntentExplicitoFirstActivity : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if(result.resultCode == RESULT_OK) {
            if(result.data?.getBooleanExtra("EXTRA_BACK_HOME", false) == true) {
                Toast.makeText(this, "Volviendo a Home...", Toast.LENGTH_SHORT).show()
                onBackPressedDispatcher.onBackPressed()
            } else {
                Toast.makeText(this, "resultCode = ${result.resultCode} ${result.data?.getStringExtra("EXTRA_FIRSTNAME")} ${result.data?.getStringExtra("EXTRA_LASTNAME")} ${result.data?.getStringExtra("EXTRA_AGE")} ", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "resultCode = ${result.resultCode} - CANCELLED", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_explicito_first)
        initViews()
    }

    private fun initViews() {
        initButtonOpen()
    }

    private fun initButtonOpen() {
        val btnOpen = findViewById<Button>(R.id.btnOpen)

        btnOpen.setOnClickListener {
            val bundle = Bundle().apply{
                putString("EXTRA_BUNDLE_FIRSTNAME", "Luis")
                putString("EXTRA_BUNDLE_LASTNAME", "D.")
                putInt("EXTRA_BUNDLE_AGE", 15)
            }
            val secondIntent = Intent(this, IntentExplicitoSecondActivity::class.java).apply {
                putExtra("EXTRA_BUNDLE", bundle)
            }
            register.launch(secondIntent)
        }
    }
}