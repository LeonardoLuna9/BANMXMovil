package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class misTarjetasPerfilFragment : Fragment() {

    val args : misTarjetasPerfilFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mis_tarjetas_perfil, container, false)

        view.findViewById<Button>(R.id.anadirTarjetaAddTarjeta).setOnClickListener{
            //findNavController().navigate(R.id.action_misTarjetasPerfilFragment_to_agregarTarjetaPerfil)
            val action = misTarjetasPerfilFragmentDirections
                .actionMisTarjetasPerfilFragmentToAgregarTarjetaPerfil(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        view.findViewById<ImageButton>(R.id.regresarBotonAddTarjeta).setOnClickListener{
            findNavController().navigate(R.id.action_misTarjetasPerfilFragment_to_perfilFragment)
        }

        return view
    }


}