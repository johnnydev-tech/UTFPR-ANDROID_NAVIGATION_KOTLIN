package tech.johnnydev.navigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LaunchActivity : AppCompatActivity() {
    private lateinit var etCod : EditText
    private lateinit var etQtd : EditText
    private lateinit var etValor : EditText

    private lateinit var btConfirm : Button
    private lateinit var btListar : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_launch)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etCod = findViewById(R.id.etCod)
        etQtd = findViewById(R.id.etQtd)
        etValor = findViewById(R.id.etValor)

        btConfirm = findViewById(R.id.btConfirmar)
        btListar = findViewById(R.id.btListar)

        btConfirm.setOnClickListener{
            btConfirmOnCLick()
        }

        btListar.setOnClickListener{
            btListarOnClick()
        }
    }

    private fun btListarOnClick() {
//        val intent = Intent(this, LaunchActivity::class.java)
//        startActivity(intent)
        Toast.makeText(this, "Listar", Toast.LENGTH_SHORT).show()
    }

    private fun btConfirmOnCLick() {
        val intent = Intent(this, ConfirmActivity::class.java)
        startActivity(intent)
    }
}