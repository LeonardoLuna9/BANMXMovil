package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class InicioActivity : AppCompatActivity() {

    lateinit var productosFragment: FragmentProductosInicio
    lateinit var canastasFragment: FragmentCanastasInicio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        productosFragment = FragmentProductosInicio()
        canastasFragment = FragmentCanastasInicio()

        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.fragmentContainerView,productosFragment,TAG)

        transaction.commit()
    }

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