package com.example.trueweather.data.remote.model

import android.os.Parcel
import android.os.Parcelable

data class ThroneHero(
    val id: Int,
    val firstName: String?,
    val lastName: String?,
    val fullName: String?,
    val title: String?,
    val family: String?,
    val image: String?,
    val imgURL: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(fullName)
        parcel.writeString(title)
        parcel.writeString(family)
        parcel.writeString(image)
        parcel.writeString(imgURL)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ThroneHero> {
        override fun createFromParcel(parcel: Parcel): ThroneHero {
            return ThroneHero(parcel)
        }

        override fun newArray(size: Int): Array<ThroneHero?> {
            return arrayOfNulls(size)
        }
    }

    val fullImgURL: String?
        get() = if (!image.isNullOrBlank()) {
            "https://thronesapi.com/assets/images/$image"
        } else {
            null
        }
}
