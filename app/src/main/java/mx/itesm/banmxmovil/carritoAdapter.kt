package mx.itesm.banmxmovil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class carritoAdapter(var carritoList : ArrayList<ArrayList<String>>) : RecyclerView.Adapter<carritoAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_list_productos,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nombreproducto.text = carritoList[position][0]
        holder.cantidad.text = carritoList[position][1].toString()
    }

    override fun getItemCount(): Int {
        return carritoList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nombreproducto: TextView = itemView.findViewById(R.id.nombreProducto)
        val cantidad : TextView = itemView.findViewById(R.id.precioProducto)
    }
}