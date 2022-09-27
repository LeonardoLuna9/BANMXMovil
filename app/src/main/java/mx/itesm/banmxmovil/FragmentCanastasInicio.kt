package mx.itesm.banmxmovil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_canastas_inicio, container, false)
        queue = Volley.newRequestQueue(context)
        listaCanastas = ArrayList()
        var url = "https://raw.githubusercontent.com/EdgarV7/JasonsProyecto/main/frutas.json"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            {response ->
                for(i in 0 until response.length()){
                    val actual = response.getJSONObject(i)
                    listaCanastas.add(i, arrayListOf(actual.getString("nombre"),actual.getString("precio"),actual.getString("paquete"),actual.getString("descripcion")))
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

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}