package mx.itesm.banmxmovil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import mx.itesm.banmxmovil.databinding.ActivityPerfilBinding


class perfilFragment : Fragment() {

    //val args : perfilFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        view.findViewById<Button>(R.id.editarPerfilBotonPerfil).setOnClickListener{
            findNavController().navigate(R.id.action_perfilFragment_to_editarPerfilFragment)
        }

        view.findViewById<Button>(R.id.misDonacionesBotonPerfil).setOnClickListener{
            findNavController().navigate(R.id.action_perfilFragment_to_misDonacionesFragment)
        }

        view.findViewById<Button>(R.id.misTarjetasBotonPerfil).setOnClickListener{
            findNavController().navigate(R.id.action_perfilFragment_to_misTarjetasPerfilFragment2)
        }
        /*
        view.findViewById<ImageView>(R.id.cartPerfil).setOnClickListener {
            findNavController().navigate(R.id.action_perfilFragment_to_carritoFragment3)
        }

        view.findViewById<ImageView>(R.id.apadrinarPerfil).setOnClickListener{
            findNavController().navigate(R.id.action_perfilFragment_to_apadrinarFragment3)
        }
        */

        //view.findViewById<TextView>(R.id.nombreViewPerfil).text = args.nombrePerfil
        //view.findViewById<TextView>(R.id.correoViewPerfil).text = args.emailPerfil

        return view
    }



    /* val lanzador = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

        // 1ero - revisar código
        if(result.resultCode == Activity.RESULT_OK) {

            //val datos = result.data

            //binding.nombreViewPerfil.text = intent.getStringExtra("nombre")
            //binding.correoViewPerfil.text = intent.getStringExtra("email")

            // aqui se actualizan los datos que recibe desde editar perfil, se intentara hacerlo directo a firestore
        }
    }

    fun cambiarAEditarPerfil(view: View?){


        val intent = Intent(this, EditarPerfilActivity::class.java)

        //intent.putExtra("nombre", "")
        //intent.putExtra("email", "")
        //intent.putExtra("telefono", "")
        //intent.putExtra("contraseña", "")

        lanzador.launch(intent)

    }

    fun irAOrdenes(view: View?) {
        val intent = Intent(this, OrdenesActivity::class.java)
        startActivity(intent)
    }

    fun iraAddTarjeta(view: View?){
        val intent = Intent(this, AddTarjetaActivity::class.java)
        startActivity(intent)
    }

    fun regresarAMenu(view: View?){
        finish()
    }
    fun irAInicio(view: View?){
        val intent = Intent(this, InicioActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun iraApadrinar(view: View?){
        val intent = Intent(this, ApadrinarActivity::class.java)
        startActivity(intent)
        finish()
    } */
}