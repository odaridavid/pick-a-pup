package com.example.androiddevchallenge.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(
    val name: String,
    val age: String,
    val breed: String,
    val weight: String,
    val height: String,
    val about: String = "",
    @DrawableRes val image: Int = -1,
    val imageDescription: String = "",
    val isAdopted: Boolean = false
) : Parcelable