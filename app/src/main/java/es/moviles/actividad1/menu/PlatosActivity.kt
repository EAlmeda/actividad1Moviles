package es.moviles.actividad1.menu

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import es.moviles.actividad1.R
import es.moviles.actividad1.models.Plato

class PlatosActivity : AppCompatActivity() {
    private var platos = mutableListOf(
        Plato("Pizza", "Pizza pesto hecha al horno de piedra. Ingredientes: Mozarella, tomatito, albahaca y pesto.", 14.99, "pizza.jpg"),
        Plato("Ensalada", "Ensalada cesar con salsa agria. Ingredientes: Lechuga, tomate, picatostes, pollo, queso y salsa agria.", 12.10, "ensalada.jpg"),
        Plato("Nachos", "Nachos con guacamole, pico de gallo y queso chedar.", 9.10, "nachos.jpg"),
        Plato("Rissoto", "Risotto italiano. Ingredientes: arroz, champiñones, cebolla y queso parmesano.", 23.20, "risotto.jpg"),
    )

    private lateinit var rvPlatos: RecyclerView
    private lateinit var platosAdapter: PlatosAdapter
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platos)

        initComponent()
        initUI()
        setButtons()
        checkExtras()
    }

    private fun initComponent() {
        rvPlatos = findViewById(R.id.rvPlatos)
    }

    //Inicializacion de RecyclerViews
    private fun initUI() {
        platosAdapter = PlatosAdapter(platos, this::clickPlato)
        rvPlatos.layoutManager =
            GridLayoutManager(this,2) //2 columnas
        rvPlatos.adapter = platosAdapter

    }

    private fun clickPlato(position:Int){
        val intent = Intent(this, PlatoDetailActivity::class.java)

        intent.putExtra("platoToShow", platos[position])
        startActivity(intent)
    }

    private fun setButtons(){
        val fabAddPlato= findViewById<FloatingActionButton>(R.id.fab_add_plato)

        //Eventos
        fabAddPlato.setOnClickListener {
            Log.i("MENU --------- ","ADD PLATO")
            navegarHaciaApp(AddPlatoActivity::class.java)
        }
    }

    fun navegarHaciaApp(clase:Class<*>){
        val intent = Intent(this, clase)
        startActivity(intent)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun checkExtras(){
        //Platos
        val plato = intent.extras?.getSerializable("platoToAdd", Plato::class.java)

        if(plato != null)
            platos.add(plato)
    }
}