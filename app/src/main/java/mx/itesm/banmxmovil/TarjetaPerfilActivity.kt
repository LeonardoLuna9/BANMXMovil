package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityTarjetaBinding
import mx.itesm.banmxmovil.databinding.ActivityTarjetaPerfilBinding

class TarjetaPerfilActivity : AppCompatActivity() {

    lateinit var binding : ActivityTarjetaPerfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_tarjeta_perfil)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tarjeta_perfil)
    }
}