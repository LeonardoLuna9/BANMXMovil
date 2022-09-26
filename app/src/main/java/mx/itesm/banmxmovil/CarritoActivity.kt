package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityCarritoBinding

class CarritoActivity : AppCompatActivity() {

    lateinit var binding : ActivityCarritoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_carrito)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_carrito)
    }


}