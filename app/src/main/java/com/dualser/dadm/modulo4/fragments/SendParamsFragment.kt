package com.dualser.dadm.modulo4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dualser.dadm.R
import com.dualser.dadm.databinding.FragmentSendParamsBinding
import com.dualser.dadm.modulo4.componentesgraficos.Person

class SendParamsFragment : Fragment(R.layout.fragment_send_params) {

    private lateinit var binding: FragmentSendParamsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSendParamsBinding.bind(view)

        binding.btnSend.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fcv, ReceiveParamsFragment.newInstance("Luis D", Person("1", "Pepe")))
                .addToBackStack("FragmentReceiveParams")
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SendParamsFragment()
    }
}