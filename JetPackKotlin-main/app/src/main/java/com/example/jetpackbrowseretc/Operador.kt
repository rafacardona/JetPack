package com.example.jetpackbrowseretc

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_operador.*


class Operador : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_operador, container, false)
    }



    var datosAEnviar = Bundle()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bCalcula.setOnClickListener {
            if (radioButton.isChecked) {
                var numero1 = Integer.parseInt(editTextNumber.text.toString())
                var numero2 = Integer.parseInt(editTextNumber2.text.toString())
                var result = numero1 + numero2
                val directions =OperadorDirections.actionOperacionesToSuma(Resultado = result)
                Navigation.findNavController(it).navigate(directions)


            }
            if (radioButton2.isChecked) {
                var numero1 = Integer.parseInt(editTextNumber.text.toString())
                var numero2 = Integer.parseInt(editTextNumber2.text.toString())
                var result = numero1 - numero2
                val directions =OperadorDirections.actionOperacionesToSuma(Resultado = result)
                Navigation.findNavController(it).navigate(directions)
            }

            if (radioButton4.isChecked) {
                var numero1 = Integer.parseInt(editTextNumber.text.toString())
                var numero2 = Integer.parseInt(editTextNumber2.text.toString())
                var result = numero1/numero2
                val directions =OperadorDirections.actionOperacionesToSuma(Resultado = result)
                Navigation.findNavController(it).navigate(directions)

            }

        }
    }
}

