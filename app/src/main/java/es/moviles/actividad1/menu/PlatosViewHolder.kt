package es.moviles.actividad1.menu

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.moviles.actividad1.R
import es.moviles.actividad1.models.Plato

class PlatosViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    private val txtPlato: TextView =view.findViewById(R.id.txtPlato)
    private val txtPrecio: TextView =view.findViewById(R.id.txtPrecio)

    fun render(plato: Plato){
        txtPlato.text = plato.nombre
        txtPrecio.text = plato.precio.toString() + " €"
    }
}