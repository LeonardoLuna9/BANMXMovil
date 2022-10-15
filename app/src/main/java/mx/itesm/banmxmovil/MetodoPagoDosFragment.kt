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
import mx.itesm.banmxmovil.databinding.ActivityPagoBinding

class MetodoPagoDosFragment : Fragment(), RadioGroup.OnCheckedChangeListener {
    var tarjeta1: RadioButton? = null
    var tarjeta2: RadioButton? = null
    var tarjeta3: RadioButton? = null
    var radiogroup:RadioGroup? = null

    //lateinit var binding : ActivityMetodoPagoDosBinding
    val args: MetodoPagoDosFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_metodo_pago_dos, container, false)

        radiogroup = view.findViewById(R.id.radioGroup3)
        tarjeta1 = view.findViewById(R.id.botonTarjetaCreditoPago2)
        tarjeta2 = view.findViewById(R.id.botonTarjetaDebitoPago2)
        tarjeta3 = view.findViewById(R.id.botonPaypalPago2)
        radiogroup?.setOnCheckedChangeListener(this)

        // verificamos usuario
        if(Firebase.auth.currentUser == null) {

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }

        view.findViewById<ImageButton>(R.id.regresarBotonPago2).setOnClickListener {
            val action = MetodoPagoDosFragmentDirections
                .actionMetodoPagoDosFragmentToDonarFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.siguienteBotonPago2).setOnClickListener {
            val action = MetodoPagoDosFragmentDirections
                .actionMetodoPagoDosFragmentToPagoDonacionFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }
        return view
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_pago)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_pago)

        radiogroup = view.findViewById(R.id.radioGroup2)
        tarjeta1 = view.findViewById(R.id.botonTarjetaCreditoPago)
        tarjeta2 = view.findViewById(R.id.botonTarjetaDebitoPago)
        tarjeta3 = view.findViewById(R.id.botonPaypalPago)
        radiogroup?.setOnCheckedChangeListener(this)
    }*/
    override fun onCheckedChanged(p0: RadioGroup?, idRadio: Int){
        when (idRadio) {
            tarjeta1?.id -> Toast.makeText(getActivity(), "Opción Seleccionada", Toast.LENGTH_LONG).show()
            tarjeta2?.id -> Toast.makeText(getActivity(), "Opción Seleccionada", Toast.LENGTH_LONG).show()
            tarjeta3?.id -> Toast.makeText(getActivity(), "Opción Seleccionada", Toast.LENGTH_LONG).show()
        }
    }
}
