package com.utad.enviopantallas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.utad.enviopantallas.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private val args: HomeFragmentArgs? by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLibros.setOnClickListener() {
            findNavController().navigate(R.id.action_homeFragment_to_recyclerFragment)
        }

        binding.btnpodcast.setOnClickListener(){
            Snackbar.make(binding.root, "Todavia en pruebas", Snackbar.LENGTH_LONG).show()
        }

        binding.btnbuscar.setOnClickListener(){
            Snackbar.make(binding.root, "Todavia en pruebas", Snackbar.LENGTH_LONG).show()
        }

        binding.btnpeliculas.setOnClickListener(){
            Snackbar.make(binding.root, "Todavia en pruebas", Snackbar.LENGTH_LONG).show()
        }

        binding.btnCerrarSesion.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }
}






