package mx.itesm.banmxmovil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class carritoAdapter(var carritoList : ArrayList<ArrayList<String>>,private val onClickDelete:(Int) -> Unit) : RecyclerView.Adapter<carritoAdapter.MyViewHolder>(){

    private var listData = carritoList
    val db = Firebase.firestore
    // Initialize Firebase Auth
    val auth = Firebase.auth

    val user = Firebase.auth.currentUser
    lateinit var email : String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_list_carrito,parent,false)
        user?.let {
            // Name, email address, and profile photo Url
            //val name = user.displayName
            email = user.email!!
            //val photoUrl = user.photoUrl
        }
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nombreproducto.text = listData[position][0]
        holder.cantidad.text = listData[position][1].toString()
        Picasso.get().load(listData[position][2]).into(holder.imagenproducto)
        holder.precioproducto.text = listData[position][3]

        // Subir cantidad
        holder.botonaddd.setOnClickListener {
            holder.cantidad.text = (holder.cantidad.text.toString().toInt() + 1).toString()
            val data = hashMapOf(
                "nombre" to listData[position][0],
                "cantidad" to holder.cantidad.text.toString(),
                "imagen" to listData[position][2],
                "precio" to listData[position][3]
            )
            db.collection("usuarios/${email}/carrito")
                .document(listData[position][0]).set(data)

        }
        // Bajar cantidad
        holder.botonless.setOnClickListener {
            holder.cantidad.text = (holder.cantidad.text.toString().toInt() - 1).toString()
            val data = hashMapOf(
                "nombre" to listData[position][0],
                "cantidad" to holder.cantidad.text.toString(),
                "imagen" to listData[position][2],
                "precio" to listData[position][3]
            )
            //db.collection("usuarios").document("${email}").set(data)
            db.collection("usuarios/${email}/carrito")
                .document(listData[position][0]).set(data)
        }
        holder.botonDelete.setOnClickListener{
            onClickDelete(position)
            // Aqui backend
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    fun setItems(items: ArrayList<ArrayList<String>>){
        listData = items
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nombreproducto: TextView = itemView.findViewById(R.id.nombreProductoCarrito)
        val cantidad : TextView = itemView.findViewById(R.id.numeroProducto)
        val imagenproducto : ImageView = itemView.findViewById(R.id.carritoProducto)
        val precioproducto : TextView = itemView.findViewById(R.id.precioProductoCarrito)
        val botonaddd : Button = itemView.findViewById(R.id.buttonAdd)
        val botonless : Button = itemView.findViewById(R.id.buttonLess)
        val botonDelete : ImageButton = itemView.findViewById(R.id.buttonDelete)
    }
}