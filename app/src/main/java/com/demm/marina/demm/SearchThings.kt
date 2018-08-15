package com.demm.marina.demm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_object_search.*

class SearchThings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_search)

        searchThing.setOnClickListener{

            if (!(thingName.text.isNullOrEmpty())){
                val listPlacements = Intent(this, ListPlacements::class.java)

                val thing = Bundle()
                thing.putString("thingToSearch", thingName.text.toString())
                listPlacements.putExtras(thing)

                startActivity(listPlacements)
            }
        }
    }
}
