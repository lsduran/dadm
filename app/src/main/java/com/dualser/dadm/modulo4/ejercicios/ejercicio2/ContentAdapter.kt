package com.dualser.dadm.modulo4.ejercicios.ejercicio2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dualser.dadm.R
import com.dualser.dadm.modulo4.componentesgraficos.PersonViewHolder

class ContentAdapter(private var contentList : List<Content>) : RecyclerView.Adapter<ContentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false))
    }

    override fun getItemCount(): Int = contentList.size

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.render(contentList[position])
    }

}

class ContentViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val tvName = view.findViewById<TextView>(R.id.tvName)
    val tvType = view.findViewById<TextView>(R.id.tvType)
    val tvPlatforms = view.findViewById<TextView>(R.id.tvPlatforms)
    val tvCategory = view.findViewById<TextView>(R.id.tvCategory)

    fun render(content: Content) {
        tvName.text = content.Name
        tvType.text = content.Type
        tvPlatforms.text = content.Platforms.joinToString(", ")
        tvCategory.text = content.Category
    }

}
