package com.demm.marina.demm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_list_things.*

class ListThings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_things)

        add.setOnClickListener {
            val startAddThings = Intent(this, AddThings::class.java)
            startActivity(startAddThings)
        }

        val thingRepository: ThingRepository = (application as DEMMApplication).repository

        val bundle = intent.extras
        val thingInfo = bundle.getParcelable<Thing>("thing")

        thingPlacement.text = thingInfo.placement

        val adapter = ThingAdapter(this, thingRepository, thingInfo)
        val things = findViewById(R.id.thingList) as ListView
        things.adapter = adapter
    }
}
