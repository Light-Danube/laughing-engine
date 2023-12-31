package com.example.hellokittyapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Animal(val name: String, val description: String, val imageID: Int) : Parcelable