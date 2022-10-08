package mx.itesm.banmxmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import mx.itesm.banmxmovil.databinding.ActivityLogBinding


class LogActivity : AppCompatActivity() {

    lateinit var binding : ActivityLogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_log)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_log)
        verificarUsuario()

        val intent = Intent(this, FragmentActivity::class.java)
        startActivity(intent)
    }

    fun login(view : View?) {

        var emailStr = binding.correoInputLog.text.toString()
        var pwdStr = binding.passwordInputLog.text.toString()
        var authTask = Firebase.auth.signInWithEmailAndPassword(emailStr, pwdStr)

        authTask.addOnCompleteListener(this) { resultado ->

            if(resultado.isSuccessful){
                Toast.makeText(this, "LOGIN EXITOSO", Toast.LENGTH_SHORT).show()
                // Lo llevamos a inicio
                val intent = Intent(this,FragmentActivity::class.java)
                intent.putExtra("id_user",binding.correoInputLog.text.toString());
                startActivity(intent)
                finish()
            } else {

                Toast.makeText(this, "ERROR EN LOGIN", Toast.LENGTH_SHORT).show()
                Log.e("FIREBASE-DEV", "error: ${resultado.exception?.message}")
            }
        }
        // Terminamos actividad
        //finish()
    }

    fun clickTextViewRegister(view: View?) {
        val intent = Intent(this, FragmentActivity::class.java)
        startActivity(intent)
        finish()
    }

    // Si usuario esta iniciado vamos a llevarlo a inicio
    fun verificarUsuario() {

        // OJO - para su aplicación va a ser necesario que verifiquen la validez del
        // usuario actual
        if(Firebase.auth.currentUser == null){

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            Toast.makeText(this, "REVALIDA!", Toast.LENGTH_SHORT).show()
        } else {
            // Lo llevamos a inicio
            val intent = Intent(this,FragmentActivity::class.java)
            intent.putExtra("id_user",binding.correoInputLog.text.toString());
            startActivity(intent)
            finish()

            Toast.makeText(
                this,
                "USUARIO: ${Firebase.auth.currentUser?.email}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


}