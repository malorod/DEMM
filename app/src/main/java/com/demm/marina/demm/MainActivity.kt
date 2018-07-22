package com.demm.marina.demm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener{

            val starAddThings = Intent (this, AddThings::class.java)
            startActivity(starAddThings)
        }

        search.setOnClickListener {

            val startSearchThings = Intent(this, SearchThings::class.java)
            startActivity(startSearchThings)
        }
    }
}
