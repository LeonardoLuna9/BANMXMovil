package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController

class CarritoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_carrito, container, false)


        view.findViewById<ImageButton>(R.id.configCarrito).setOnClickListener {
            findNavController().navigate(R.id.action_carritoFragment_to_perfilFragment2)
        }

        view.findViewById<ImageButton>(R.id.apadrinarCarrito).setOnClickListener{
            findNavController().navigate(R.id.action_carritoFragment_to_apadrinarFragment2)
        }

        return view
    }
}