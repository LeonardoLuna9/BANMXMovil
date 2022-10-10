package mx.itesm.banmxmovil


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class InicioFragment : Fragment() {

    val args : InicioFragmentArgs by navArgs()

    lateinit var productosFragment : FragmentProductosInicio
    lateinit var canastasFragment : FragmentCanastasInicio
    lateinit var buttonProductos : Button
    lateinit var buttonCanastas : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_inicio, container, false)

        // verificamos usuario
        if(Firebase.auth.currentUser == null) {

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }

        buttonProductos = view.findViewById(R.id.productos)
        buttonCanastas = view.findViewById(R.id.canastas)

        productosFragment = FragmentProductosInicio()
        canastasFragment = FragmentCanastasInicio()
        // Creamos el Bundle con argumentos
        val arguments = Bundle()
        arguments.putString("VALUE1", args.idUsuario)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        productosFragment.arguments = arguments
        // Pasamos al nuevo fragment con los argumentos
        transaction.add(R.id.fragmentContainerView,productosFragment,TAG)
        transaction.commit()


        buttonProductos.setOnClickListener{
            val fragmentoActual = requireActivity().supportFragmentManager.findFragmentByTag(TAG)
            // Creamos el Bundle con argumentos
            val arguments = Bundle()
            arguments.putString("VALUE1", args.idUsuario)
            if (fragmentoActual != null){
                var fragmentoNuevo : Fragment = productosFragment
                fragmentoNuevo.arguments = arguments
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                // Pasamos al nuevo fragment con los argumentos
                transaction.replace(R.id.fragmentContainerView,fragmentoNuevo,TAG)
                transaction.commit()
            }
        }
        buttonCanastas.setOnClickListener{
            val fragmentoActual = requireActivity().supportFragmentManager.findFragmentByTag(TAG)
            // Creamos el Bundle con argumentos
            val arguments = Bundle()
            arguments.putString("VALUE1", args.idUsuario)
            if (fragmentoActual != null){
                var fragmentoNuevo : Fragment = canastasFragment
                fragmentoNuevo.arguments = arguments
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                // Pasamos al nuevo fragment con los argumentos
                transaction.replace(R.id.fragmentContainerView,fragmentoNuevo,TAG)
                transaction.commit()
            }
        }

        // Presionamos boton de config
        view.findViewById<ImageView>(R.id.configApadrinar2).setOnClickListener{
            val action = InicioFragmentDirections
                .actionInicioFragmentToPerfilFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        // Presionamos boton de carrito
        view.findViewById<ImageView>(R.id.cartApadrinar2).setOnClickListener{
            val action = InicioFragmentDirections
                .actionInicioFragmentToCarritoFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        // Presionamos el boton de apadrinar
        view.findViewById<ImageView>(R.id.apadrinarApadrinar2).setOnClickListener{
            val action = InicioFragmentDirections
                .actionInicioFragmentToApadrinarFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.donarButton).setOnClickListener{
            val action = InicioFragmentDirections
                .actionInicioFragmentToDonarFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        return view
    }

    companion object{
        private const val TAG = "fragmentito"
    }
}