package com.demm.marina.demm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_things.*

class ListThings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_things)

        add.setOnClickListener {
            val starAddThings = Intent(this, AddThings::class.java)
            startActivity(starAddThings)
        }

        /*val thingRepository: ThingRepository = (application as DEMMApplication).repository

        var listView = thingList

        var placement="Estante"

        val thingList: MutableList<Thing> = thingRepository.getByPlacement(placement)!!

        val listItems = arrayOfNulls<String>(thingList.size)

        for (i in 0 until thingList.size) {
            val thing = thingList.get(i)
            listItems[i] = thing.name
        }

        val adapter = ArrayAdapter(this, android.R.layout.activity_list_item, listItems)
        listView.adapter = adapter*/

        /*val adapter = ThingAdapter(this, thingRepository)
        listView.adapter = adapter*/
    }
}
