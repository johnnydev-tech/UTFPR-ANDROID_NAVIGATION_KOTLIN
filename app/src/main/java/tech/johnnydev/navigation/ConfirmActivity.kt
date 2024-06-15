package tech.johnnydev.navigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmActivity : AppCompatActivity() {

    private lateinit var tvCod: TextView
    private lateinit var tvQtd: TextView
    private lateinit var tvValor: TextView

    private lateinit var btSend: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirm)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvCod = findViewById(R.id.tvCod)
        tvQtd = findViewById(R.id.tvQtd)
        tvValor = findViewById(R.id.tvValor)

        btSend = findViewById(R.id.btSend)


        val cod = intent.getStringExtra("cod")
        val qtd = intent.getStringExtra("qtd")
        val valor = intent.getStringExtra("valor")

        tvCod.text = cod
        tvQtd.text = qtd
        tvValor.text = valor

        btSend.setOnClickListener {
            btSendOnClick()
        }
    }


    private fun btSendOnClick() {
        val smsBody = "Cod: ${tvCod.text} Qtd: ${tvQtd.text} Valor: ${tvValor.text}"
        val phoneNumer = "sms:+5599999999999"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(phoneNumer))
        intent.putExtra("sms_body", smsBody)
        startActivity(intent)

    }
}