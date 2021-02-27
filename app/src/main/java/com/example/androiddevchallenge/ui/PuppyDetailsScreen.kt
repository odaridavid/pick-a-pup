package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.models.Puppy

@Composable
fun PuppyDetailsScreen(puppy: Puppy?, onPuppyAdopted: (Puppy) -> Unit) {
    puppy?.run {
        Column {
            with(puppy) {
                Image(
                    painter = painterResource(id = image),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentDescription = imageDescription,
                    contentScale = ContentScale.FillWidth
                )
                Text(text = name)
                if (about.isNotBlank())
                    Text(text = about)
                Text(text = breed)
                Text(text = weight)
                Text(text = height)
                Text(text = age)
                if (!isAdopted) {
                    Button(
                        onClick = { onPuppyAdopted(this) }
                    ) {
                        Text(text = "Adopt")
                    }
                }
            }
        }
    }

}