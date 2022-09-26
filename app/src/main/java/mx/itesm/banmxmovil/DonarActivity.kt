package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityDonarBinding

class DonarActivity : AppCompatActivity() {

    lateinit var binding : ActivityDonarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_donar)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_donar)
    }
}