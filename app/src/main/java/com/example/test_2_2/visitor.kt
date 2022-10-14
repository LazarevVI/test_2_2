package com.example.test_2_2

import android.os.Parcel
import android.os.Parcelable

class visitor(var visitor_name: String?, var email: String?, var age:Int, var arrival_time: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(visitor_name)
        parcel.writeString(email)
        parcel.writeInt(age)
        parcel.writeString(arrival_time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<visitor> {
        override fun createFromParcel(parcel: Parcel): visitor {
            return visitor(parcel)
        }

        override fun newArray(size: Int): Array<visitor?> {
            return arrayOfNulls(size)
        }
    }

}