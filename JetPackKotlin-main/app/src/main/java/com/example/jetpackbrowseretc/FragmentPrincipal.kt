package com.example.jetpackbrowseretc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import kotlinx.android.synthetic.main.fragment_principal.*


class FragmentPrincipal : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_principal, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        botonCamara.setOnClickListener {
           findNavController(it).navigate(R.id.action_principal_to_camara)
        }
        botonNavegador.setOnClickListener {
            findNavController(it).navigate(R.id.action_principal_to_navegador)
        }
        botonCalculo.setOnClickListener {
            findNavController(it).navigate(R.id.action_principal_to_operaciones)
        }
    }
}