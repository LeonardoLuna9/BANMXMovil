package mx.itesm.banmxmovil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityTarjetaBinding

class TarjetaActivity : AppCompatActivity() {

    lateinit var binding : ActivityTarjetaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_tarjeta)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tarjeta)
    }

    fun guardarAddTarjetaActivty(view: View?) {

        val arrayDatosTarjeta = ArrayList<String>()

        arrayDatosTarjeta.add(binding.nombreInputTarjeta.text.toString())
        arrayDatosTarjeta.add(binding.numTarjetaInputTarjeta.text.toString())
        arrayDatosTarjeta.add(binding.expInputTarjeta.text.toString())
        arrayDatosTarjeta.add(binding.codigoInputTarjeta.text.toString())

        val intent = Intent(this, AddTarjetaActivity::class.java)
        intent.putStringArrayListExtra("arrayDatosTarjeta", arrayDatosTarjeta)
        //setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun regresaraAddTarjetaActivity(view: View?){
        finish()
    }
}