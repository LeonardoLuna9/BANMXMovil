package mx.itesm.banmxmovil

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import androidx.navigation.fragment.findNavController

class FragmentProductosInicio : Fragment(), View.OnClickListener {
    lateinit var vista : View
    lateinit var listaProductos : ArrayList<ArrayList<String>>
    lateinit var recyclerViewProductos : RecyclerView
    private val TAG = "request"
    private lateinit var queue: RequestQueue
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
        queue = Volley.newRequestQueue(context)
        frutas = vista.findViewById(R.id.buttonFrutas)
        abarrotes = vista.findViewById(R.id.buttonAbarrotes)
        noComestible = vista.findViewById(R.id.buttonNocomestible)
        embutidos = vista.findViewById(R.id.buttonEmbutidos)
        frutas.setOnClickListener{
            listaProductos = ArrayList()
            var url = "https://raw.githubusercontent.com/EdgarV7/JasonsProyecto/main/frutas.json"

            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                {response ->
                    for(i in 0 until response.length()){
                        val actual = response.getJSONObject(i)
                        listaProductos.add(i, arrayListOf(actual.getString("nombre"),actual.getString("precio"),actual.getString("imagen"),actual.getString("paquete"),actual.getString("descripcion")))
                    }

                    val adapter = ProductosAdapter(listaProductos,this)

                    recyclerViewProductos = requireView().findViewById(R.id.recyclerProductos)

                    val llm = LinearLayoutManager(context)
                    llm.orientation = LinearLayoutManager.VERTICAL

                    recyclerViewProductos.layoutManager = llm
                    recyclerViewProductos.adapter = adapter
                },{error ->
                    Toast.makeText(context,"error: $error", Toast.LENGTH_SHORT).show()
                }
            ).apply {
                tag = TAG
            }
            queue.add(jsonArrayRequest)
        }
        abarrotes.setOnClickListener {
            listaProductos = ArrayList()
            var url = "https://raw.githubusercontent.com/EdgarV7/JasonsProyecto/main/abarrotes.json"

            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                {response ->
                    for(i in 0 until response.length()){
                        val actual = response.getJSONObject(i)
                        listaProductos.add(i, arrayListOf(actual.getString("nombre"),actual.getString("precio"),actual.getString("imagen"),actual.getString("paquete"),actual.getString("descripcion")))
                    }

                    val adapter = ProductosAdapter(listaProductos,this)

                    recyclerViewProductos = requireView().findViewById(R.id.recyclerProductos)

                    val llm = LinearLayoutManager(context)
                    llm.orientation = LinearLayoutManager.VERTICAL

                    recyclerViewProductos.layoutManager = llm
                    recyclerViewProductos.adapter = adapter
                },{error ->
                    Toast.makeText(context,"error: $error", Toast.LENGTH_SHORT).show()
                }
            ).apply {
                tag = TAG
            }
            queue.add(jsonArrayRequest)
        }
        noComestible.setOnClickListener{
            listaProductos = ArrayList()
            var url = "https://raw.githubusercontent.com/EdgarV7/JasonsProyecto/main/nocomestibles.json"

            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                {response ->
                    for(i in 0 until response.length()){
                        val actual = response.getJSONObject(i)
                        listaProductos.add(i, arrayListOf(actual.getString("nombre"),actual.getString("precio"),actual.getString("imagen"),actual.getString("paquete"),actual.getString("descripcion")))
                    }

                    val adapter = ProductosAdapter(listaProductos,this)

                    recyclerViewProductos = requireView().findViewById(R.id.recyclerProductos)

                    val llm = LinearLayoutManager(context)
                    llm.orientation = LinearLayoutManager.VERTICAL

                    recyclerViewProductos.layoutManager = llm
                    recyclerViewProductos.adapter = adapter
                },{error ->
                    Toast.makeText(context,"error: $error", Toast.LENGTH_SHORT).show()
                }
            ).apply {
                tag = TAG
            }
            queue.add(jsonArrayRequest)
        }
        embutidos.setOnClickListener{
            listaProductos = ArrayList()
            var url = "https://raw.githubusercontent.com/EdgarV7/JasonsProyecto/main/embutidos.json"

            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                {response ->
                    for(i in 0 until response.length()){
                        val actual = response.getJSONObject(i)
                        listaProductos.add(i, arrayListOf(actual.getString("nombre"),actual.getString("precio"),actual.getString("imagen"),actual.getString("paquete"),actual.getString("descripcion")))
                    }

                    val adapter = ProductosAdapter(listaProductos,this)

                    recyclerViewProductos = requireView().findViewById(R.id.recyclerProductos)

                    val llm = LinearLayoutManager(context)
                    llm.orientation = LinearLayoutManager.VERTICAL

                    recyclerViewProductos.layoutManager = llm
                    recyclerViewProductos.adapter = adapter
                },{error ->
                    Toast.makeText(context,"error: $error", Toast.LENGTH_SHORT).show()
                }
            ).apply {
                tag = TAG
            }
            queue.add(jsonArrayRequest)
        }
        return vista
    }

    override fun onStop() {
        super.onStop()

        queue.cancelAll(TAG)
    }

    override fun onClick(row: View) {
        val position = recyclerViewProductos.getChildLayoutPosition(row)
        Toast.makeText(context, listaProductos[position][0], Toast.LENGTH_SHORT).show()

        val action = InicioFragmentDirections.actionInicioFragmentToProductoMuestraFragment(
            listaProductos[position][0],
            listaProductos[position][1].toString(),
            listaProductos[position][2],
            listaProductos[position][3],
            listaProductos[position][4]
        )

        findNavController().navigate(action)
        /*val intent = Intent(context,ProductoMuestraActivity::class.java)

        intent.putExtra("nombre",listaProductos[position][0])
        intent.putExtra("precio",listaProductos[position][1])
        intent.putExtra("imagen",listaProductos[position][2])
        intent.putExtra("paquete",listaProductos[position][3])
        intent.putExtra("descripcion",listaProductos[position][4])

        startActivity(intent)*/
    }
}