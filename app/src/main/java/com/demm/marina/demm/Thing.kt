package com.demm.marina.demm

import android.os.Parcel
import android.os.Parcelable

class Thing(val name: String, val placement: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(placement)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Thing> {
        override fun createFromParcel(parcel: Parcel): Thing {
            return Thing(parcel)
        }

        override fun newArray(size: Int): Array<Thing?> {
            return arrayOfNulls(size)
        }
    }

}
