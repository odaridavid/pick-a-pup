package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.models.Puppy

@Composable
fun PuppyDetailsScreen(puppy: Puppy?) {
    puppy?.run {
        Column {
            with(this@run) {
                Text(text = name)
                Text(text = about)
                Text(text = breed)
                Text(text = weight)
                Text(text = height)
            }
        }
    }

}