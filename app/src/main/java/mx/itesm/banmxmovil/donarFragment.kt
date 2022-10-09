package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class donarFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_donar, container, false)
        view.findViewById<Button>(R.id.botonDonarBienFragment).setOnClickListener{
            findNavController().navigate(R.id.action_donarFragment_to_pagoFragment)
        }
        view.findViewById<Button>(R.id.configDonar).setOnClickListener{
            findNavController().navigate(R.id.action_donarFragment_to_perfilFragment)
        }
        view.findViewById<Button>(R.id.apadrinarDonar).setOnClickListener{
            findNavController().navigate(R.id.action_donarFragment_to_apadrinarFragment)
        }
        view.findViewById<Button>(R.id.cartDonar).setOnClickListener{
            findNavController().navigate(R.id.action_donarFragment_to_carritoFragment)
        }



        return view
    }


}