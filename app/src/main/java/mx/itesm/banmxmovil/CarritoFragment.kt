package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class CarritoFragment : Fragment() {

    val args : CarritoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_carrito, container, false)


        view.findViewById<ImageView>(R.id.configCarrito).setOnClickListener {
            findNavController().navigate(R.id.action_carritoFragment_to_perfilFragment2)
        }

        view.findViewById<ImageView>(R.id.apadrinarCarrito).setOnClickListener{
            findNavController().navigate(R.id.action_carritoFragment_to_apadrinarFragment2)
        }
        view.findViewById<Button>(R.id.procederAComprarBotonCarrito).setOnClickListener{
            findNavController().navigate(R.id.action_carritoFragment_to_pagoFragment)
        }
        view.findViewById<Button>(R.id.regresarBotonCarrito).setOnClickListener{
            findNavController().navigate(R.id.action_carritoFragment_to_inicioFragment)
        }


        view.findViewById<ImageView>(R.id.homeCarrito).setOnClickListener{
            //findNavController().navigate(R.id.action_perfilFragment_to_misTarjetasPerfilFragment2)
            val action = CarritoFragmentDirections
                .actionCarritoFragmentToInicioFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        return view
    }
}