package mx.itesm.banmxmovil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.ktx.auth
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

class pagoFragment : Fragment(){

    /*var tarjeta1:RadioButton? = null
    var tarjeta2:RadioButton? = null
    var tarjeta3:RadioButton? = null
    var radiogroup:RadioGroup? = null*/

    val args: pagoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_pago, container, false)

        /*radiogroup = view.findViewById(R.id.radioGroup2)
        tarjeta1 = view.findViewById(R.id.botonTarjetaCreditoPago)
        tarjeta2 = view.findViewById(R.id.botonTarjetaDebitoPago)
        tarjeta3 = view.findViewById(R.id.botonPaypalPago)
        radiogroup?.setOnCheckedChangeListener(this)*/

        // verificamos usuario
        if(Firebase.auth.currentUser == null) {

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }

        val radioGroup = view.findViewById(R.id.radioGroup2) as RadioGroup
        radioGroup.setOnCheckedChangeListener { group, checkedId -> // checkedId is the RadioButton selected
            when (checkedId) {
                R.id.botonTarjetaCreditoPago -> {Toast.makeText(getActivity(), "Opción Seleccionada", Toast.LENGTH_LONG).show()}
                R.id.botonTarjetaDebitoPago -> {Toast.makeText(getActivity(), "Opción Seleccionada", Toast.LENGTH_LONG).show()}
                R.id.botonPaypalPago -> {Toast.makeText(getActivity(), "Tarjeta Opción", Toast.LENGTH_LONG).show()}
            }
        }

        view.findViewById<ImageButton>(R.id.regresarBotonMetodoPago3).setOnClickListener {
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

    /*override fun onCheckedChanged(p0: RadioGroup?, idRadio: Int){
        when (idRadio) {
            tarjeta1?.id -> Toast.makeText(context, "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
            tarjeta2?.id -> Toast.makeText(context, "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
            tarjeta3?.id -> Toast.makeText(context, "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
        }
    }*/

    /*
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myView = inflater.inflate(R.layout.settings_layout, container, false)
        val radioGroup = myView.findViewById(R.id.radioGroup) as RadioGroup
        radioGroup.setOnCheckedChangeListener { group, checkedId -> // checkedId is the RadioButton selected
            when (checkedId) {
                R.id.radioButton7 -> {}
                R.id.radioButton6 -> {}
            }
        }
        return myView
    }

    fun Condition(view: View) {
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            R.id.botonTarjetaCreditoPago -> {
                if (checked)
                    Toast.makeText(context, "Opción Seleccionada", Toast.LENGTH_LONG).show()
                     }
            R.id.botonTarjetaDebitoPago -> {
                if (checked) {
                    Toast.makeText(context, "Opción Seleccionada", Toast.LENGTH_LONG).show()
                    }
            }
            R.id.botonPaypalPago -> {
                if (checked) {
                    Toast.makeText(context, "Opción Seleccionada", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

     */
    }
