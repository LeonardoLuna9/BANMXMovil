package mx.itesm.banmxmovil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_log, container, false)
        //verificarUsuario()

        // verificamos usuario
        if(Firebase.auth.currentUser == null){

            // SIGNIFICA QUE HAY NECESIDAD DE RE-VALIDAR EL USUARIO
            // podrías redireccionar / terminar esta actividad
            //Toast.makeText(context, "REVALIDA!", Toast.LENGTH_SHORT).show()
        } else {
            // Lo llevamos a inicio
            //findNavController().navigate(R.id.action_logFragment_to_inicioFragment)
            val action = LogFragmentDirections
                .actionLogFragmentToInicioFragment(
                    "${Firebase.auth.currentUser?.email}"
                )
            findNavController().navigate(action)
            /*
            Toast.makeText(
                context,
                "USUARIO: ${Firebase.auth.currentUser?.email}",
                Toast.LENGTH_SHORT
            ).show()
            */
        }

        view.findViewById<Button>(R.id.login).setOnClickListener {
            var emailStr = view.findViewById<EditText>(R.id.correoInputLog).text.toString()
            var pwdStr = view.findViewById<EditText>(R.id.passwordInputLog).text.toString()
            var authTask = Firebase.auth.signInWithEmailAndPassword(emailStr, pwdStr)

            authTask.addOnCompleteListener(requireActivity()) { resultado ->

                if(resultado.isSuccessful){
                    Toast.makeText(context, "LOGIN EXITOSO", Toast.LENGTH_SHORT).show()
                    // Lo llevamos a inicio
                    val action = LogFragmentDirections
                        .actionLogFragmentToInicioFragment(
                            emailStr
                        )
                    findNavController().navigate(action)
                    //findNavController().navigate(R.id.action_logFragment_to_inicioFragment)
                } else {

                    Toast.makeText(context, "ERROR EN LOGIN", Toast.LENGTH_SHORT).show()
                    view.findViewById<EditText>(R.id.passwordInputLog).setError("${resultado.exception?.message}")
                    //Log.e("FIREBASE-DEV", "error: ${resultado.exception?.message}")
                }
            }
            // Terminamos actividad
            //finish()
        }

        view.findViewById<TextView>(R.id.llevarARegistro).setOnClickListener {
            val intent = Intent(requireActivity(), RegisterActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }
}