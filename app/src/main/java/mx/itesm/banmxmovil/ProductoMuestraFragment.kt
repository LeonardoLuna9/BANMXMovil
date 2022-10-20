package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import androidx.navigation.fragment.navArgs
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class ProductoMuestraFragment : Fragment() {
    lateinit var imagenView : ImageView
    lateinit var nombreView : TextView
    lateinit var precioView : TextView
    lateinit var paqueteView : TextView
    lateinit var descripcionView : TextView

    val args : ProductoMuestraFragmentArgs by navArgs()

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_producto_muestra, container, false)
        imagenView = view.findViewById(R.id.productoImage)
        nombreView = view.findViewById(R.id.nombre)
        precioView = view.findViewById(R.id.precio)
        paqueteView = view.findViewById(R.id.paquete)
        descripcionView = view.findViewById(R.id.descripcion)

        Picasso.get().load(args.imagen).into(imagenView)
        nombreView.text = args.nombre
        precioView.text = args.precio
        paqueteView.text = args.paquete
        descripcionView.text = args.descripcion

        val data = hashMapOf(
            "nombre" to args.nombre,
            "cantidad" to 1,
            "precio" to args.precio,
            "imagen" to args.imagen
        )

        view.findViewById<Button>(R.id.agregarACarritoBoton).setOnClickListener {
            db.collection("usuarios/${args.idUsuario}/carrito")
                .document(args.nombre).set(data)
        }
        //agregarACarritoBoton

        view.findViewById<ImageButton>(R.id.regresarBotonAddTarjeta5).setOnClickListener {
            val action = ProductoMuestraFragmentDirections
                .actionProductoMuestraFragmentToInicioFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }
        return view
    }

}