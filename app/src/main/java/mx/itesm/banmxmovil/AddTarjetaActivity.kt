package mx.itesm.banmxmovil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityAddTarjetaBinding


class AddTarjetaActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {

    var opcion1: RadioButton? = null
    var opcion2: RadioButton? = null
    var radiogroup: RadioGroup? = null

    lateinit var binding : ActivityAddTarjetaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_add_tarjeta)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_tarjeta)
    }

    val lanzador = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

        // 1ero - revisar código
        if(result.resultCode == Activity.RESULT_OK) {

            val datos = result.data
            //val datosTarjeta = intent.getStringArrayListExtra("miLista") as ArrayList<String>? obtener datos del array

            // aqui se actualizan los datos que recibe desde agregar tarjeta, se intentara hacerlo directo a firestore
            // seleccionar entre tarjetas
            radiogroup = findViewById(R.id.RadioGroup3)
            tarjeta1 = findViewById(R.id.radioButton6)
            tarjeta2 = findViewById(R.id.radioButton11)
            radiogroup?.setOnCheckedChangeListener(this)
        }
    }

    fun iraTarjetaActivty(view: View?){


       // val arrayDatosTarjeta = ArrayList<String>()
        val intent = Intent(this, TarjetaActivity::class.java)
        // texto tarjeta = intent.getStringArrayListExtra("miLista", arrayDatosTarjeta)


        //intent.putExtra("Tarjeta i", "datosTarjeta") //array de 3 valores
        //intent.putExtra("Tarjeta i+1", "datosTarjeta")//array de 3 valores
        //intent.putExtra("Tarjeta i+2", "datosTarjeta")//array de 3 valores

        lanzador.launch(intent)

    }
    fun regresarAPerfil(view: View?){
        finish()
    }

    override fun onCheckedChanged(p0: RadioGroup?, idRadio: Int){
        when (idRadio) {
            opcion1?.id -> Toast.makeText(this, "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
            opcion2?.id -> Toast.makeText(this, "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
        }
    }

}