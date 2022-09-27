package mx.itesm.banmxmovil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductosAdapter (var datos : ArrayList<ArrayList<String>>, var listener : View.OnClickListener) :  RecyclerView.Adapter<ProductosAdapter.DatosViewHolder>() {

    class DatosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var texto1 : TextView
        var texto2 : TextView

        init {
            texto1 = itemView.findViewById(R.id.rowText1)
            texto2 = itemView.findViewById(R.id.rowText2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatosViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_productos, parent, false)
        view.setOnClickListener(listener)
        view.setOnClickListener(listener)
        val viewHolder = DatosViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: DatosViewHolder, position: Int) {
        holder.texto1.text = datos[position][0]
        holder.texto2.text = datos[position][1]
    }

    override fun getItemCount(): Int {
        return datos.size
    }
}