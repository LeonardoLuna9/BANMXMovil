package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityApadrinarBinding
import mx.itesm.banmxmovil.databinding.ActivityDonarBinding

class ApadrinarActivity : AppCompatActivity() {

    lateinit var binding : ActivityApadrinarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_apadrinar)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_apadrinar)
    }
}