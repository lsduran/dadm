package com.dualser.dadm.modulo4.componentesgraficos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.RecyclerView
import com.dualser.dadm.R

class PersonAdapter(private var list: List<Person>) : RecyclerView.Adapter<PersonViewHolder>() {

    var onItemSelected : ((Person) -> Unit)? = null // Unit es un valor default que se utiliza cuando el valor puede ser nulo para evitar errores
    // Unit permite que si el método no se implementa, no mande error

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.render(list[position], onItemSelected)
    }

}

class PersonViewHolder(view: View) :RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.tvName)
    val root = view.findViewById<ConstraintLayout>(R.id.layoutPerson)

    fun render(person: Person, onItemSelected: ((Person) -> Unit)?) {
        tvName.text = person.name
        root.setOnClickListener {
            onItemSelected?.invoke(person)
        }
    }
}
