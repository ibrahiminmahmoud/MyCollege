@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.mycollege.view

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


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tables(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState) },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content = {    LazyVerticalGrid(cells = GridCells.Adaptive(150.dp), content = {

            items(1) {
                Box("جدول امتحانات",
                    R.drawable.ic_outline_quiz_24,
                    "about_page",
                    navController
                )

            }
            items(1) {
                Box("جدول المحاضرات",
                    R.drawable.ic_baseline_table_view_24,
                    "about_page",
                    navController)

            }
            items(1) {
                Box("جدول العملي",
                    R.drawable.ic_baseline_code_24,
                    "about_page",
                    navController)
            }

        })
        }

    )

}
