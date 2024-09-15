package actividades

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.example.marvelvsdc.R

class PersonajeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listas_personajes_activity)

        // Obtener los datos del héroe desde el Intent
        val personajeName = intent.getStringExtra("personajeName")
        val personajeImageUrl = intent.getStringExtra("personajeImageUrl")
        val personajePublisherId = intent.getIntExtra("personajePublisherId", -1)

        // Mostrar los datos en la vista
        val personajeNameTextView = findViewById<TextView>(R.id.personajeDetailName)
        val personajePublisherTextView = findViewById<TextView>(R.id.personajeDetailPublisher)
        val personajeImageView = findViewById<ImageView>(R.id.personajeDetailImage)

        personajeNameTextView.text = personajeName

        // Cargar la imagen usando Picasso
        Picasso.get().load(personajeImageUrl).into(personajeImageView)

        // Configurar el botón de "Volver"
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()  // Cierra esta actividad y vuelve a la anterior
        }
    }
}

