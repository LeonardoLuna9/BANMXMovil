package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityMainBinding
import mx.itesm.banmxmovil.databinding.ActivityPerfilBinding

class PerfilActivity : AppCompatActivity() {
    lateinit var binding : ActivityPerfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_perfil)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_perfil)
    }
}