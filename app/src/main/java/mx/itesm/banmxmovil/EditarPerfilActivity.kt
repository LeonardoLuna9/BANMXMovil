package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityEditarPerfilBinding

class EditarPerfilActivity : AppCompatActivity() {
    lateinit var binding : ActivityEditarPerfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_editar_perfil)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_editar_perfil)
    }
}