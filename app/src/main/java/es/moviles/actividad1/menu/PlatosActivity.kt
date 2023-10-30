package es.moviles.actividad1.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.moviles.actividad1.R
import es.moviles.actividad1.models.Plato

class PlatosActivity : AppCompatActivity() {
    private val platos = listOf<Plato>(
        Plato("pizza", "maragarita", 33.2),
        Plato("pizza", "maragarita", 33.2),
        Plato("pizza", "maragarita", 33.2),
        Plato("pizza", "maragarita", 33.2),
        Plato("pizza", "maragarita", 33.2),
    )

    private lateinit var rvPlatos: RecyclerView
    private lateinit var platosAdapter: PlatosAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_platos)

        initComponent()
        initUI()
    }

    private fun initComponent() {
        rvPlatos = findViewById(R.id.rvPlatos)
    }

    //Inicializacion de RecyclerViews
    private fun initUI() {
        platosAdapter = PlatosAdapter(platos)
        rvPlatos.layoutManager =
            GridLayoutManager(this,2) //2 columnas
        rvPlatos.adapter = platosAdapter
    }
}