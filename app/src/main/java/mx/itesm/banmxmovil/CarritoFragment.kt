package mx.itesm.banmxmovil

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CarritoFragment : Fragment() {

    val args : CarritoFragmentArgs by navArgs()
    val db = Firebase.firestore
    lateinit var carritoList : ArrayList<ArrayList<String>>
    lateinit var recyclerViewCarrito : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_carrito, container, false)
        carritoList = ArrayList()
        db.collection("usuarios/${args.idUsuario}/carrito")
            .get()
            .addOnSuccessListener { result ->
                var contador = 0
                for (document in result) {
                    //Log.d("PRUEBA FIREBASE", "${document.id} => ${document.data}")
                    carritoList.add(contador, arrayListOf(document.data["nombre"].toString(), document.data["cantidad"].toString()))
                }
                //Log.d("PRUEBA FIREBASE", carritoList[0][0])
                val adapter = carritoAdapter(carritoList)

                recyclerViewCarrito = view.findViewById(R.id.carritoListR)

                val llm = LinearLayoutManager(context)

                llm.orientation = LinearLayoutManager.VERTICAL

                recyclerViewCarrito.layoutManager = llm

                recyclerViewCarrito.adapter = adapter
            }
            .addOnFailureListener { exception ->
                Log.w("PRUEBA ERROR FIREBASE", "Error getting documents.", exception)
            }



        // verificamos usuario
        if(Firebase.auth.currentUser == null) {

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }

        // Carrito a perfil
        view.findViewById<ImageView>(R.id.configCarrito).setOnClickListener {
            //findNavController().navigate(R.id.action_carritoFragment_to_perfilFragment2)
            val action = CarritoFragmentDirections
                .actionCarritoFragmentToPerfilFragment2(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        // Carrito a apadrinar
        view.findViewById<ImageView>(R.id.apadrinarCarrito).setOnClickListener{
            //findNavController().navigate(R.id.action_carritoFragment_to_apadrinarFragment2)
            val action = CarritoFragmentDirections
                .actionCarritoFragmentToApadrinarFragment2(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }
        view.findViewById<Button>(R.id.procederAComprarBotonCarrito).setOnClickListener{
            //findNavController().navigate(R.id.action_carritoFragment_to_pagoFragment)
            val action = CarritoFragmentDirections
                .actionCarritoFragmentToPagoFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        view.findViewById<ImageView>(R.id.homeCarrito).setOnClickListener{
            //findNavController().navigate(R.id.action_perfilFragment_to_misTarjetasPerfilFragment2)
            val action = CarritoFragmentDirections
                .actionCarritoFragmentToInicioFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        return view
    }
}