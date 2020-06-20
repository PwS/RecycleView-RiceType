package com.example.ricetype

import android.os.Parcel
import android.os.Parcelable

//POKO

data class Rice(
    var name: String? = "",
    var detail: String? = "",
    var photo: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(detail)
        parcel.writeValue(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Rice> {
        override fun createFromParcel(parcel: Parcel): Rice {
            return Rice(parcel)
        }

        override fun newArray(size: Int): Array<Rice?> {
            return arrayOfNulls(size)
        }
    }
}
