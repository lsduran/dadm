package com.dualser.dadm.modulo4.proyecto.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.dualser.dadm.R
import com.dualser.dadm.databinding.FragmentLoginBinding
import com.dualser.dadm.databinding.FragmentSendParamsBinding
import com.dualser.dadm.modulo4.componentesgraficos.Person
import com.dualser.dadm.modulo4.fragments.ReceiveParamsFragment
import com.dualser.dadm.modulo4.proyecto.activities.DashboardActivity
import com.dualser.dadm.modulo4.proyecto.models.User
import com.dualser.dadm.modulo4.proyecto.models.Validation
import com.dualser.dadm.modulo4.tarea.RegisterActivity

private const val EXTRA_USER = "EXTRA_USER"

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding : FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)

        binding.tvRegister.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.initFragmentContainer, RegisterFragment.newInstance())
                .addToBackStack("FragmentRegister")
                .commit()
        }

        binding.btnLogin.setOnClickListener {
            val validate = ValidateLogin()
            if ( validate.valid ) {
                val user = User(username = binding.etUsername.text.toString())
                val dashboardIntent = Intent(requireContext(), DashboardActivity::class.java).apply {
                    putExtra(EXTRA_USER, user)
                }
                startActivity(dashboardIntent)
                activity?.finish()
            } else {
                Toast.makeText(requireContext(), validate.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    private fun ValidateLogin() : Validation {

        if (TextUtils.isEmpty(binding.etUsername.text)) {
            return Validation(false, getString(R.string.login_username_empty))
        }

        if (TextUtils.isEmpty(binding.etPassword.text)) {
            return Validation(false, getString(R.string.login_password_empty))
        }

        if (binding.etPassword.text.toString() != "12345678") {
            return Validation(false, getString(R.string.login_password_wrong))
        }

        return Validation(true, getString(R.string.login_success))
    }
}