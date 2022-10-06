package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentPrincipalInicio : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        productosFragment = FragmentProductosInicio()
        canastasFragment = FragmentCanastasInicio()

        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.fragmentContainerView,productosFragment,TAG)

        transaction.commit()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_principal_inicio, container, false)
    }

    lateinit var productosFragment: FragmentProductosInicio
    lateinit var canastasFragment: FragmentCanastasInicio

    companion object{
        private const val TAG = "fragmento"
    }

    fun productosInicio(view: View?){
        val fragmentoActual = supportFragmentManager.findFragmentByTag(TAG)

        if(fragmentoActual != null){
            var fragmentoNuevo : Fragment = productosFragment
            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.fragmentContainerView,fragmentoNuevo,TAG)
            transaction.commit()
        }
    }

    fun canastasInicio(view: View?){
        val fragmentoActual = supportFragmentManager.findFragmentByTag(TAG)

        if(fragmentoActual != null){
            var fragmentoNuevo : Fragment = canastasFragment

            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.fragmentContainerView,fragmentoNuevo,TAG)
            transaction.commit()
        }
    }
}