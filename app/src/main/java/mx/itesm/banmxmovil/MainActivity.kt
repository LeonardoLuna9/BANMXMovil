package mx.itesm.banmxmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import mx.itesm.banmxmovil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // Prueba
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Firebase.auth.signOut()

    }

    // Función para irnos a actividad de Registro
    fun clickToRegister(view: View?) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    // Función para irnos a actividad de Log In
    fun clickToLogIn(view: View?) {
        val intent = Intent(this, FragmentActivity::class.java)
        startActivity(intent)
    }

    // Si usuario esta iniciado vamos a llevarlo a inicio
    fun verificarUsuario() {

        // OJO - para su aplicación va a ser necesario que verifiquen la validez del
        // usuario actual
        if(Firebase.auth.currentUser == null){

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            //Toast.makeText(this, "REVALIDA!", Toast.LENGTH_SHORT).show()
        } else {
            // Lo llevamos a inicio
            val intent = Intent(this,FragmentActivity::class.java)
            //intent.putExtra("id_user",);
            startActivity(intent)

            Toast.makeText(
                this,
                "USUARIO: ${Firebase.auth.currentUser?.email}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    // FUNCIONALIDAD COMÚN!
    // VERIFICAR VALIDEZ DE USUARIO EN EL CICLO DE VIDA
    override fun onStart() {
        super.onStart()

        verificarUsuario()
    }

}