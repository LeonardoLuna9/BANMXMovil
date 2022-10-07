package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController


class pagosEnProcesoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pagos_completados, container, false)

        view.findViewById<ImageButton>(R.id.regresarBotonOrdenes).setOnClickListener{
            findNavController().navigate(R.id.action_pagosEnProcesoFragment_to_perfilFragment)
        }
        view.findViewById<ImageButton>(R.id.enProcesoBotonOrdenes).setOnClickListener{
            findNavController().navigate(R.id.action_pagosEnProcesoFragment_to_misDonacionesFragment)
        }
        return view
    }

}