package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController

class ApadrinarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_apadrinar, container, false)

        view.findViewById<ImageButton>(R.id.configApadrinar).setOnClickListener {
            findNavController().navigate(R.id.action_apadrinarFragment_to_perfilFragment2)
        }

        view.findViewById<ImageButton>(R.id.cartApadrinar).setOnClickListener{
            findNavController().navigate(R.id.action_apadrinarFragment_to_carritoFragment2)
        }

        return view
    }

}