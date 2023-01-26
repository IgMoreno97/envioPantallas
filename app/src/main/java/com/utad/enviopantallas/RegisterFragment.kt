package com.utad.enviopantallas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.utad.enviopantallas.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {


    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnGuardar.setOnClickListener() {
            //findNavController().navigate( R.id.action_registerFragment_to_homeFragment)
            val email = binding.textFieldEmail.editText?.text.toString()
            val nombre = binding.textFieldNombre.editText?.text.toString()
            val apellidos = binding.textFieldApellidos.editText?.text.toString()
            val fechaNacimiento = binding.etPlannedDate.toString()
            if (!email.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() && !fechaNacimiento.isEmpty()) {
                val user = User("${email}", "${nombre}", "${apellidos}", "", "${fechaNacimiento}")
                findNavController().navigate(com.utad.enviopantallas.R.id.action_registerFragment_to_loginFragment)
            } else {
                Snackbar.make(binding.root, "Rellena todos los campos", Snackbar.LENGTH_LONG).show()
            }

        }


    }


}