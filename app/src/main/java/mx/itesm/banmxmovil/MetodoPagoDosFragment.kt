package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import mx.itesm.banmxmovil.databinding.ActivityPagoBinding

class MetodoPagoDosFragment : Fragment(), RadioGroup.OnCheckedChangeListener {
    var tarjeta1: RadioButton? = null
    var tarjeta2: RadioButton? = null
    var tarjeta3: RadioButton? = null
    var radiogroup:RadioGroup? = null

    //lateinit var binding : ActivityMetodoPagoDosBinding


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

        view.findViewById<Button>(R.id.regresarBotonPago2).setOnClickListener {
            findNavController().navigate(R.id.action_metodoPagoDosFragment_to_donarFragment)
        }
        view.findViewById<Button>(R.id.siguienteBotonPago2).setOnClickListener {
            findNavController().navigate(R.id.action_metodoPagoDosFragment_to_tarjetasFragment)
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
