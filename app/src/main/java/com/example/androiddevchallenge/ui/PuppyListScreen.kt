package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.theme.green300
import com.example.androiddevchallenge.theme.red300
import com.example.androiddevchallenge.theme.typography

@Composable
fun PuppyListScreen(puppies: List<Puppy>, onClick: (Puppy) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {

        items(puppies) { puppy ->
            Card(
                elevation = 0.dp,
                modifier = Modifier.clickable {
                    onClick(puppy)
                }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = puppy.image),
                        modifier = Modifier
                            .height(48.dp)
                            .width(48.dp)
                            .clip(shape = RoundedCornerShape(size = 24.dp)),
                        contentDescription = puppy.imageDescription,
                        contentScale = ContentScale.Crop
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = puppy.name)
                        if (!puppy.isAdopted) {
                            Text(
                                text = "Available",
                                style = typography.caption,
                                color = green300
                            )
                        } else {
                            Text(
                                text = "Adopted",
                                style = typography.caption,
                                color = red300
                            )
                        }
                    }
                }
            }
            Divider()
        }
    }
}