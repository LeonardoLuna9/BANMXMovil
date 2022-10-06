package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController

class editarPerfilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_editar_perfil, container, false)

        view.findViewById<Button>(R.id.guardarBotonEditarPerfil).setOnClickListener{
            val action = editarPerfilFragmentDirections
                .actionEditarPerfilFragmentToPerfilFragment(
                    view.findViewById<EditText>(R.id.nameInputEditarPerfil).text.toString(),
                    view.findViewById<EditText>(R.id.correoInputEditarPerfil).text.toString(),
                    view.findViewById<EditText>(R.id.telefonoInputEditarPerfil).text.toString(),
                    view.findViewById<EditText>(R.id.nuevaContraInputEditarPerfil).text.toString()
                )
            findNavController().navigate(action)

        }

        return view
    }


}