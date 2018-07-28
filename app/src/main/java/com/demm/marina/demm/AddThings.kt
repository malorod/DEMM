package com.demm.marina.demm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_add_things.*


class AddThings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_things)

        addThing.setOnClickListener {

            if (thingName.text != null && thingPlacement.text != null){
                val name = thingName.text.toString()
                val placement = thingPlacement.text.toString()
                val thing = Thing(name, placement)

                val thingRepository: ThingRepository? = null
                thingRepository?.save(thing)
            }
        }
    }
}
