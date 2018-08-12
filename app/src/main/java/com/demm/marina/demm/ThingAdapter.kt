package com.demm.marina.demm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ThingAdapter(private val context: Context, private val thingsList: MutableList<Thing>): BaseAdapter(){

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return thingsList.size
    }

    override fun getItem(position: Int): Any {
        return thingsList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.list_item_thing, parent, false)
        val titleTextView = rowView.findViewById(R.id.thingName) as TextView
        val thing = getItem(position) as Thing
        titleTextView.text = thing.name
        return rowView
    }
}
