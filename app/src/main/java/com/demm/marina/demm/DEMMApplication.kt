package com.demm.marina.demm

import android.app.Application

class DEMMApplication : Application() {

    val repository: ThingRepository = MapThingRepository()
}