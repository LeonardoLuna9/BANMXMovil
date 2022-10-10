package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import mx.itesm.banmxmovil.databinding.ActivityAddTarjetaBinding

class TarjetasFragment : Fragment(), RadioGroup.OnCheckedChangeListener {

    val args : TarjetasFragmentArgs by navArgs()

    var opcion1: RadioButton? = null
    var opcion2: RadioButton? = null
    var radiogroup: RadioGroup? = null

    lateinit var binding : ActivityAddTarjetaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tarjetas, container, false)

        // verificamos usuario
        if(Firebase.auth.currentUser == null) {

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }

        // Tarjetas a Pago Fragment
        view.findViewById<ImageButton>(R.id.regresarBotonAddTarjeta).setOnClickListener {
            //findNavController().navigate(R.id.action_tarjetasFragment_to_pagoFragment)
            val action = TarjetasFragmentDirections
                .actionTarjetasFragmentToPagoFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.pagarAddTarjeta).setOnClickListener {
            //findNavController().navigate(R.id.action_tarjetasFragment_to_agradecimientoFragment)
            val action = TarjetasFragmentDirections
                .actionTarjetasFragmentToAgradecimientoFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }
        view.findViewById<Button>(R.id.anadirTarjetaAddTarjeta).setOnClickListener {
            //findNavController().navigate(R.id.action_tarjetasFragment_to_agregarTarFragment)
            val action = TarjetasFragmentDirections
                .actionTarjetasFragmentToAgregarTarFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }
        return view
        }

        override fun onCheckedChanged(p0: RadioGroup?, idRadio: Int){
            when (idRadio) {
                opcion1?.id -> Toast.makeText(getActivity(), "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
                opcion2?.id -> Toast.makeText(getActivity(), "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
            }
    }
}
