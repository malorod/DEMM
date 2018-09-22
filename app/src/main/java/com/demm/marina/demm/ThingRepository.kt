package com.demm.marina.demm

interface ThingRepository {
    fun save(thing: Thing)
    fun getThingList(thing: Thing): MutableList<Thing>
    fun getAllPlacementsOfOneThing(thingName: String): MutableList<String>
    fun getAllPlacements(): MutableList<String>
    fun delete(thing: Thing)
    fun update(oldThing: Thing, newThing: Thing)
}
