package com.utad.enviopantallas

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.utad.enviopantallas.databinding.FragmentRecyclerBinding
import com.utad.tema12recyclerview.MainAdapter
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class RecyclerFragment : Fragment() {

    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val json = readJsonFromFile("libros.json")
        val libros = Gson().fromJson(json, LibroResponse::class.java)
        Log.i("MainActivity", libros.data.toString())

        val mainRecyclerView = binding.mainRecyclerView

        val mAdapter = MainAdapter(libros.data) {
            val directionsone = RecyclerFragmentDirections.actionRecyclerFragmentToListFragment(it)
            findNavController().navigate(directionsone)
        }
        mainRecyclerView.layoutManager = GridLayoutManager(context, 1)
        mainRecyclerView.adapter = mAdapter

    }
    //Funcion para leer archivos Json
    private fun readJsonFromFile(fileName: String): String {
        var json = ""
        val assetManager = requireContext().resources.assets
        try {
            val bufferedReader = BufferedReader(
                InputStreamReader(assetManager.open(fileName))
            )
            val paramsBuilder = StringBuilder()
            var line: String? = bufferedReader.readLine()
            while (line != null) {
                paramsBuilder.append(line)
                line = bufferedReader.readLine()
            }
            json = paramsBuilder.toString()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return json
    }

}