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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.theme.AppTheme
import com.example.androiddevchallenge.theme.typography
import com.example.androiddevchallenge.ui.PuppyDataProvider
import com.example.androiddevchallenge.ui.PuppyDetailsScreen
import com.example.androiddevchallenge.ui.PuppyListScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                PickAPup()
            }
        }
    }
}

@Composable
fun PickAPup() {
    val navController = rememberNavController()
    SetUpRoutes(navController = navController)
}

@Composable
fun SetUpRoutes(navController: NavHostController) {
    NavHost(navController, startDestination = Destination.PUPPY_LIST.route) {
        composable(Destination.PUPPY_LIST.route) {
            Surface(color = MaterialTheme.colors.background) {
                Column {
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
                    PuppyListScreen(
                        puppies = PuppyDataProvider.puppies
                    ) { puppy ->
                        navController.currentBackStackEntry
                            ?.arguments?.putParcelable("puppy", puppy)
                        navController.navigate(Destination.PUPPY_DETAILS.route)
                    }
                }
            }
        }
        composable(Destination.PUPPY_DETAILS.route) {
            val puppy = navController.previousBackStackEntry
                ?.arguments?.getParcelable<Puppy>("puppy")
            PuppyDetailsScreen(puppy = puppy)
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    AppTheme {
        PickAPup()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    AppTheme(darkTheme = true) {
        PickAPup()
    }
}

enum class Destination(val route: String) {
    PUPPY_LIST("puppy_list"),
    PUPPY_DETAILS("puppy_details")
}