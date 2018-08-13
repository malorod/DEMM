package com.demm.marina.demm

class MapThingRepository : ThingRepository {
    var map = mutableMapOf<String, MutableList<Thing>>()

    override fun save(thing: Thing) {
        if (this.map.containsKey(thing.placement)) {
            val thingsList = map.get(thing.placement)
            thingsList!!.add(thing)
        } else {
            this.map.put(thing.placement, mutableListOf<Thing>(thing))
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

        val keys = map.values
        val placements = mutableListOf<String>()

        keys.forEach { thingsList ->
            thingsList.forEach {
                if ((it.name == thingName) && !(placements.contains(it.placement)))
                    placements.add(it.placement)
            }
        }

        return placements
    }

    override fun delete(thing: Thing) {
        val listThings = map[thing.placement]
        val thingsToDelete= mutableListOf<Thing>()

        listThings!!.forEach {
            if (it.name == thing.name)
                thingsToDelete.add(it)
        }

        thingsToDelete.forEach {
            listThings.remove(it)
        }
    }
}
