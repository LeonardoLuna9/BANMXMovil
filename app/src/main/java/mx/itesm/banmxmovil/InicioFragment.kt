package mx.itesm.banmxmovil


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class InicioFragment : Fragment() {

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

        buttonProductos = view.findViewById(R.id.productos)
        buttonCanastas = view.findViewById(R.id.canastas)

        productosFragment = FragmentProductosInicio()
        canastasFragment = FragmentCanastasInicio()

        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContainerView,productosFragment,TAG)
        transaction.commit()


        buttonProductos.setOnClickListener{
            val fragmentoActual = requireActivity().supportFragmentManager.findFragmentByTag(TAG)

            if (fragmentoActual != null){
                var fragmentoNuevo : Fragment = productosFragment
                val transaction = requireActivity().supportFragmentManager.beginTransaction()

                transaction.replace(R.id.fragmentContainerView,fragmentoNuevo,TAG)
                transaction.commit()
            }
        }
        buttonCanastas.setOnClickListener{
            val fragmentoActual = requireActivity().supportFragmentManager.findFragmentByTag(TAG)

            if (fragmentoActual != null){
                var fragmentoNuevo : Fragment = canastasFragment
                val transaction = requireActivity().supportFragmentManager.beginTransaction()

                transaction.replace(R.id.fragmentContainerView,fragmentoNuevo,TAG)
                transaction.commit()
            }
        }
        return view
    }

    companion object{
        private const val TAG = "fragmentito"
    }
}