package com.demm.marina.demm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_add_things.*


class AddThings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_things)

        addThing.setOnClickListener {

            if (!(thingName.text.isNullOrEmpty()) && !(thingPlacement.text.isNullOrEmpty())) {
                val name = thingName.text.toString()
                val placement = thingPlacement.text.toString()
                val thingToAdd = Thing(name, placement)

                val thingRepository = RealmThingRepository()
                thingRepository.save(thingToAdd)

                val startListThings = Intent(this, ListThings::class.java)

                startListThings.putExtra("thing", thingToAdd)

                startActivity(startListThings)
            }
        }
    }
}
