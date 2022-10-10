package mx.itesm.banmxmovil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley


class FragmentCanastasInicio : Fragment(), View.OnClickListener {
    lateinit var vista : View
    lateinit var listaCanastas : ArrayList<ArrayList<String>>
    lateinit var recyclerView : RecyclerView
    private val TAG = "request"
    private lateinit var queue: RequestQueue
    private var value1: String = "No"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            value1 = bundle.getString("VALUE1", "No").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_canastas_inicio, container, false)
        queue = Volley.newRequestQueue(context)
        listaCanastas = ArrayList()
        var url = "https://raw.githubusercontent.com/EdgarV7/JasonsProyecto/main/canastas.json"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            {response ->
                for(i in 0 until response.length()){
                    val actual = response.getJSONObject(i)
                    listaCanastas.add(i, arrayListOf(actual.getString("nombre"),actual.getString("precio"),actual.getString("imagen"),actual.getString("paquete"),actual.getString("descripcion")))
                }

                val adapter = ProductosAdapter(listaCanastas,this)

                recyclerView = requireView().findViewById(R.id.recyclerView)

                val llm = LinearLayoutManager(context)
                llm.orientation = LinearLayoutManager.VERTICAL

                recyclerView.layoutManager = llm
                recyclerView.adapter = adapter
            },{error ->
                Toast.makeText(context,"error: $error", Toast.LENGTH_SHORT).show()
            }
        ).apply {
            tag = TAG
        }
        queue.add(jsonArrayRequest)


        return vista
    }

    override fun onStop() {
        super.onStop()

        queue.cancelAll(TAG)
    }

    override fun onClick(row: View) {
        val position = recyclerView.getChildLayoutPosition(row)
        Toast.makeText(context, listaCanastas[position][0], Toast.LENGTH_SHORT).show()

        val action = InicioFragmentDirections.actionInicioFragmentToProductoMuestraFragment(
            listaCanastas[position][0],
            listaCanastas[position][1].toString(),
            listaCanastas[position][2],
            listaCanastas[position][3],
            listaCanastas[position][4],
            value1
        )

        findNavController().navigate(action)
        /*val intent = Intent(context,ProductoMuestraActivity::class.java)

        intent.putExtra("nombre",listaCanastas[position][0])
        intent.putExtra("precio",listaCanastas[position][1])
        intent.putExtra("imagen",listaCanastas[position][2])
        intent.putExtra("paquete",listaCanastas[position][3])
        intent.putExtra("descripcion",listaCanastas[position][4])

        startActivity(intent)*/
    }
}