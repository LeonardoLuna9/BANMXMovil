package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class ApadrinarFragment : Fragment() {

    val args : ApadrinarFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_apadrinar, container, false)

        view.findViewById<ImageView>(R.id.configApadrinar).setOnClickListener {
            findNavController().navigate(R.id.action_apadrinarFragment_to_perfilFragment2)
        }

        view.findViewById<ImageView>(R.id.cartApadrinar).setOnClickListener{
            findNavController().navigate(R.id.action_apadrinarFragment_to_carritoFragment2)
        }

        view.findViewById<Button>(R.id.botonApadrinar).setOnClickListener{
            findNavController().navigate(R.id.action_apadrinarFragment_to_mensajesFragment)
        }

        // Presionamos el boton de config
        view.findViewById<ImageView>(R.id.configApadrinar).setOnClickListener{
            val action = ApadrinarFragmentDirections
                .actionApadrinarFragmentToInicioFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        return view
    }

}