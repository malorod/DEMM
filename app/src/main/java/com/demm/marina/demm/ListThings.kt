package com.demm.marina.demm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_list_things.*

class ListThings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_things)

        add.setOnClickListener {
            val starAddThings = Intent(this, AddThings::class.java)
            startActivity(starAddThings)
            finish()
        }

        val thingRepository: ThingRepository = (application as DEMMApplication).repository

        thingPlacement.text = thingRepository.getFirst()?.placement

        val listView :ListView = findViewById(R.id.thingList) as ListView

        val thingList = thingRepository.getThingList(thingRepository.getFirst())

        val listThings = arrayOfNulls<String>(thingList!!.size)

        for (i in 0 until thingList.size){
            val thing = thingList[i]
            listThings[i] = thing.name
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listThings)

        listView.adapter = adapter
    }
}
