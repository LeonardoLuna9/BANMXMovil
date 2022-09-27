package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityAgradecimientoBinding
import mx.itesm.banmxmovil.databinding.ActivityTarjetaPerfilBinding

class AgradecimientoActivity : AppCompatActivity() {
    lateinit var binding : ActivityAgradecimientoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_agradecimiento)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_agradecimiento)
    }
}