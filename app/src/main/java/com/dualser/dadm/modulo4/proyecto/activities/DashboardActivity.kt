package com.dualser.dadm.modulo4.proyecto.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.dualser.dadm.R
import com.dualser.dadm.databinding.ActivityDashboardBinding
import com.dualser.dadm.modulo4.proyecto.fragments.MoviesFragment
import com.dualser.dadm.modulo4.proyecto.fragments.ProfileFragment
import com.dualser.dadm.modulo4.proyecto.fragments.RegisterFragment
import com.dualser.dadm.modulo4.proyecto.models.User
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val EXTRA_USER = "EXTRA_USER"
class DashboardActivity : AppCompatActivity(R.layout.activity_dashboard) {

    private lateinit var binding : ActivityDashboardBinding

    private lateinit var user : User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(MoviesFragment.newInstance(), "FragmentMovies")

        user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(EXTRA_USER, User::class.java)!!
        } else {
            intent.getSerializableExtra(EXTRA_USER) as User
        }

        showToast(String.format(getString(R.string.logged_in_as),user.username))

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                openInitActivity()
                finish()
                showToast(getString(R.string.logged_out))
            }
        })

        binding.bnvMenu.setOnItemSelectedListener {
            Log.i("DashboardActivity", "Bottom Navigation View clicked")
            when (it.itemId) {
                R.id.itemMovies -> {
                    loadFragment(MoviesFragment.newInstance(), "FragmentMovies")
                    true
                }
                R.id.itemProfile -> {
                    loadFragment(ProfileFragment.newInstance(user), "FragmentProfile")
                    true
                }
                else -> {
                    loadFragment(MoviesFragment.newInstance(), "FragmentMovies")
                    true
                }
            }
        }
    }

    private fun openInitActivity() {
        val initIntent = Intent(this, InitActivity::class.java)
        startActivity(initIntent)
    }

    // Basado en el código de https://www.geeksforgeeks.org/bottom-navigation-bar-in-android-using-kotlin/
    private fun loadFragment(fragment : Fragment, fragmentName : String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.dashboardFragmentContainer, fragment)
            .addToBackStack(fragmentName)
            .commit()
    }

    private fun showToast(message : String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.BOTTOM,0, 200)
        toast.show()
    }
}