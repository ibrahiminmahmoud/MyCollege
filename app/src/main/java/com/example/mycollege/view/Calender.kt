package com.example.mycollege.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycollege.R
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun calender(navController: NavController) {
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
                Box(
                    modifier = Modifier
                        .padding(15.dp)
                        .background(color = Color(0xFFededed), shape = RoundedCornerShape(15.dp))
                        .aspectRatio(1f),


                    contentAlignment = Alignment.BottomCenter
                ) {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_insert_invitation_24),
                            contentDescription = "test",
                            modifier = Modifier
                                .height(180.dp)
                                .width(150.dp),
                            tint =  Color(0xFF806D7E)
                        )
                    }

                    Text(text = "جدول امتحانات ")


                }
            }
            items(1) {
                Box(
                    modifier = Modifier
                        .padding(15.dp)
                        .background(color = Color(0xFFededed), shape = RoundedCornerShape(15.dp))
                        .aspectRatio(1f),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_insert_invitation_24),
                            contentDescription = "test",
                            modifier = Modifier
                                .height(180.dp)
                                .width(150.dp),
                            tint =  Color(0xFF806D7E)
                        )
                    }
                    Spacer(modifier = Modifier.padding(15.dp))

                    Text(text = "جدول المحاضرات")


                }
            }
            items(1) {
                Box(
                    modifier = Modifier
                        .padding(15.dp)
                        .background(color = Color(0xFFededed), shape = RoundedCornerShape(15.dp))
                        .aspectRatio(1f),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_insert_invitation_24),
                            contentDescription = "test",
                            modifier = Modifier
                                .height(180.dp)
                                .width(150.dp),
                            tint =  Color(0xFF806D7E)
                        )
                    }
                    Spacer(modifier = Modifier.padding(15.dp))

                    Text(text = "جدول العملي")


                }
            }

        })
        }

    )
}
