package com.example.mycollege.view.post

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.view.Drawer
import com.example.mycollege.view.TopBar

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
        content = {

            LazyVerticalGrid(cells = GridCells.Adaptive(130.dp)) {
                items(1) {
                    com.example.mycollege.view.Box(
                        "عام ",
                        R.drawable.advertising,
                        "post1_page",
                        navController
                    )
                }
                items(1) {
                    com.example.mycollege.view.Box(
                        "خاص",
                        R.drawable.advertising,
                        "post2_page",
                        navController
                    )
                }
            }

        }

    )
}