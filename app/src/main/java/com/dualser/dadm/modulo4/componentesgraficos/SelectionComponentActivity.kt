package com.dualser.dadm.modulo4.componentesgraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import com.dualser.dadm.R
import com.dualser.dadm.databinding.ActivitySelectionComponentBinding

class SelectionComponentActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySelectionComponentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Checkbox
        binding.cbCreditCard.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_SHORT).show()
        }

        // RadioButton
        binding.rgSex.setOnCheckedChangeListener { view, checkedId ->
            val sex = when(checkedId) {
                R.id.rbMan -> {
                    binding.cbCreditCard.visibility = View.GONE
                }
                R.id.rbWoman -> binding.cbCreditCard.visibility = View.VISIBLE
                R.id.rbOther -> binding.cbCreditCard.visibility = View.INVISIBLE
                else -> "Desconocido"
            }
            Toast.makeText(this, "$sex", Toast.LENGTH_SHORT).show()
        }

        // Spinner
        val spCountry = findViewById<Spinner>(R.id.spCountry)
        val countries = arrayListOf("México", "España", "Dinamarca", "Estados Unidos", "Venezuela", "Colombia", "México", "España", "Dinamarca", "Estados Unidos", "Venezuela", "Colombia", "México", "España", "Dinamarca", "Estados Unidos", "Venezuela", "Colombia", "México", "España", "Dinamarca", "Estados Unidos", "Venezuela", "Colombia", "México", "España", "Dinamarca", "Estados Unidos", "Venezuela", "Colombia")
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCountry.adapter = countryAdapter

        spCountry.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val countrySelected = countries[position]
                Toast.makeText(this@SelectionComponentActivity, "Seleccionado: $countrySelected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(adapter: AdapterView<*>?) {
                Toast.makeText(this@SelectionComponentActivity, "No selección", Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnSend.setOnClickListener {
            // Checkbox
            val cbStatus = binding.cbCreditCard.isChecked
            //RadioButton
            val selectedSex = when(binding.rgSex.checkedRadioButtonId) {
                R.id.rbMan -> "H"
                R.id.rbWoman -> "M"
                R.id.rbOther -> "O"
                else -> "Desconocido"
            }
            Toast.makeText(this, "Tarjeta = $cbStatus | Sexo = $selectedSex", Toast.LENGTH_SHORT).show()
        }
    }
}