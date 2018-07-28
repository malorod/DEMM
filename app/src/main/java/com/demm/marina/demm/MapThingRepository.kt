package com.demm.marina.demm

class MapThingRepository : ThingRepository {

    var map = mutableMapOf<String, MutableList<String>>()

    override fun save(thing: Thing) {

    }


}