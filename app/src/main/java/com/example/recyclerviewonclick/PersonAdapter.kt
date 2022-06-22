package com.example.recyclerviewonclick

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(
    var context: Context,
    var personList: MutableList<PersonModel>,
    var onClick: OnItemClick
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.custom_view, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.pName.text = personList[position].name
        holder.pAddr.text = personList[position].address

        holder.itemView.setOnClickListener({

            onClick.onItemClick(position)
            Toast.makeText(context, "item clicked", Toast.LENGTH_LONG).show()
        })

    }

    override fun getItemCount(): Int {
        return personList.size
    }

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var pName = itemView.findViewById<TextView>(R.id.txt_name)
        var pAddr = itemView.findViewById<TextView>(R.id.txt_name)
    }

    interface OnItemClick {
        fun onItemClick(position: Int)
    }

}

