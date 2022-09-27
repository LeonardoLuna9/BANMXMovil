package mx.itesm.banmxmovil

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityPerfilBinding

class PerfilActivity : AppCompatActivity() {
    lateinit var binding : ActivityPerfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_perfil)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_perfil)
    }

    val lanzador = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

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
    }
}