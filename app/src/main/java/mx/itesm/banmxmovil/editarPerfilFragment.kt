package mx.itesm.banmxmovil

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class editarPerfilFragment : Fragment() {

    val args : editarPerfilFragmentArgs by navArgs()
    val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_editar_perfil, container, false)

        // verificamos usuario
        if(Firebase.auth.currentUser == null) {

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }

        // Guardamos cambios
        view.findViewById<Button>(R.id.guardarBotonEditarPerfil).setOnClickListener{
            val action = editarPerfilFragmentDirections
                .actionEditarPerfilFragmentToPerfilFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)

            val data = hashMapOf(
                "nombre" to view.findViewById<EditText>(R.id.nameInputEditarPerfil).text.toString()
            )
            db.collection("usuarios").document("${args.idUsuario}").set(data)
            Toast.makeText(context, "Información Guardada", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<ImageButton>(R.id.regresarBotonEditarPerfil).setOnClickListener{
            val action = editarPerfilFragmentDirections
                .actionEditarPerfilFragmentToPerfilFragment(
                    args.idUsuario
                )
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.borrarCuentaBotonEditarPerfil).setOnClickListener{
            val user = Firebase.auth.currentUser!!

            db.collection("usuarios").document("${args.idUsuario}")
                .delete()
                .addOnSuccessListener {
                    Log.d("FIRESTORE DELETE", "DocumentSnapshot successfully deleted!")
                }
                .addOnFailureListener { e ->
                    Log.w("FIRESTORE DELETE", "Error deleting document", e)
                    Toast.makeText(
                        context,
                        "CUENTA NO SE PUDO BORRAR: $e",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            user.delete()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            context,
                            "CUENTA BORRADA EXITOSAMENTE",
                            Toast.LENGTH_SHORT
                        ).show()
                        requireActivity().finish()
                        Log.d("FIREBASE AUTH DELETE", "User account deleted.")
                    }
                }
        }

        return view
    }


}