package com.example.hellokittyapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
@Parcelize
data class Animal(val name: String, val description: String, val imageID: Int) : Parcelable