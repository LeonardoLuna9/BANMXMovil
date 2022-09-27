package mx.itesm.banmxmovil

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentProductosInicio : Fragment() {
    lateinit var vista : View
    lateinit var frutas : Button
    lateinit var abarrotes : Button
    lateinit var noComestible : Button
    lateinit var embutidos : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_productos_inicio, container, false)
        frutas = vista.findViewById(R.id.buttonFrutas)
        abarrotes = vista.findViewById(R.id.buttonAbarrotes)
        noComestible = vista.findViewById(R.id.buttonNocomestible)
        embutidos = vista.findViewById(R.id.buttonEmbutidos)
        frutas.setOnClickListener{
            val intent = Intent(context,RecyclerProductosActivity::class.java)
            intent.putExtra("ctgory","Frutas")
            startActivity(intent)
        }
        abarrotes.setOnClickListener {
            val intent = Intent(context,RecyclerProductosActivity::class.java)
            intent.putExtra("ctgory","Abarrotes")
            startActivity(intent)
        }
        noComestible.setOnClickListener{
            val intent = Intent(context,RecyclerProductosActivity::class.java)
            intent.putExtra("ctgory","No comestibles")
            startActivity(intent)
        }
        embutidos.setOnClickListener{
            val intent = Intent(context,RecyclerProductosActivity::class.java)
            intent.putExtra("ctgory","Embutidos/Lácteos")
            startActivity(intent)
        }
        return vista
    }
}