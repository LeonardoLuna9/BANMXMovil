package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityPagoBinding
import mx.itesm.banmxmovil.databinding.ActivityTarjetaBinding

class PagoActivity : AppCompatActivity() {

    lateinit var binding : ActivityPagoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_pago)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pago)
    }
}