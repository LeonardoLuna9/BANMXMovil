package mx.itesm.banmxmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import mx.itesm.banmxmovil.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_register)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
    }

    fun registrar(view : View?){

        var emailStr = binding.emailInRegister.text.toString()
        var pwdStr = binding.contraInRegister.text.toString()
        var pwdStrVer = binding.contraVerInRegister.text.toString()

        // Verificamos que contraseñas sean iguales
        if (pwdStr == pwdStrVer) {

            var authTask = Firebase.auth.createUserWithEmailAndPassword(emailStr, pwdStr)

            authTask.addOnCompleteListener(this) { resultado ->

                if (resultado.isSuccessful) {

                    Toast.makeText(this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show()
                } else {

                    Toast.makeText(this, "ERROR EN REGISTRO", Toast.LENGTH_SHORT).show()
                    Log.wtf("FIREBASE-DEV", "error: ${resultado.exception}")
                }
            }
            registrarFirestore()
        }
        else {
            // Las contraseñas no coinciden
            Toast.makeText(this, "Contraseña no coincide", Toast.LENGTH_SHORT).show()
        }
    }

    fun clickTextViewLogIn(view: View?) {
        val intent = Intent(this, LogActivity::class.java)
        startActivity(intent)
    }

    fun registrarFirestore() {

        // vamos a guardar perritos (obviamente)
        // la info se guarda por medio de hashmaps

        val perrito = hashMapOf(
            "correo" to binding.emailInRegister.text.toString(),
            "nombre" to binding.nombreInRegistro.text.toString()
        )

        // 1er paso - obtener referencia a la colección
        val coleccion : CollectionReference =
            Firebase.firestore.collection("usuarios")

        // 2do paso - solicitar guardar dato
        val taskAdd = coleccion.add(perrito)

        taskAdd.addOnSuccessListener { doc ->

            Toast.makeText(
                this,
                "id: ${doc.id}",
                Toast.LENGTH_SHORT
            ).show()

            // Terminamos actividad
            finish()

        }.addOnFailureListener{ error ->

            Toast.makeText(
                this,
                "ERROR AL GUARDAR REGISTRO",
                Toast.LENGTH_SHORT
            ).show()

            Log.e("FIRESTORE", "error: $error")
        }

    }
}