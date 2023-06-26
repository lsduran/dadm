package com.dualser.dadm.modulo4.componentesgraficos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dualser.dadm.R

class PersonAdapter(private var list: List<Person>) : RecyclerView.Adapter<PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.render(list[position])
    }

}

class PersonViewHolder(view: View) :RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.tvName)

    fun render(person: Person) {
        tvName.text = person.name
    }
}
