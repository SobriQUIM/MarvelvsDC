package actividades

import adapters.PersonajesAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import models.Personaje
import com.example.marvelvsdc.R
import actividades.PersonajeDetailActivity


class PersonajeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal)

        val ourCharacters = listOf(
            // Personajes de DC
            Personaje("", "Batman", 2),
            Personaje("https://www.gettyimages.com/photos/superman", "Superman", 2),
            Personaje("https://wallpapers.com/the-flash-movie-pictures", "Flash", 2),
            Personaje("https://www.pinterest.com/christinemae21/wonder-woman/", "Wonderwoman", 2),
            Personaje("https://www.imdb.com/title/tt7286456/?language=es-mx", "Joker", 2),

            // Personajes de Marvel
            Personaje("https://img2.rtve.es/i/?w=1600&i=1442912664626.jpg", "Spiderman", 2),
            Personaje("", "Iron Man", 2),
            Personaje("https://www.usmagazine.com/enespanol/entretenimiento/deadpool-3-todo-sobre-la-pelicula-de-ryan-reynolds/", "Deadpool", 2),
            Personaje("https://www.cinemascomics.com/lobezno/", "Wolverine", 2),
            Personaje("https://wallpapers.com/thanos-pictures", "Thanos", 2),


        )
        setupRecyclerView(findViewById(R.id.dc_characters_list), ourCharacters.filter { personaje ->
            personaje.PublisherId == 1
        })
        setupRecyclerView(findViewById(R.id.marvel_characters_list), ourCharacters.filter { personaje ->
            personaje.PublisherId == 2
        })
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, data: List<Personaje>) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.adapter = PersonajesAdapter(data) { personaje ->
            // Navegar a PersonajeDetailActivity con los datos del personaje
            val intent = Intent(this, PersonajeDetailActivity::class.java).apply {
                putExtra("heroName", personaje.name)
                putExtra("heroImageUrl", personaje.imageUrl)
                putExtra("heroPublisherId", personaje.PublisherId)
            }
            startActivity(intent)
        }
    }
}
