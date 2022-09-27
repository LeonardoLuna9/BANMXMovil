package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProductoMuestraActivity : AppCompatActivity() {
    private lateinit var nombreView : TextView
    private lateinit var precioView : TextView
    private lateinit var paqueteView : TextView
    private lateinit var descripcionView : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_muestra)

        nombreView = findViewById(R.id.nombre)
        precioView = findViewById(R.id.precio)
        paqueteView = findViewById(R.id.paquete)
        descripcionView = findViewById(R.id.descripcion)

        nombreView.text = intent.getStringExtra("nombre")
        precioView.text = intent.getStringExtra("precio")
        paqueteView.text = intent.getStringExtra("paquete")
        descripcionView.text = intent.getStringExtra("descripcion")
    }
}