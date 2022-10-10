package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ApadrinarFragment : Fragment() {

    val args : ApadrinarFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_apadrinar, container, false)

        // verificamos usuario
        if(Firebase.auth.currentUser == null) {

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }

        view.findViewById<ImageView>(R.id.configApadrinar).setOnClickListener {
            val action = ApadrinarFragmentDirections
                .actionApadrinarFragmentToPerfilFragment2(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        view.findViewById<ImageView>(R.id.cartApadrinar).setOnClickListener{
            val action = ApadrinarFragmentDirections
                .actionApadrinarFragmentToCarritoFragment2(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.botonApadrinar).setOnClickListener{
            val action = ApadrinarFragmentDirections
                .actionApadrinarFragmentToMensajesFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
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