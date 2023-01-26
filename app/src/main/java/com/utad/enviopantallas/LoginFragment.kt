package com.utad.enviopantallas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.utad.enviopantallas.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnIraRegistro.setOnClickListener() {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnlogin.setOnClickListener() {
            val email = binding.Email.editText?.text.toString()
            val password = binding.Password.editText?.text.toString()
            if (!email.isEmpty() && !password.isEmpty()) {
                val user = User("${email}", "", "", "", "")
                val directionsone = LoginFragmentDirections.actionLoginFragmentToHomeFragment(user)
                findNavController().navigate(directionsone)
            } else {
                Snackbar.make(binding.root, "Rellena todos los campos", Snackbar.LENGTH_LONG).show()
            }
        }
    }

}