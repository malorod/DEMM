package com.demm.marina.demm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_edit_things.*

class EditThings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_things)

        val thingBundle = intent.extras
        val name = thingBundle.getString("name").toString()
        val placement = thingBundle.getString("placement").toString()

        thingNameText.text = getString(R.string.thinNameText, name)
        thingPlacementText.text = getString(R.string.thingPlacementText, placement)
    }
}
