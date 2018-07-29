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

    override fun delete(thing: Thing) {
        (map.get(thing.placement))?.remove(thing)
    }

}
