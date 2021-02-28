package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Circle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.Destination
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.theme.green300
import com.example.androiddevchallenge.theme.grey700
import com.example.androiddevchallenge.theme.typography
import com.example.androiddevchallenge.theme.white

@Composable
fun PuppyDetailsScreen(
    navHostController: NavHostController,
    puppy: Puppy?,
    onPuppyAdopted: (Puppy) -> Unit
) {
    Box {
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
                    Text(
                        text = name,
                        style = typography.h4,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, top = 16.dp),
                    )
                    Text(
                        text = breed,
                        style = typography.subtitle1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp),
                        color = grey700
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Weight",
                                style = typography.caption,
                                textAlign = TextAlign.Center,
                                color = grey700
                            )
                            Text(
                                text = weight,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                        HorizontalDivider()
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Height",
                                style = typography.caption,
                                textAlign = TextAlign.Center,
                                color = grey700
                            )
                            Text(
                                text = height,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                        HorizontalDivider()
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Age",
                                style = typography.caption,
                                textAlign = TextAlign.Center,
                                color = grey700
                            )
                            Text(
                                text = age,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp)
                            )
                        }

                    }
                    Text(
                        text = "About",
                        style = typography.h5,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp),
                        color = grey700
                    )
                    if (about.isNotBlank())
                        Text(
                            text = about, modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp)
                        )
                    else
                        Text(
                            text = "No info on this doggo yet",
                            style = typography.caption,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                    if (!isAdopted) {
                        Button(
                            onClick = {
                                // TODO Scoping gets tricky with large composable views,make it more explicit
                                onPuppyAdopted(this)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            colors = ButtonDefaults.textButtonColors(
                                backgroundColor = green300,
                            )
                        ) {
                            Text(text = "Adopt", color = white)
                        }
                    }
                }
            }
        }
        Icon(
            imageVector = Icons.Filled.Circle,
            contentDescription = "navigate back icon",
            modifier = Modifier
                .padding(8.dp)
                .width(32.dp)
                .height(32.dp)
                .clickable {
                    // Do Nothing
                },
            tint = MaterialTheme.colors.surface
        )
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "navigate back icon",
            modifier = Modifier
                .padding(12.dp)
                .width(24.dp)
                .height(24.dp)
                .clickable {
                    navHostController.navigate(Destination.PUPPY_LIST.route)
                },
            tint = MaterialTheme.colors.onSurface
        )
    }
}