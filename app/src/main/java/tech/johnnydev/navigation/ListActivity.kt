package tech.johnnydev.navigation

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListActivity : AppCompatActivity() {

    private lateinit var lvProducts: ListView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.list_products)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lvProducts = findViewById(R.id.list_products)

        lvProducts.setOnItemClickListener{ parent, view, position, id->
            val codSelecionado = position +1;

            intent.putExtra("codeRetorno", codSelecionado)
            setResult(RESULT_OK, intent)
            finish()

        }
    }
}