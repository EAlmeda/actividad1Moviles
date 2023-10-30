package es.moviles.actividad1.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.moviles.actividad1.R
import es.moviles.actividad1.models.Plato


class PlatosAdapter(private val platos: List<Plato>) : RecyclerView.Adapter<PlatosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plato, parent, false)
        return PlatosViewHolder(view)
    }

    override fun getItemCount() = platos.size

    override fun onBindViewHolder(holder: PlatosViewHolder, position: Int) {
        holder.render(platos[position])

    }
}