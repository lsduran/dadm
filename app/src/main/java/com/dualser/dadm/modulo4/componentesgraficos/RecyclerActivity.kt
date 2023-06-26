package com.dualser.dadm.modulo4.componentesgraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        rvPeople.layoutManager = LinearLayoutManager(this)
    }
}