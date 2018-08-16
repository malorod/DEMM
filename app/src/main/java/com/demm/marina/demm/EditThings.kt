package com.demm.marina.demm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_edit_things.*

class EditThings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_things)

        val thingBundle = intent.extras
        val oldThing = thingBundle.getParcelable<Thing>("thing")

        thingName.setText(oldThing.name, TextView.BufferType.EDITABLE)
        thingPlacement.setText(oldThing.placement, TextView.BufferType.EDITABLE)

        editButton.setOnClickListener {

            val thingRepository: ThingRepository = (application as DEMMApplication).repository

            val newName = thingName.text.toString()
            val newPlacement = thingPlacement.text.toString()

            thingRepository.editName(oldThing, Thing(newName, newPlacement))

            val startListThings = Intent(this, ListThings::class.java)
            startListThings.putExtra("thing", oldThing)
            startActivity(startListThings)
        }
    }
}
