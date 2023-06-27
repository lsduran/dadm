package com.dualser.dadm.modulo4.tarea

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.dualser.dadm.R


class RegisterActivity : AppCompatActivity() {

    private lateinit var etFirstName : EditText
    private lateinit var etLastName : EditText
    private lateinit var etEmail : EditText
    private lateinit var rgSex : RadioGroup
    private lateinit var rbSelectedSex : RadioButton
    private lateinit var etPassword : EditText
    private lateinit var etPasswordConfirm : EditText
    private lateinit var cbTermsAndConditions : CheckBox
    private lateinit var btnRegister : Button

    data class Validation(val valid: Boolean, val message: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initViews()
    }

    private fun initViews() {
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etEmail = findViewById(R.id.etEmail)
        rgSex = findViewById(R.id.rgSex)
        etPassword = findViewById(R.id.etPassword)
        etPasswordConfirm = findViewById(R.id.etPasswordConfirm)
        cbTermsAndConditions = findViewById(R.id.cbTermsAndConditions)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val validation = validInputs()
            if (validation.valid) {
                val bundle = Bundle().apply{
                    putString("EXTRA_BUNDLE_FIRSTNAME", etFirstName.text.toString())
                    putString("EXTRA_BUNDLE_LASTNAME", etLastName.text.toString())
                    putString("EXTRA_BUNDLE_EMAIL", etEmail.text.toString())
                    putString("EXTRA_BUNDLE_SEX", rbSelectedSex.text.toString())
                    putString("EXTRA_BUNDLE_PASSWORD", etPassword.text.toString())
                    putBoolean("EXTRA_BUNDLE_T&C", cbTermsAndConditions.isChecked)

                    putInt("EXTRA_BUNDLE_AGE", 15)
                }
                val profileIntent = Intent(this, ProfileActivity::class.java).apply {
                    putExtra("EXTRA_BUNDLE", bundle)
                }
                startActivity(profileIntent)
            }

            Toast.makeText(this, validation.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun validInputs(): Validation {
        if (TextUtils.isEmpty(etFirstName.text)) {
            return Validation(false, "Debe introducir su nombre")
        }

        if (TextUtils.isEmpty(etLastName.text)) {
            return Validation(false, "Debe introducir su apellido")
        }

        if (TextUtils.isEmpty(etEmail.text)) {
            return Validation(false, "Debe introducir su correo electrónico")
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()) {
            return Validation(false, "Introduzca un correo electrónico válido")
        }

        val selectedId: Int = rgSex.checkedRadioButtonId
        if (selectedId == -1) {
            return Validation(false, "Seleccione su sexo")
        }
        rbSelectedSex = findViewById<View>(selectedId) as RadioButton

        if (TextUtils.isEmpty(etPassword.text)) {
            return Validation(false, "Introduzca una contraseña")
        }

        if (etPassword.text.length < 8) {
            return Validation(false, "Su contraseña debe tener al menos 8 caracteres")
        }

        if (etPasswordConfirm.text.toString() != etPassword.text.toString()) {
            return Validation(false, "Confirme su contraseña, las contraseñas no coinciden")
        }

        if (!cbTermsAndConditions.isChecked) {
            return Validation(false, "Debe aceptar los términos y condiciones")
        }

        return Validation(true, "Se ha registrado correctamente")
    }
}