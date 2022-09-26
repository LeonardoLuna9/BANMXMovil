package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityAddTarjetaBinding

class AddTarjetaActivity : AppCompatActivity() {

    lateinit var binding : ActivityAddTarjetaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_add_tarjeta)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_tarjeta)
    }
}