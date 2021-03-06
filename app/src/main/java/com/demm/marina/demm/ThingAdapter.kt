package com.demm.marina.demm

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class ThingAdapter(private val context: Context, private val thingRepository: ThingRepository, val thing: Thing) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return thingRepository.getThingList(thing).size
    }

    override fun getItem(position: Int): Any {
        return thingRepository.getThingList(thing)[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.list_item_thing, parent, false)
        val thing = getItem(position) as Thing

        val titleTextView = rowView.findViewById(R.id.thingName) as TextView
        titleTextView.text = thing.name

        val deleteButton = rowView.findViewById(R.id.deleteButton)
        deleteButton.setOnClickListener {
            thingRepository.delete(thing)
            notifyDataSetChanged()
        }

        val editButton = rowView.findViewById(R.id.editButton)
        editButton.setOnClickListener {
            val startEditThing = Intent(context, EditThings::class.java)

            startEditThing.putExtra("thingToUpdate", getItem(position) as Thing)

            context.startActivity(startEditThing)
        }

        return rowView
    }
}
