package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import mx.itesm.banmxmovil.databinding.ActivityAddTarjetaBinding

class TarjetasFragment : Fragment(), RadioGroup.OnCheckedChangeListener {

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

        radiogroup = view.findViewById(R.id.RadioGroup3)
        tarjeta1 = view.findViewById(R.id.radioButton6)
        tarjeta2 = view.findViewById(R.id.radioButton11)
        radiogroup?.setOnCheckedChangeListener(this)

        view.findViewById<Button>(R.id.regresarBotonAddTarjeta).setOnClickListener {
            findNavController().navigate(R.id.action_tarjetasFragment_to_pagoFragment)
        }
        view.findViewById<Button>(R.id.anadirTarjetaAddTarjeta).setOnClickListener {
            findNavController().navigate(R.id.action_tarjetasFragment_to_agregarTarjetaPerfil)
        }
        view.findViewById<Button>(R.id.pagarAddTarjeta).setOnClickListener {
            findNavController().navigate(R.id.action_tarjetasFragment_to_agradecimientoFragment)
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
