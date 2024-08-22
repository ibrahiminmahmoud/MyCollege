package com.example.mycollege.view.post

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.view.home.Box
import com.example.mycollege.view.home.Drawer
import com.example.mycollege.view.home.TopBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Poster(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"الاعلانات") },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content = {paddingValues ->
            androidx.compose.foundation.layout.Box(modifier = Modifier.padding(paddingValues))

            LazyVerticalGrid(columns = GridCells.Adaptive(170.dp)) {
                items(1) {
                    Box(
                        "عام ",
                        R.drawable.post1,
                        "post1_page",
                        navController,
                        60,
                        60
                    )
                }
                items(1) {
                    Box(
                        "خاص",
                        R.drawable.post1,
                        "post2_page",
                        navController,
                        60,
                        60
                    )
                }
            }

        }

    )
}