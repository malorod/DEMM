package com.demm.marina.demm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_edit_things.*

class EditThings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_things)

        val thingBundle = intent.extras
        val oldThing = thingBundle.getParcelable<Thing>("thing")

        thingNameText.text = getString(R.string.thingNameText, oldThing.name)
        thingPlacementText.text = getString(R.string.thingPlacementText, oldThing.placement)

        editButton.setOnClickListener {

            if (!(thingName.text.isNullOrEmpty())) {
                val newName = thingName.text.toString()

                val thingRepository: ThingRepository = (application as DEMMApplication).repository
                thingRepository.editName(oldThing, newName)

            }

            val startListThings = Intent(this, ListThings::class.java)
            startListThings.putExtra("thing", oldThing)

            startActivity(startListThings)
        }
    }
}
