package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityOrdenesBinding

class OrdenesActivity : AppCompatActivity() {

    lateinit var binding : ActivityOrdenesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ordenes)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ordenes)
    }
}