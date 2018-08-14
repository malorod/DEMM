package com.demm.marina.demm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_edit_things.*

class EditThings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_things)

        val thingBundle = intent.extras
        val name = thingBundle.getString("name").toString()
        val placement = thingBundle.getString("placement").toString()
        val oldThing = Thing(name, placement)

        thingNameText.text = getString(R.string.thingNameText, name)
        thingPlacementText.text = getString(R.string.thingPlacementText, placement)

        editButton.setOnClickListener {

            if (!(thingName.text.isNullOrEmpty())) {
                val newName = thingName.text.toString()

                val thingRepository: ThingRepository = (application as DEMMApplication).repository
                thingRepository.editName(oldThing, newName)

                finish()
            }
        }
    }
}
