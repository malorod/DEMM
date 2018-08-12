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
            val startAddThings = Intent(this, AddThings::class.java)
            startActivity(startAddThings)
            finish()
        }

        val thingRepository: ThingRepository = (application as DEMMApplication).repository

        val bundle = intent.extras
        val name = bundle.getString("name")
        val placement = bundle.getString("placement")

        val thing = Thing(name, placement)

        thingPlacement.text = placement

        val listView :ListView = findViewById(R.id.thingList) as ListView

        val thingList = thingRepository.getThingList(thing)

        val adapter = ThingAdapter(this, thingList!!)
        listView.adapter = adapter
    }
}
