package com.demm.marina.demm

class MapThingRepository : ThingRepository {
    var map = mutableMapOf<String, MutableList<Thing>>()

    override fun save(thing: Thing) {
        if (map.containsKey(thing.placement)) {
            val thingsList = map.get(thing.placement)
            thingsList!!.add(thing)
        } else {
            map.put(thing.placement, mutableListOf<Thing>(thing))
        }
    }

    override fun isEmpty(): Boolean {
        return map.isEmpty()
    }

    override fun contains(thing: Thing): Boolean? {
        return map.get(thing.placement)?.contains(thing)
    }

    override fun getFirst(): Thing? {
        val firstKey = map.keys.first()
        return map.get(firstKey)?.get(0)
    }

    override fun getThingList(thing: Thing?): MutableList<Thing>? {
        return map.get(thing?.placement)
    }

    override fun getAllPlacement(thingName: String): MutableList<String> {

        val keys = map.keys
        val placements = mutableListOf<String>()

        for (i in 0 until keys.size){

            val listThings = map.get(keys.elementAt(i))

            for (j in 0 until listThings!!.size){

                if (listThings[j].name == thingName){
                    placements.add(listThings[j].placement)
                }
            }
        }
        return placements
    }
}
