package com.dualser.dadm.modulo4.tarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.dualser.dadm.R

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvFullName : TextView
    private lateinit var tvEmail : TextView
    private lateinit var tvSex : TextView
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
        btnLogout = findViewById(R.id.btnLogout)

        val bundleProfile = intent?.getBundleExtra("EXTRA_BUNDLE")
        bundleProfile?.let {
            val firstName = it.getString("EXTRA_BUNDLE_FIRSTNAME")
            val lastName = it.getString("EXTRA_BUNDLE_LASTNAME")
            val email = it.getString("EXTRA_BUNDLE_EMAIL")
            val sex = it.getString("EXTRA_BUNDLE_SEX")

            tvFullName.text = "$firstName $lastName"
            tvEmail.text = email
            tvSex.text = sex.toString()
        }

        btnLogout.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}