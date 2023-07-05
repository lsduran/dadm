package com.dualser.dadm.modulo4.proyecto.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.dualser.dadm.R
import com.dualser.dadm.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity(R.layout.activity_dashboard) {

    private lateinit var binding : ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
                openInitActivity()
            }
        })
    }

    private fun openInitActivity() {
        val initIntent = Intent(this, InitActivity::class.java)
        startActivity(initIntent)
    }
}