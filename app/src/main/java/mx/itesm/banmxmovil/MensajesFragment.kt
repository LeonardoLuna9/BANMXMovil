package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController

class MensajesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mensajes, container, false)
        view.findViewById<ImageButton>(R.id.regresarBotonApadrinar2).setOnClickListener {
            findNavController().navigate(R.id.action_mensajesFragment_to_apadrinarFragment)
        }
        return view
    }
}