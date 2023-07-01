package com.dualser.dadm.modulo4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dualser.dadm.R
import com.dualser.dadm.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var binding : FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        binding.btnNextFragment.setOnClickListener {
            // parentFragmentManager: si el contenedor del fragment lo maneja la activity
            // childFragmentManager: si el contenedor se encuentra dentro de este Fragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fcv1, SecondFragment.newInstance())
                .addToBackStack("SecondFragment") // apila en stack de pantallas, la hacer back destruye solo el Fragment
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}