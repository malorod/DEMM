package com.demm.marina.demm

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_things.*

class ListThings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_things)

        add.setOnClickListener {
            val starAddThings = Intent(this, AddThings::class.java)
            startActivity(starAddThings)
        }

        val thingRepository: ThingRepository = (application as DEMMApplication).repository

    }
}
