package es.moviles.actividad1.menu

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import es.moviles.actividad1.R
import es.moviles.actividad1.models.Plato

class PlatoDetailActivity : AppCompatActivity() {
    private lateinit var  txtPlato: TextView
    private lateinit var txtDescripcion: TextView
    private lateinit var txtPrecio: TextView

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plato_detail)

        txtPlato = findViewById(R.id.detailName)
        txtDescripcion = findViewById(R.id.detailDescription)
        txtPrecio = findViewById(R.id.detailPrice)
        showPlato()

    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun showPlato(){
        //Platos
        val plato = intent.extras?.getSerializable("platoToShow", Plato::class.java)
       if (plato!=null){
           txtPlato.text = plato.nombre
           txtDescripcion.text = plato.descripcion
           txtPrecio.text = plato.precio.toString() + " €"
       }
    }
}