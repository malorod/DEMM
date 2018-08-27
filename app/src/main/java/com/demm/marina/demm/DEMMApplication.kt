package com.demm.marina.demm

import android.app.Application
import io.realm.Realm

class DEMMApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}
