@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.mycollege.view.tables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
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
fun Tables(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"جداول") },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content = {
            LazyVerticalGrid(cells = GridCells.Adaptive(150.dp), content = {

            items(1) {
                com.example.mycollege.view.Box(
                    "امتحانات",
                    R.drawable.score,
                    "Tablesded_page",
                    navController
                )

            }
            items(1) {
                com.example.mycollege.view.Box(
                    "العملي",
                    R.drawable.code,
                    "Tablesded_page",
                    navController
                )
            }
            items(1) {
                com.example.mycollege.view.Box(
                    "المحاضرات",
                    R.drawable.lecture,
                    "Tablesded_page",
                    navController
                )
            }

        })
        }

    )

}
