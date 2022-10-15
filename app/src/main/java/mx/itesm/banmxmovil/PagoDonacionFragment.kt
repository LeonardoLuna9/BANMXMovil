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

class PagoDonacionFragment : Fragment() {
    val args : PagoDonacionFragmentArgs by navArgs()

    /*var opcion1: RadioButton? = null
    var opcion2: RadioButton? = null
    var radiogroup: RadioGroup? = null*/

    //lateinit var binding : ActivityAddTarjetaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pago_donacion, container, false)

        // verificamos usuario
        if(Firebase.auth.currentUser == null) {

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }

        val radioGroup = view.findViewById(R.id.RadioGroup6) as RadioGroup
        radioGroup.setOnCheckedChangeListener { group, checkedId -> // checkedId is the RadioButton selected
            when (checkedId) {
                R.id.radioButtonDonacion -> {Toast.makeText(getActivity(), "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()}
                R.id.radioButtonDonacion2 -> {Toast.makeText(getActivity(), "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()}
            }
        }

        // Tarjetas a Pago Fragment
        view.findViewById<ImageButton>(R.id.regresarBotonAddTarjeta2).setOnClickListener {
            //findNavController().navigate(R.id.action_tarjetasFragment_to_pagoFragment)
            val action = PagoDonacionFragmentDirections
                .actionPagoDonacionFragmentToMetodoPagoDosFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.pagarAddTarjeta2).setOnClickListener {
            //findNavController().navigate(R.id.action_tarjetasFragment_to_agradecimientoFragment)
            val action = PagoDonacionFragmentDirections
                .actionPagoDonacionFragmentToAgradecimientoFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }
        view.findViewById<Button>(R.id.anadirTarjetaAddTarjeta2).setOnClickListener {
            //findNavController().navigate(R.id.action_tarjetasFragment_to_agregarTarFragment)
            val action = PagoDonacionFragmentDirections
                .actionPagoDonacionFragmentToAddTarjetaDonacionFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }
        return view
    }

    /*override fun onCheckedChanged(p0: RadioGroup?, idRadio: Int){
        when (idRadio) {
            opcion1?.id -> Toast.makeText(context, "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
            opcion2?.id -> Toast.makeText(context, "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
        }
    }*/
}