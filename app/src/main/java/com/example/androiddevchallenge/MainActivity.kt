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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.theme.AppTheme
import com.example.androiddevchallenge.ui.PuppyDetailsScreen
import com.example.androiddevchallenge.ui.PuppyListScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                InitPickAPup()
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    AppTheme {
        InitPickAPup()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    AppTheme(darkTheme = true) {
        InitPickAPup()
    }
}

@Composable
private fun InitPickAPup() {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.background) {
        SetUpRoutes(navHostController = navController)
    }
}

@Composable
private fun SetUpRoutes(navHostController: NavHostController) {
    NavHost(navHostController, startDestination = Destination.PUPPY_LIST.route) {
        composable(Destination.PUPPY_LIST.route) {
            PuppyListScreen { puppy ->
                navigateToPuppyDetails(navController = navHostController, puppy = puppy)
            }
        }
        composable(Destination.PUPPY_DETAILS.route) {
            val puppy = navHostController.previousBackStackEntry
                ?.arguments?.getParcelable<Puppy>(PUPPY_PARCELABLE_KEY)
            PuppyDetailsScreen(navHostController = navHostController, puppy = puppy) { adoptedPuppy ->
                // TODO Something with adopted puppy -> Look into side effects
            }
        }
    }
}

enum class Destination(val route: String) {
    PUPPY_LIST("puppy_list"),
    PUPPY_DETAILS("puppy_details")
}

private fun navigateToPuppyDetails(
    navController: NavHostController,
    puppy: Puppy
) {
    navController.currentBackStackEntry
        ?.arguments?.putParcelable(PUPPY_PARCELABLE_KEY, puppy)
    navController.navigate(Destination.PUPPY_DETAILS.route)
}

private const val PUPPY_PARCELABLE_KEY = "puppy"
