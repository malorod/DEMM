package com.demm.marina.demm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
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
        val thing = getItem(position) as Thing

        val view: View
        val holder: ViewHolder

        if (convertView == null){

            view = inflater.inflate(R.layout.list_item_thing, parent, false)

            holder = ViewHolder()
            holder.thingName = view.findViewById(R.id.thingName) as TextView
            holder.editButton = view.findViewById(R.id.editButton) as Button
            holder.deleteButton = view.findViewById(R.id.deleteButton) as Button

            view.tag = holder
        }else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val thingName = holder.thingName

        thingName.text = thing.name

        return view
    }

    private class ViewHolder {
        lateinit var thingName: TextView
        lateinit var editButton: Button
        lateinit var deleteButton: Button
    }
}
