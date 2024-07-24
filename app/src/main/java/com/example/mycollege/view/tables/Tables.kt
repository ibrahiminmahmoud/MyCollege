@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.mycollege.view.tables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
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
import com.example.mycollege.view.home.Drawer
import com.example.mycollege.view.home.TopBar


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tables(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"جداول") },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content = {paddingValues ->
            Box(modifier = Modifier.padding(paddingValues))
            LazyVerticalGrid(columns = GridCells.Adaptive(170.dp),
                content = {

            items(1) {
                com.example.mycollege.view.home.Box(
                    "امتحانات",
                    R.drawable.score,
                    "Tablesded_page",
                    navController,
                    60,
                    60
                )

            }
            items(1) {
                com.example.mycollege.view.home.Box(
                    "العملي",
                    R.drawable.code,
                    "Tablesded_page",
                    navController,
                    60,
                    60
                )
            }
            items(1) {
                com.example.mycollege.view.home.Box(
                    "المحاضرات",
                    R.drawable.lecture,
                    "Tablesded_page",
                    navController,
                    60,
                    60
                )
            }

        })
        }

    )

}
