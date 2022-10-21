package mx.itesm.banmxmovil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.braintreepayments.api.dropin.DropInRequest
import com.braintreepayments.api.dropin.DropInResult
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.TextHttpResponseHandler
import cz.msebera.android.httpclient.Header

class Transaccion : AppCompatActivity() {

    internal lateinit var token:String
    internal lateinit var amount:String
    internal var paramsHash:HashMap<String,String>?=null

    private lateinit var btn_pay: Button
    private lateinit var payment_group: LinearLayout
    private lateinit var waiting_group: LinearLayout
    private lateinit var edt_payment: TextView

    companion object{
        val API_GET_TOKEN = "http://10.0.2.2/braintree/main.php"
        val API_CHECKOUT = "http://10.0.2.2/braintree/checkout.php"
        val REQUEST_CODE: Int = 7777

    }


    private var value1: String = "No" // Cantidad a pagar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaccion)

        btn_pay = findViewById(R.id.btn_pay)
        payment_group = findViewById(R.id.payment_group)
        waiting_group = findViewById(R.id.waiting_group)
        edt_payment = findViewById(R.id.edt_payment)

        value1 = intent.getStringExtra("cantidad").toString() // Este es la cantidad recibida para pagar
        Log.d("Value1", value1)
        getToken();
        btn_pay.setOnClickListener {
            val dropInRequest = DropInRequest().clientToken(token)
            startActivityForResult(dropInRequest.getIntent(this), REQUEST_CODE)
        }

        edt_payment.setText("$"+ value1)
    }

    private fun getToken(){
        val androidClient = AsyncHttpClient();
        androidClient.get(API_GET_TOKEN,object:TextHttpResponseHandler(){
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseString: String?) {
                runOnUiThread {
                    payment_group.visibility = View.VISIBLE
                    waiting_group.visibility = View.GONE
                    token = responseString!!
                }
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseString: String?, throwable: Throwable?) {
                runOnUiThread {
                    Toast.makeText(this@Transaccion, "Failed to get token: " +throwable.toString(),Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                val result = data!!.getParcelableExtra<DropInResult>(DropInResult.EXTRA_DROP_IN_RESULT)
                val nonce = result?.paymentMethodNonce
                val stringNonce = nonce!!.nonce

                if(!edt_payment.text.toString().isEmpty())
                {
                    edt_payment.text.toString().replace("$", "")
                    amount = edt_payment.text.toString()
                    paramsHash = HashMap()

                    paramsHash!!["amount"] = amount
                    paramsHash!!["nonce"] = stringNonce

                    sendPayments()
                }
                else
                    Toast.makeText(this@Transaccion, "Ingresa monto valido", Toast.LENGTH_SHORT).show()
            }
            else if(resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this@Transaccion, "User Cancel", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendPayments(){
        val queue = Volley.newRequestQueue(this@Transaccion)

        val stringRequest = object:StringRequest(Request.Method.POST, API_CHECKOUT,
            Response.Listener { response ->
                if (response.toString().contains("Successful")) {
                    Toast.makeText(this@Transaccion, "Transaction Succesfull", Toast.LENGTH_SHORT).show()
                    // Vamos a irnos a la actividad de agradecimiento - Agradecidos con el de arriba
                    val intent = Intent(this, AgradecimientoActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else
                    Toast.makeText(this@Transaccion, "Transaction Failed", Toast.LENGTH_SHORT).show()
            },Response.ErrorListener { error ->
                Log.d("EDMT ERROR","Volley error: "+error.message)
            })
        {
            override fun getParams(): MutableMap<String,String?>?{
                if (paramsHash==null)
                    return null
                var params = HashMap<String,String?> ()
                for (key in paramsHash!!.keys)
                    params.set(key,paramsHash!![key])
                return params
            }
            override fun getHeaders(): MutableMap<String, String>{
                val params = HashMap<String,String>()
                params["Content-Type"] = "application/x-www-form-urlencoded"
                return params
            }
        }

        queue.add(stringRequest)
    }
}