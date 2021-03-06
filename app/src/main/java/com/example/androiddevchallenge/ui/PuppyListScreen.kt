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

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.theme.green300
import com.example.androiddevchallenge.theme.red300
import com.example.androiddevchallenge.theme.typography

@Composable
fun PuppyListScreen(onPuppyClicked: (Puppy) -> Unit) {
    Column {
        PuppyListScreenHeader()
        PuppyList(puppies = PuppyDataProvider.puppies) { puppy ->
            onPuppyClicked(puppy)
        }
    }
}

// region Private Api

@Composable
private fun PuppyListScreenHeader() {
    Text(
        text = "Pick A Pup",
        style = typography.h4,
        fontFamily = FontFamily(
            fonts = listOf(
                Font(R.font.akaya_telivigala_regular)
            )
        ),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    )
}

@Composable
private fun PuppyList(puppies: List<Puppy>, onClick: (Puppy) -> Unit) {
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

// endregion
