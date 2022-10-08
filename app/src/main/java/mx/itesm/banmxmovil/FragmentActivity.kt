package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {

    lateinit var binding : ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_fragment)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fragment)
    /*
        val fragment = perfilFragment()
        val bundle = Bundle()
        bundle.putString("string", "prueba@mail.com")
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment)
            .commit()

     */

        //i.putExtra("key",value);
        /*
        val extras = intent.extras
        if (extras != null) {
            val idUser = extras.getString("id_user")
            //The key argument here must match that used in the other activity
        }

        // "prueba@mail.com"
        val name = intent.getStringExtra("prueba@mail.com")

        if (name != null) {
            // Creating the new Fragment with the name passed in.
            val fragment = agregarTarjetaPerfil.newInstance(name)
        }

         */
    }
}

