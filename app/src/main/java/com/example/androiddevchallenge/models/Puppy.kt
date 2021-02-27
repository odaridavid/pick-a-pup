package com.example.androiddevchallenge.models

import androidx.annotation.DrawableRes

data class Puppy(
    val name: String,
    val ageInMonths: Int,
    val breed: String,
    val weight: String,
    val height: String,
    val about: String = "",
    @DrawableRes val image: Int = -1,
    val imageDescription: String = "",
    val isAdopted: Boolean = false,
    val moreImages: List<Int> = listOf()
)