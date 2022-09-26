package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityTarjetaBinding

class TarjetaActivity : AppCompatActivity() {

    lateinit var binding : ActivityTarjetaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_tarjeta)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tarjeta)
    }
}