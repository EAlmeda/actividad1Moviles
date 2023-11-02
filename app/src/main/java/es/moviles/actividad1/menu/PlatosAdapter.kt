package es.moviles.actividad1.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.moviles.actividad1.R
import es.moviles.actividad1.models.Plato


class PlatosAdapter(private val platos: List<Plato>,val clickPlato:(Int)->Unit ) : RecyclerView.Adapter<PlatosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plato, parent, false)
        val platosViewHolder = PlatosViewHolder(view)
        view.setOnClickListener{
            clickPlato.invoke(platosViewHolder.adapterPosition)
        }
       val imagenView = view.findViewById<ImageView>(R.id.imagenRuta)
        imagenView.setImageResource(R.drawable.pizza); //en vez de pizza poner lo de cada elemento
        return platosViewHolder
    }

    override fun getItemCount() = platos.size

    override fun onBindViewHolder(holder: PlatosViewHolder, position: Int) {
        holder.render(platos[position])

    }
}