package com.demm.marina.demm

interface ThingRepository {
    fun save(thing: Thing)
    fun isEmpty(): Boolean
    fun contains(thing: Thing): Boolean
    fun getFirst(): Thing
    fun getThingList(thing: Thing): MutableList<Thing>
    fun getAllPlacement(thingName: String): MutableList<String>
    fun delete(thing: Thing)
    fun update(oldThing: Thing, newThing: Thing)
    fun getAllPlacements(): MutableList<String>
}
