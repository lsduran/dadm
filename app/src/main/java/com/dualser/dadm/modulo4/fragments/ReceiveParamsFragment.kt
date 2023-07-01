package com.dualser.dadm.modulo4.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dualser.dadm.R
import com.dualser.dadm.databinding.FragmentReceiveParamsBinding
import com.dualser.dadm.modulo4.componentesgraficos.Person
import com.dualser.dadm.modulo4.ejercicios.ejercicio1.IntentExplicitoSecondActivity

class ReceiveParamsFragment : Fragment(R.layout.fragment_receive_params) {

    private lateinit var binding: FragmentReceiveParamsBinding
    private var name : String? = ""
    private var person : Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("ARG_NAME")
            person = it.getSerializable("ARG_PERSON") as Person
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receive_params, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReceiveParamsBinding.bind(view)

        binding.tvName.text = name
        binding.tvPerson.text = person?.name

        binding.btnCallActivity.setOnClickListener {
            val intent = Intent(requireContext(), IntentExplicitoSecondActivity::class.java).apply {
                putExtra("EXTRA_NAME", name)
            }
            startActivity(intent)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(name : String, person : Person) =
            ReceiveParamsFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_NAME", name)
                    putSerializable("ARG_PERSON", person)
                }
            }
    }
}