package com.demm.marina.demm

interface ThingRepository {
    fun save(thing: Thing)
    fun getThingList(thing: Thing): MutableList<Thing>
    fun getAllPlacement(thingName: String): MutableList<String>
    fun delete(thing: Thing)
    fun update(oldThing: Thing, newThing: Thing)
}
