package com.example.smartsaveapp_dgit


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListItemAdapter(private val context: Context, private val dataSource: List<ItemData>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = convertView ?: inflater.inflate(R.layout.list_item_main, parent, false)

        val textView = rowView.findViewById<TextView>(R.id.textView)
        val textView1 = rowView.findViewById<TextView>(R.id.textView1)
        val imageView = rowView.findViewById<ImageView>(R.id.imageView2)

        val item = getItem(position) as ItemData

        textView.text = item.mainText
        textView1.text = item.percentageText
        imageView.setImageResource(item.imageResId)

        return rowView
    }
}
