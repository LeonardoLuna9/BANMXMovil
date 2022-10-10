package mx.itesm.banmxmovil

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import mx.itesm.banmxmovil.databinding.ActivityPagoBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


/*class pagoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_pago, container, false)
        view.findViewById<Button>(R.id.siguienteBotonPago).setOnClickListener {
            findNavController().navigate(R.id.action_pagoFragment_to_tarjetasFragment)
        }
        return view
        }
}*/

class pagoFragment : Fragment(), RadioGroup.OnCheckedChangeListener {

    var tarjeta1:RadioButton? = null
    var tarjeta2:RadioButton? = null
    var tarjeta3:RadioButton? = null
    var radiogroup:RadioGroup? = null

    val args: pagoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_pago, container, false)

        radiogroup = view.findViewById(R.id.radioGroup2)
        tarjeta1 = view.findViewById(R.id.botonTarjetaCreditoPago)
        tarjeta2 = view.findViewById(R.id.botonTarjetaDebitoPago)
        tarjeta3 = view.findViewById(R.id.botonPaypalPago)
        radiogroup?.setOnCheckedChangeListener(this)

        // verificamos usuario
        if(Firebase.auth.currentUser == null) {

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }

        view.findViewById<Button>(R.id.regresarBotonAddTarjeta).setOnClickListener {
            val action = pagoFragmentDirections
                .actionPagoFragmentToCarritoFragment2(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.siguienteBotonPago).setOnClickListener {
            val action = pagoFragmentDirections
                .actionPagoFragmentToTarjetasFragment(
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
            tarjeta1?.id -> Toast.makeText(getActivity(), "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
            tarjeta2?.id -> Toast.makeText(getActivity(), "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
            tarjeta3?.id -> Toast.makeText(getActivity(), "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
        }
    }
}