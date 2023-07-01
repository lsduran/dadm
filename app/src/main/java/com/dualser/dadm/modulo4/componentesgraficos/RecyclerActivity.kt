package com.dualser.dadm.modulo4.componentesgraficos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dualser.dadm.R

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val rvPeople = findViewById<RecyclerView>(R.id.rvPeopleList)
        val personAdapter = PersonAdapter(arrayListOf(
            Person("1", "Juan"),
            Person("2", "Jose"),
            Person("3", "Luis"),
            Person("4", "Maria"),
            Person("5", "Juan2"),
            Person("6", "Juan3"),
            Person("7", "Juan4"),
            Person("8", "Juan"),
            Person("9", "Jose"),
            Person("10", "Luis"),
            Person("11", "Maria"),
            Person("12", "Juan2"),
            Person("13", "Juan3"),
            Person("14", "Juan4"),
        ))

        rvPeople.adapter = personAdapter
        personAdapter.onItemSelected = {person ->
            Toast.makeText(this, "${person.name}", Toast.LENGTH_SHORT).show()
            val intent = Intent().apply {
                intent.putExtra("EXTRA_PERSON", person)
            }
            // Para recuperar el objeto en la siguiente activity se utiliza getSerializableExtra
            // intent.getSerializableExtra("EXTRA_PERSON") as Person
            // intent.getSerializableExtra("EXTRA_PERSON", Person::class.java) // A partir de la versión 33 de SDK
            /*
            vsl person = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra("EXTRA_PERSON", Person::class.java)
            } else {
                intent.getSerializableExtra("EXTRA_PERSON") as Person
            }
            something.text = person?.name
             */
        }
        rvPeople.layoutManager = LinearLayoutManager(this)
    }
}