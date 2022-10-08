package mx.itesm.banmxmovil

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class agregarTarjetaPerfil : Fragment() {

    private lateinit var _nombreInputTarjeta : EditText
    private lateinit var _numTarjetaInputTarjeta : EditText
    private lateinit var _expInputTarjeta : EditText
    private lateinit var _codigoInputTarjeta : EditText

    val db = Firebase.firestore
    //val args : perfilFragmentArgs by navArgs()

    companion object {
        const val ARG_NAME = "name"


        fun newInstance(name: String): agregarTarjetaPerfil {
            val fragment = agregarTarjetaPerfil()

            val bundle = Bundle().apply {
                putString(ARG_NAME, name)
            }

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val strtext = requireArguments().getString("edttext")
        val name = arguments?.getString(ARG_NAME)
        val view = inflater.inflate(R.layout.fragment_agregar_tarjeta_perfil, container, false)

        _nombreInputTarjeta = view.findViewById<EditText>(R.id.nombreInputTarjeta)
        _numTarjetaInputTarjeta = view.findViewById<EditText>(R.id.numTarjetaInputTarjeta)
        _expInputTarjeta = view.findViewById<EditText>(R.id.expInputTarjeta)
        _codigoInputTarjeta = view.findViewById<EditText>(R.id.codigoInputTarjeta)

        //view.Log("wtf", name)
        if (name != null) {
            Log.wtf("NAME", name);
        }
        else {
            Log.wtf("NAME", "No se puede");
        }

        view.findViewById<Button>(R.id.guardarBotonTarjeta).setOnClickListener{
            val data = hashMapOf(
                "nombre" to _nombreInputTarjeta.text.toString(),
                "numTarjeta" to _numTarjetaInputTarjeta.text.toString(),
                "expTarjeta" to _expInputTarjeta.text.toString(),
                "codigoTarjeta" to _codigoInputTarjeta.text.toString()
            )

            //view.findViewById<TextView>(R.id.nombreViewPerfil).text = args.nombrePerfil
            //view.findViewById<TextView>(R.id.correoViewPerfil).text = args.emailPerfil
            //db.collection("usuarios/${name}/tarjetas").document(_numTarjetaInputTarjeta.text.toString()).set(data)

            findNavController().navigate(R.id.action_agregarTarjetaPerfil_to_misTarjetasPerfilFragment)
        }


        return view
    }

}