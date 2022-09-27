package mx.itesm.banmxmovil

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityEditarPerfilBinding

class EditarPerfilActivity : AppCompatActivity() {
    lateinit var binding : ActivityEditarPerfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_editar_perfil)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_editar_perfil)
    }

    fun guardarDatosPerfil(view: View?){

        val intent = Intent()

        // ponemos valores en intent
        intent.putExtra("nombre", binding.nameInputEditarPerfil.text.toString())
        intent.putExtra("email", binding.correoInputEditarPerfil.text.toString())
        intent.putExtra("telefono", binding.telefonoInputEditarPerfil.text.toString())
        intent.putExtra("contraseña", binding.nuevaContraInputEditarPerfil.text.toString())

        // muy importante si estamos escuchando el resultado
        setResult(Activity.RESULT_OK, intent)

        // con esto se termina ejecución de esta actividad
        finish()

        // IMPORTANTE: NO hay que crear la actividad anterior de vuelta
    }

    fun regresarAPerfil(view: View?){
        finish()
    }
}