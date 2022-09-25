package mx.itesm.banmxmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import mx.itesm.banmxmovil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // Prueba
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    // Función para irnos a actividad de Registro
    fun clickToRegister(view: View?) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    // Función para irnos a actividad de Log In
    fun clickToLogIn(view: View?) {
        val intent = Intent(this, LogActivity::class.java)
        startActivity(intent)
    }

}