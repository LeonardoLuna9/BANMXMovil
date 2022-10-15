package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddTarjetaDonacionFragment : Fragment() {
    private lateinit var _nombreInputTarjeta3: EditText
    private lateinit var _numTarjetaInputTarjeta3: EditText
    private lateinit var _expInputTarjeta3: EditText
    private lateinit var _codigoInputTarjeta3: EditText

    val db = Firebase.firestore
    val args: AddTarjetaDonacionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_tarjeta_donacion, container, false)

        _nombreInputTarjeta3 = view.findViewById(R.id.nombreInputTar3)
        _numTarjetaInputTarjeta3 = view.findViewById(R.id.numTarjetaInputTar3)
        _expInputTarjeta3 = view.findViewById(R.id.expInputTar3)
        _codigoInputTarjeta3 = view.findViewById(R.id.codigoInputTar3)

        view.findViewById<Button>(R.id.guardarBotonTar3).setOnClickListener {
            val data = hashMapOf(
                "nombre" to _nombreInputTarjeta3.text.toString(),
                "numTarjeta" to _numTarjetaInputTarjeta3.text.toString(),
                "expTarjeta" to _expInputTarjeta3.text.toString(),
                "codigoTarjeta" to _codigoInputTarjeta3.text.toString()
            )

            // verificamos usuario
            if(Firebase.auth.currentUser == null) {

                // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
                // podrías redireccionar / terminar esta actividad
                Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
                requireActivity().finish()
            }

            //view.findViewById<TextView>(R.id.nombreViewPerfil).text = args.nombrePerfil
            //view.findViewById<TextView>(R.id.correoViewPerfil).text = args.emailPerfil
            db.collection("usuarios/${args.idUsuario}/tarjetas")
                .document(_numTarjetaInputTarjeta3.text.toString()).set(data)

            //findNavController().navigate(R.id.action_agregarTarjetaPerfil_to_misTarjetasPerfilFragment)
            val action = AddTarjetaDonacionFragmentDirections
                .actionAddTarjetaDonacionFragmentToPagoDonacionFragment(
                    args.idUsuario
                )
            Toast.makeText(context, "Información Guardada", Toast.LENGTH_SHORT).show()
            findNavController().navigate(action)
        }
        view.findViewById<ImageButton>(R.id.regresarBotonTar3).setOnClickListener {
            val action = AddTarjetaDonacionFragmentDirections
                .actionAddTarjetaDonacionFragmentToPagoDonacionFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)


        }
        return view
    }
}