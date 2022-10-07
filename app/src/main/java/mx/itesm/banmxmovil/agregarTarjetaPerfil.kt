package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class agregarTarjetaPerfil : Fragment() {

    val db = Firebase.firestore
    //val args : perfilFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_agregar_tarjeta_perfil, container, false)


        view.findViewById<Button>(R.id.guardarBotonTarjeta).setOnClickListener{
            findNavController().navigate(R.id.action_agregarTarjetaPerfil_to_misTarjetasPerfilFragment)
        }

        val city = hashMapOf(
            "name" to "Los Angeles",
            "state" to "CA",
            "country" to "USA"
        )
        //view.findViewById<TextView>(R.id.nombreViewPerfil).text = args.nombrePerfil
        //view.findViewById<TextView>(R.id.correoViewPerfil).text = args.emailPerfil
        db.collection("usuarios/tarjetas").document("aqui").set(city)


        return view
    }

}