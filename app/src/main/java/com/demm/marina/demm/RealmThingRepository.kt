package com.demm.marina.demm

import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where

class RealmThingRepository : ThingRepository {

    override fun save(thing: Thing) {

        val realm = Realm.getDefaultInstance()

        realm.executeTransaction {
            val thingToSafe = realm.createObject<RealmThing>()
            thingToSafe.name = thing.name
            thingToSafe.placement = thing.placement
        }
        realm.close()
    }

    override fun getThingList(thing: Thing): MutableList<Thing> {

        val realm = Realm.getDefaultInstance()

        val listRealmThings = realm.where<RealmThing>().equalTo("placement", thing.placement).findAll()
        val thingsList = mutableListOf<Thing>()

        listRealmThings.forEach {
            thingsList.add(Thing(it.name!!, it.placement!!))
        }

        realm.close()

        return thingsList
    }

    override fun getAllPlacementsOfOneThing(thingName: String): MutableList<String> {

        val realm = Realm.getDefaultInstance()

        val thingsList = realm.where<RealmThing>().equalTo("name", thingName).findAll()
        val placementsList = mutableListOf<String>()

        thingsList.forEach {
            placementsList.add(it.placement!!)
        }

        realm.close()

        return placementsList
    }

    override fun delete(thing: Thing) {

        val realm = Realm.getDefaultInstance()

        realm.executeTransaction {
            realm.where<RealmThing>().equalTo("name", thing.name).and().equalTo("placement", thing.placement).findFirst()!!.deleteFromRealm()
        }
        realm.close()
    }

    override fun update(oldThing: Thing, newThing: Thing) {

        val realm = Realm.getDefaultInstance()

        realm.executeTransaction {
            val thingToDelete = realm.where<RealmThing>().equalTo("name", oldThing.name).and().equalTo("placement", oldThing.placement).findFirst()
            thingToDelete!!.name = newThing.name
            thingToDelete.placement = newThing.placement
        }
        realm.close()
    }
}
