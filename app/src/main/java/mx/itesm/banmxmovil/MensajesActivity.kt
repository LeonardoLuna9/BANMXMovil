package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityMensajesBinding
import mx.itesm.banmxmovil.databinding.ActivityOrdenesBinding

class MensajesActivity : AppCompatActivity() {
    lateinit var binding : ActivityMensajesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_mensajes)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mensajes)
    }
}