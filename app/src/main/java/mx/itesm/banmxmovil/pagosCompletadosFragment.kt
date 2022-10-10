package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class pagosEnProcesoFragment : Fragment() {

    val args : pagosEnProcesoFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pagos_completados, container, false)
        if(Firebase.auth.currentUser == null) {

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
        view.findViewById<ImageButton>(R.id.regresarBotonOrdenes).setOnClickListener{
            val action = pagosEnProcesoFragmentDirections
                .actionPagosEnProcesoFragmentToPerfilFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }
        view.findViewById<Button>(R.id.enProcesoBotonOrdenes).setOnClickListener{
            val action = pagosEnProcesoFragmentDirections
                .actionPagosEnProcesoFragmentToMisDonacionesFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }
        return view
    }

}