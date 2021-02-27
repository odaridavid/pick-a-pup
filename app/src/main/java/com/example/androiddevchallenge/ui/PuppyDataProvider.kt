package com.example.androiddevchallenge.ui

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Puppy

object PuppyDataProvider {
    val puppies = mutableListOf(
        Puppy(
            name = "Musty",
            ageInMonths = 17,
            breed = "Samoyed",
            weight = "4.5 kg",
            height = "50 cm",
            image = R.drawable.dog_1,
            isAdopted = true
        ),
        Puppy(
            name = "Roger",
            ageInMonths = 7,
            breed = "Bulldog",
            weight = "2.4 kg",
            height = "72 cm",
            image = R.drawable.dog_2,
        ),
        Puppy(
            name = "Snoopy",
            ageInMonths = 9,
            breed = "Husky",
            weight = "1.3 kg",
            height = "34 cm",
            image = R.drawable.dog_3,
        )
    )
}