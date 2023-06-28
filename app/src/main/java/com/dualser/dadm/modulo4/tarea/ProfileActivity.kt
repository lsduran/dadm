package com.dualser.dadm.modulo4.tarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.dualser.dadm.R

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvFullName : TextView
    private lateinit var tvEmail : TextView
    private lateinit var tvSex : TextView
    private lateinit var etPassword : EditText
    private lateinit var btnEdit : Button
    private lateinit var btnLogout : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initViews()
    }

    private fun initViews() {
        tvFullName = findViewById(R.id.tvFullName)
        tvEmail = findViewById(R.id.tvEmail)
        tvSex = findViewById(R.id.tvSex)
        etPassword = findViewById(R.id.etPassword)
        btnEdit = findViewById(R.id.btnEdit)
        btnLogout = findViewById(R.id.btnLogout)

        val bundleProfile = intent?.getBundleExtra("EXTRA_BUNDLE")
        bundleProfile?.let {
            val firstName = it.getString("EXTRA_BUNDLE_FIRSTNAME")
            val lastName = it.getString("EXTRA_BUNDLE_LASTNAME")
            val email = it.getString("EXTRA_BUNDLE_EMAIL")
            val sex = it.getString("EXTRA_BUNDLE_SEX")
            val password = it.getString("EXTRA_BUNDLE_PASSWORD")

            tvFullName.text = "$firstName $lastName"
            tvEmail.text = email
            etPassword.setText(password)
            tvSex.text = sex.toString()
        }

        btnEdit.setOnClickListener {
            if (etPassword.text.length < 8) {
                Toast.makeText(this, "Su contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Su contraseña ha sido modificada", Toast.LENGTH_SHORT).show()
            }

        }

        btnLogout.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}