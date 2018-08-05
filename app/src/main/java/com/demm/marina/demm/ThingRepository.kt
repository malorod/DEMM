package com.demm.marina.demm

interface ThingRepository {
    fun save(thing: Thing)
    fun isEmpty(): Boolean
    fun contains(thing: Thing): Boolean?
    fun delete(thing: Thing)
    fun edit(thing: Thing, newThing: Thing)
    fun getByPlacement(placement: String): MutableList<Thing>?

}
