package mx.itesm.banmxmovil

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import mx.itesm.banmxmovil.databinding.ActivityEditarPerfilBinding

class EditarPerfilActivity : AppCompatActivity() {

    // Access a Cloud Firestore instance from your Activity

    val db = Firebase.firestore

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
        val city = hashMapOf(
            "name" to "Los Angeles",
            "state" to "CA",
            "country" to "USA"
        )

        db.collection("usuarios/prueba@mail.com/carrito").document("productoID").set(city)

        /*
            .set(city)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
            */
        //finish()
    }
}