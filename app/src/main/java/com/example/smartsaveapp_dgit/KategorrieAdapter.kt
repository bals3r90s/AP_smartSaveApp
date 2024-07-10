package com.example.smartsaveapp_dgit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class KategorrieAdapter (context: Context, private val items: MutableList<String>) : ArrayAdapter<String>(context, 0, items) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
            val textView = view.findViewById<TextView>(android.R.id.text1)
            textView.text = items[position]
            return view
        }

        // Methode zum Hinzufügen neuer Elemente
        fun addItem(item: String) {
            items.add(item)
            notifyDataSetChanged()
        }
    }
