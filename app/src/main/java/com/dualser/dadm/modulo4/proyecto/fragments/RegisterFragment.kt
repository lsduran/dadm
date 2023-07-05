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
import com.dualser.dadm.databinding.FragmentRegisterBinding
import com.dualser.dadm.modulo4.proyecto.activities.DashboardActivity
import com.dualser.dadm.modulo4.proyecto.models.User
import com.dualser.dadm.modulo4.proyecto.models.Validation
import com.dualser.dadm.modulo4.tarea.RegisterActivity

private const val EXTRA_USER = "EXTRA_USER"

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)

        binding.btnRegister.setOnClickListener {
            val validate = validInputs()
            if ( validate.valid ) {
                val user = User(
                    firstName = binding.etFirstName.text.toString(),
                    lastName = binding.etLastName.text.toString(),
                    username = binding.etUsername.text.toString(),
                    sex = (view.findViewById<View>(binding.rgSex.checkedRadioButtonId) as RadioButton).text.toString()
                )
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
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }

    private fun validInputs(): Validation {
        if (TextUtils.isEmpty(binding.etFirstName.text)) {
            return Validation(false, getString(R.string.register_firstname_empty))
        }

        if (TextUtils.isEmpty(binding.etLastName.text)) {
            return Validation(false, getString(R.string.register_lastname_empty))
        }

        if (TextUtils.isEmpty(binding.etUsername.text)) {
            return Validation(false, getString(R.string.register_username_empty))
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(binding.etUsername.text.toString()).matches()) {
            return Validation(false, getString(R.string.register_username_invalid))
        }

        val selectedId: Int = binding.rgSex.checkedRadioButtonId
        if (selectedId == -1) {
            return Validation(false, getString(R.string.register_sex_empty))
        }

        if (TextUtils.isEmpty(binding.etPassword.text)) {
            return Validation(false, getString(R.string.register_password_empty))
        }

        if (binding.etPassword.text.length < 8) {
            return Validation(false, getString(R.string.register_password_invalid))
        }

        if (binding.etPasswordConfirm.text.toString() != binding.etPassword.text.toString()) {
            return Validation(false, getString(R.string.register_confirm_password_no_match))
        }

        if (!binding.cbTermsAndConditions.isChecked) {
            return Validation(false, getString(R.string.register_terms_and_cond_accept))
        }

        if (!binding.cbPrivacyPolicy.isChecked) {
            return Validation(false, getString(R.string.register_privacy_policy_accept))
        }

        return Validation(true, getString(R.string.register_success))
    }
}