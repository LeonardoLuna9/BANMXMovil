package mx.itesm.banmxmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityPagoBinding

var tarjeta1:RadioButton? = null
var tarjeta2:RadioButton? = null
var tarjeta3:RadioButton? = null
var radiogroup:RadioGroup? = null

class PagoActivity : AppCompatActivity() {

    lateinit var binding : ActivityPagoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_pago)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pago)

        radiogroup = findViewById(R.id.radioGroup2)
        tarjeta1 = findViewById(R.id.botonTarjetaCreditoPago)
        tarjeta2 = findViewById(R.id.botonTarjetaDebitoPago)
        tarjeta3 = findViewById(R.id.botonPaypalPago)
        radiogroup?.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(p0: RadioGroup?, idRadio: Int){
        when (idRadio) {
            tarjeta1?.id -> Toast.makeText(this, "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
            tarjeta2?.id -> Toast.makeText(this, "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
            tarjeta3?.id -> Toast.makeText(this, "Tarjeta Seleccionada", Toast.LENGTH_LONG).show()
        }
    }
}