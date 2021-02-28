/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
