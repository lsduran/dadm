package com.dualser.dadm.modulo4.ejercicios.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.dualser.dadm.R

class IntentExplicitoSecondActivity : AppCompatActivity() {

    private var tvFirstName : TextView? = null
    private var tvLastName : TextView? = null
    private var tvAge : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_explicito_second)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initViews()
    }

    private fun initViews() {
        configureTextViews()
        configureButtonBack()
        configureButtonHome()
    }

    private fun configureButtonBack() {
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            val returnIntent = Intent().apply {
                putExtra("EXTRA_IS_OK", true)
                putExtra("EXTRA_FIRSTNAME", tvFirstName?.text)
                putExtra("EXTRA_LASTNAME", tvLastName?.text)
                putExtra("EXTRA_AGE", tvAge?.text)
            }
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }

    private fun configureButtonHome() {
        val btnHome = findViewById<Button>(R.id.btnHome)

        btnHome.setOnClickListener {
            val returnIntent = Intent().apply {
                putExtra("EXTRA_IS_OK", true)
                putExtra("EXTRA_BACK_HOME", true)
            }
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }

    private fun configureTextViews() {

        tvFirstName = findViewById(R.id.tvFirstName)
        tvLastName = findViewById(R.id.tvLastName)
        tvAge = findViewById(R.id.tvAge)

        val bundleProfile = intent?.getBundleExtra("EXTRA_BUNDLE")
        bundleProfile?.let {
            val firstName = it.getString("EXTRA_BUNDLE_FIRSTNAME")
            val lastName = it.getString("EXTRA_BUNDLE_LASTNAME")
            val age = it.getInt("EXTRA_BUNDLE_AGE", 0)

            tvFirstName?.text = firstName
            tvLastName?.text = lastName
            tvAge?.text = age.toString()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                val returnIntent = Intent().apply {
                    putExtra("EXTRA_IS_OK", true)
                    putExtra("EXTRA_FIRSTNAME", tvFirstName?.text)
                    putExtra("EXTRA_LASTNAME", tvLastName?.text)
                    putExtra("EXTRA_AGE", tvAge?.text)
                }
                setResult(RESULT_OK, returnIntent)
                // finish() // destruye la actividad con el layout
                onBackPressedDispatcher.onBackPressed() // Saca la actividad de la pila, si ho hay, la actividad se destruye
            }
        }
        return super.onOptionsItemSelected(item)
    }

}