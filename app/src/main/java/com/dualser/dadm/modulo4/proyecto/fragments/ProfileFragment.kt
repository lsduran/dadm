package com.dualser.dadm.modulo4.proyecto.fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.dualser.dadm.R
import com.dualser.dadm.databinding.FragmentProfileBinding
import com.dualser.dadm.modulo4.componentesgraficos.Person
import com.dualser.dadm.modulo4.proyecto.activities.InitActivity
import com.dualser.dadm.modulo4.proyecto.models.User

private const val EXTRA_USER = "EXTRA_USER"

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding : FragmentProfileBinding

    private var editMode = false

    private lateinit var user : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getSerializable(EXTRA_USER, User::class.java)!!
            } else {
                it.getSerializable(EXTRA_USER) as User
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileBinding.bind(view)

        binding.etFirstName.setText(user.firstName)
        binding.etLastName.setText(user.lastName)
        binding.etUsername.setText(user.username)
        for (position in 0 until binding.rgSex.childCount) {
            val rb = binding.rgSex.getChildAt(position) as RadioButton
            if (rb.text == user.sex) {
                rb.isChecked = true
            }
        }


        binding.ibLogout.setOnClickListener {
            openInitActivity()
            activity?.finish()
            showToast(getString(R.string.logged_out))
        }

        binding.ibEdit.setOnClickListener {
            if (editMode) {
                binding.ibEdit.setImageResource(R.drawable.ic_edit)
                user.firstName = binding.etFirstName.text.toString()
                user.lastName = binding.etLastName.text.toString()
                user.username = binding.etUsername.text.toString()
                user.sex = when(binding.rgSex.checkedRadioButtonId) {
                    R.id.rbMan -> getString(R.string.man)
                    R.id.rbWoman -> getString(R.string.woman)
                    R.id.rbOther -> getString(R.string.other)
                    else -> getString(R.string.not_selected)
                }
                showToast(getString(R.string.data_updated))
            } else {
                binding.ibEdit.setImageResource(R.drawable.ic_save)
            }
            editMode = !editMode
            binding.etFirstName.isEnabled = editMode
            binding.etLastName.isEnabled = editMode
            binding.etUsername.isEnabled = editMode
            binding.rgSex.isClickable = editMode
            binding.rbMan.isEnabled = editMode
            binding.rbWoman.isEnabled = editMode
            binding.rbOther.isEnabled = editMode
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(user : User) = ProfileFragment().apply {
            arguments = Bundle().apply {
                putSerializable(EXTRA_USER, user)
            }
        }
    }

    private fun openInitActivity() {
        val initIntent = Intent(requireContext(), InitActivity::class.java)
        startActivity(initIntent)
    }

    private fun showToast(message : String) {
        val toast = Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.BOTTOM,0, 200)
        toast.show()
    }
}