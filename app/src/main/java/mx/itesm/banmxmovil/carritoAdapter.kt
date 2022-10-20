package mx.itesm.banmxmovil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class carritoAdapter(var carritoList : ArrayList<ArrayList<String>>) : RecyclerView.Adapter<carritoAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_list_carrito,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nombreproducto.text = carritoList[position][0]
        holder.cantidad.text = carritoList[position][1].toString()
        //Picasso.get().load(carritoList[position][2]).into(holder.imagenproducto)
        //holder.precioproducto.text = carritoList[position][3]
        holder.botonaddd.setOnClickListener {
            holder.cantidad.text = (holder.cantidad.text.toString().toInt() + 1).toString()
        }
        holder.botonless.setOnClickListener {
            holder.cantidad.text = (holder.cantidad.text.toString().toInt() - 1).toString()
        }
    }

    override fun getItemCount(): Int {
        return carritoList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nombreproducto: TextView = itemView.findViewById(R.id.nombreProductoCarrito)
        val cantidad : TextView = itemView.findViewById(R.id.numeroProducto)
        val imagenproducto : ImageView = itemView.findViewById(R.id.carritoProducto)
        val precioproducto : TextView = itemView.findViewById(R.id.precioProductoCarrito)
        val botonaddd : Button = itemView.findViewById(R.id.buttonAdd)
        val botonless : Button = itemView.findViewById(R.id.buttonLess)
    }
}