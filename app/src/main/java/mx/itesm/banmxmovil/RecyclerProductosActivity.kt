package mx.itesm.banmxmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class RecyclerProductosActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var catgory : TextView
    private val TAG = "request"
    private lateinit var queue: RequestQueue
    lateinit var recyclerView: RecyclerView
    lateinit var lista : ArrayList<ArrayList<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_productos)

        queue = Volley.newRequestQueue(this)
        val textIntent : Intent = intent
        var texto : String? = textIntent.getStringExtra("ctgory")

        catgory = findViewById(R.id.categoria)

        catgory.text = texto

        if(catgory.text == "Frutas"){
            Toast.makeText(this, "CARGANDO DATOS, ESPERO UN MOMENTO", Toast.LENGTH_SHORT).show()
            lista = ArrayList()
            var url = "https://raw.githubusercontent.com/EdgarV7/JasonsProyecto/main/frutas.json"

            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                {response ->
                    for(i in 0 until response.length()){
                        val actual = response.getJSONObject(i)
                        lista.add(i, arrayListOf(actual.getString("nombre"),actual.getString("precio"),actual.getString("paquete"),actual.getString("descripcion")))
                    }

                    val adapter = ProductosAdapter(lista,this)

                    recyclerView = findViewById(R.id.recyclerView)

                    val llm = LinearLayoutManager(this)
                    llm.orientation = LinearLayoutManager.VERTICAL

                    recyclerView.layoutManager = llm
                    recyclerView.adapter = adapter
                },{error ->
                    Toast.makeText(this,"error: $error", Toast.LENGTH_SHORT).show()
                }
            ).apply {
                tag = TAG
            }
            queue.add(jsonArrayRequest)
        }

        if(catgory.text == "Abarrotes"){
            Toast.makeText(this, "CARGANDO DATOS, ESPERO UN MOMENTO", Toast.LENGTH_SHORT).show()
            lista = ArrayList()
            var url = "https://raw.githubusercontent.com/EdgarV7/JasonsProyecto/main/abarrotes.json"

            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                {response ->
                    for(i in 0 until response.length()){
                        val actual = response.getJSONObject(i)
                        lista.add(i, arrayListOf(actual.getString("nombre"),actual.getString("precio"),actual.getString("paquete"),actual.getString("descripcion")))
                    }

                    val adapter = ProductosAdapter(lista,this)

                    recyclerView = findViewById(R.id.recyclerView)

                    val llm = LinearLayoutManager(this)
                    llm.orientation = LinearLayoutManager.VERTICAL

                    recyclerView.layoutManager = llm
                    recyclerView.adapter = adapter
                },{error ->
                    Toast.makeText(this,"error: $error", Toast.LENGTH_SHORT).show()
                }
            ).apply {
                tag = TAG
            }
            queue.add(jsonArrayRequest)
        }

        if(catgory.text == "No comestibles"){
            Toast.makeText(this, "CARGANDO DATOS, ESPERO UN MOMENTO", Toast.LENGTH_SHORT).show()
            lista = ArrayList()
            var url = "https://raw.githubusercontent.com/EdgarV7/JasonsProyecto/main/nocomestibles.json"

            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                {response ->
                    for(i in 0 until response.length()){
                        val actual = response.getJSONObject(i)
                        lista.add(i, arrayListOf(actual.getString("nombre"),actual.getString("precio"),actual.getString("paquete"),actual.getString("descripcion")))
                    }

                    val adapter = ProductosAdapter(lista,this)

                    recyclerView = findViewById(R.id.recyclerView)

                    val llm = LinearLayoutManager(this)
                    llm.orientation = LinearLayoutManager.VERTICAL

                    recyclerView.layoutManager = llm
                    recyclerView.adapter = adapter
                },{error ->
                    Toast.makeText(this,"error: $error", Toast.LENGTH_SHORT).show()
                }
            ).apply {
                tag = TAG
            }
            queue.add(jsonArrayRequest)
        }

        if(catgory.text == "Embutidos/Lácteos"){
            Toast.makeText(this, "CARGANDO DATOS, ESPERO UN MOMENTO", Toast.LENGTH_SHORT).show()
            lista = ArrayList()
            var url = "https://raw.githubusercontent.com/EdgarV7/JasonsProyecto/main/embutidos.json"

            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                {response ->
                    for(i in 0 until response.length()){
                        val actual = response.getJSONObject(i)
                        lista.add(i, arrayListOf(actual.getString("nombre"),actual.getString("precio"),actual.getString("paquete"),actual.getString("descripcion")))
                    }

                    val adapter = ProductosAdapter(lista,this)

                    recyclerView = findViewById(R.id.recyclerView)

                    val llm = LinearLayoutManager(this)
                    llm.orientation = LinearLayoutManager.VERTICAL

                    recyclerView.layoutManager = llm
                    recyclerView.adapter = adapter
                },{error ->
                    Toast.makeText(this,"error: $error", Toast.LENGTH_SHORT).show()
                }
            ).apply {
                tag = TAG
            }
            queue.add(jsonArrayRequest)
        }
    }

    override fun onStop() {
        super.onStop()

        queue.cancelAll(TAG)
    }

    override fun onClick(row: View) {
        val position = recyclerView.getChildLayoutPosition(row)
        Toast.makeText(this, lista[position][0], Toast.LENGTH_SHORT).show()
        val intent = Intent(this,ProductoMuestraActivity::class.java)

        intent.putExtra("nombre",lista[position][0])
        intent.putExtra("precio",lista[position][1])
        intent.putExtra("paquete",lista[position][2])
        intent.putExtra("descripcion",lista[position][3])

        startActivity(intent)
    }
}