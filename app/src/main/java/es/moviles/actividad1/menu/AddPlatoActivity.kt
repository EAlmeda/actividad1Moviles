package es.moviles.actividad1.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import es.moviles.actividad1.R
import es.moviles.actividad1.models.Plato

class AddPlatoActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtDescripcion: EditText
    private lateinit var edtPrecio: EditText
    private lateinit var btnAdd: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plato)

        edtNombre = findViewById<EditText>(R.id.edtNombre)
        edtDescripcion = findViewById<EditText>(R.id.edtDescripcion)
        edtPrecio = findViewById<EditText>(R.id.edtPrecio)
        btnAdd = findViewById<Button>(R.id.btnAnadir)
        setButton()
    }

    private fun setButton() {
        btnAdd.setOnClickListener {
            var platoToAdd = Plato(
                edtNombre.text.toString(),
                edtDescripcion.text.toString(),
                edtPrecio.text.toString().toDouble(),
                 "plato.jpg"
            )
            val intent = Intent(this, PlatosActivity::class.java)
            intent.putExtra("platoToAdd", platoToAdd)
            startActivity(intent)
        }
    }
}