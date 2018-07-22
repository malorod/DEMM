package com.demm.marina.demm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById(R.id.search).setOnClickListener {

            val startSearchThings = Intent(this, SearchThings::class.java)
            startActivity(startSearchThings)
        }
    }
}
