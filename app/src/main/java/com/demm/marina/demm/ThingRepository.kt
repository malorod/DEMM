package com.demm.marina.demm

interface ThingRepository {
    fun save(thing: Thing)
    fun isEmpty(): Boolean
    fun contains(thing: Thing): Boolean?
    fun getFirst(): Thing?
    fun getThingList(thing: Thing?): MutableList<Thing>?

}
