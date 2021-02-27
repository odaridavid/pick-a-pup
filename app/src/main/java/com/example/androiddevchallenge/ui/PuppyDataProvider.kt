package com.example.androiddevchallenge.ui

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Puppy

object PuppyDataProvider {
    val puppies = mutableListOf(
        Puppy(
            name = "Musty",
            age = "1 year 5 months",
            breed = "Samoyed",
            weight = "4.5 kg",
            height = "50 cm",
            image = R.drawable.dog_1,
            isAdopted = true
        ),
        Puppy(
            name = "Roger",
            age = "7 months",
            breed = "Bulldog",
            weight = "2.4 kg",
            height = "72 cm",
            image = R.drawable.dog_2,
        ),
        Puppy(
            name = "Snoopy",
            age = "9 months",
            breed = "Husky",
            weight = "1.3 kg",
            height = "34 cm",
            image = R.drawable.dog_3,
        )
    )
}