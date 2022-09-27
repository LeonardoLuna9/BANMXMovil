package mx.itesm.banmxmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityApadrinarBinding

class ApadrinarActivity : AppCompatActivity() {

    lateinit var binding : ActivityApadrinarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_apadrinar)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_apadrinar)
    }

    fun irAInicio(view: View?){
        val intent = Intent(this, InicioActivity::class.java)
        startActivity(intent)
        finish()
    }
}