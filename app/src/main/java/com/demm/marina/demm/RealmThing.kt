package com.demm.marina.demm

import io.realm.RealmObject

open class RealmThing : RealmObject() {

    var name: String? = ""
    var placement: String? = ""
}
