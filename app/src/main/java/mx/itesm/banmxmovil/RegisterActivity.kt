package mx.itesm.banmxmovil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import mx.itesm.banmxmovil.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

    lateinit var binding : ActivityRegisterBinding
    lateinit var emailEditText: EditText
    lateinit var pwdEditText: EditText
    lateinit var pwdVerEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_register)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        emailEditText =  binding.emailInRegister
        pwdEditText = binding.contraInRegister
        pwdVerEditText = binding.contraVerInRegister
    }

    fun registrar(view : View?){

        var emailStr = binding.emailInRegister.text.toString()
        var pwdStr = binding.contraInRegister.text.toString()
        var pwdStrVer = binding.contraVerInRegister.text.toString()

        // Verificamos que contraseñas sean iguales
        if (isValidPassword(pwdStr)) {
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
                pwdVerEditText.setError("CONTRASEÑA NO COINCIDE")
                //Toast.makeText(this, "CONTRASEÑA NO COINCIDE", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            // Contraseña ingresada no valida
            pwdEditText.setError(" La contraseña debe tener al menos 8 caracteres.\\n\" +\n" +
                    "                    \"Debe tener al menos 1 minúscula y al menos 1 letra mayúscula.\\n\" +\n" +
                    "                    \"Debe tener un carácter especial como ! o + o – o similar.\\n\" +\n" +
                    "                    \"Debe tener al menos 1 dígito.\" +\n" +
                    "                    \"Las contraseñas deben coincidir.")
            /*
            Toast.makeText(this, " La contraseña debe tener al menos 8 caracteres.\n" +
                    "Debe tener al menos 1 minúscula y al menos 1 letra mayúscula.\n" +
                    "Debe tener un carácter especial como ! o + o – o similar.\n" +
                    "Debe tener al menos 1 dígito." +
                    "Las contraseñas deben coincidir.", Toast.LENGTH_SHORT).show()
             */
        }
    }

    fun clickTextViewLogIn(view: View?) {
        val intent = Intent(this, FragmentActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun clickTextViewFinish(view: View?) {
        finish()
    }

    fun registrarFirestore() {

        // vamos a guardar perritos (obviamente)
        // la info se guarda por medio de hashmaps

        val data = hashMapOf(
            "nombre" to binding.nombreInRegistro.text.toString()
        )

        // 1er paso - obtener referencia a la colección
        val coleccion : CollectionReference =
            Firebase.firestore.collection("usuarios")

        // 2do paso - solicitar guardar dato
        coleccion.document(binding.emailInRegister.text.toString().lowercase()).set(data)
        /*
        Toast.makeText(
            this,
            "id: ${coleccion.id}",
            Toast.LENGTH_SHORT
        ).show()
         */

        // Terminamos actividad
        finish()
    }

    internal fun isValidPassword(password: String): Boolean {
        if (password.length < 8) return false
        if (password.filter { it.isDigit() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) return false
        if (password.filter { !it.isLetterOrDigit() }.firstOrNull() == null) return false

        return true
    }
}