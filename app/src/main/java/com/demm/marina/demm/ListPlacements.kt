package com.demm.marina.demm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class ListPlacements : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_placements)

        val thingRepository: ThingRepository = (application as DEMMApplication).repository
        val bundle = intent.extras
        val thing = bundle.getString("thing")

        val thingTextView = findViewById(R.id.thingSearch) as TextView
        thingTextView.text = getString(R.string.textListPlacement, thing)

        val listView : ListView = findViewById(R.id.listPlacement) as ListView
        val listPlacements = thingRepository.getAllPlacement(thing)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listPlacements)

        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->

            val selectedThing = parent.getItemAtPosition(position) as String
            val startListThings = Intent(this, ListThings::class.java)

            val thingBundle = Bundle()
            thingBundle.putString("name", thing)
            thingBundle.putString("placement", selectedThing)
            startListThings.putExtras(thingBundle)

            startActivity(startListThings)
            finish()

        }
    }
}
