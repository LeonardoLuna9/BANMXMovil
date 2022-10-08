package mx.itesm.banmxmovil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductosAdapter (var datos : ArrayList<ArrayList<String>>, var listener : View.OnClickListener) :  RecyclerView.Adapter<ProductosAdapter.DatosViewHolder>() {

    class DatosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var texto1 : TextView
        var texto2 : TextView
        var imagenProducto : ImageView

        init {
            texto1 = itemView.findViewById(R.id.nombreProducto)
            texto2 = itemView.findViewById(R.id.precioProducto)
            imagenProducto = itemView.findViewById(R.id.item_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatosViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_list_productos, parent, false)
        view.setOnClickListener(listener)
        view.setOnClickListener(listener)
        val viewHolder = DatosViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: DatosViewHolder, position: Int) {
        holder.texto1.text = datos[position][0]
        holder.texto2.text = datos[position][1]
        Picasso.get().load(datos[position][2]).into(holder.imagenProducto)
    }

    override fun getItemCount(): Int {
        return datos.size
    }
}