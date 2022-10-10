package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Mensajes2Fragment : Fragment() {
    val args : Mensajes2FragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mensajes2, container, false)
        if(Firebase.auth.currentUser == null) {

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
        view.findViewById<ImageButton>(R.id.regresarBotonApadrinar2).setOnClickListener {
            val action = Mensajes2FragmentDirections
                .actionMensajes2FragmentToApadrinarFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }
        return view
    }
}