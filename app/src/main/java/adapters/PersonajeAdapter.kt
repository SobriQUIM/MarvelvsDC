package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import models.Personaje
import com.example.marvelvsdc.R
import com.squareup.picasso.Picasso

class PersonajesAdapter(
    private val personajeList: List<Personaje>,
    private val onItemClick: (Personaje) -> Unit
) : RecyclerView.Adapter<PersonajesAdapter.PersonajesViewHolder>() {

    class PersonajesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val personajeImage: ImageView = view.findViewById(R.id.personaje_image)
        val personajeName: TextView = view.findViewById(R.id.personaje_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listas_personajes, parent, false)
        return PersonajesViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonajesViewHolder, position: Int) {
        val personaje = personajeList[position]  // Accedemos correctamente a la lista
        holder.personajeName.text = personaje.name  // Asignamos el nombre correcto
        Picasso.get().load(personaje.imageUrl).into(holder.personajeImage)  // Cargamos la imagen del personaje

        // Configura el clic en cada personaje
        holder.itemView.setOnClickListener {
            onItemClick(personaje)  // Llama al callback con el personaje seleccionado
        }
    }

    override fun getItemCount(): Int = personajeList.size
}
