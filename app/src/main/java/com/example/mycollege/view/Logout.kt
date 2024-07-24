package com.example.mycollege.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.view.home.Drawer
import com.example.mycollege.view.home.TopBar
import com.example.mycollege.view.home.cairo

@Composable
fun Logout(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"التقويم") },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content = {paddingValues ->
            Box(modifier = Modifier.padding(paddingValues))
            LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),

            contentPadding = PaddingValues(horizontal = 13.dp, vertical = 8.dp)){
            items(1) {
                Row(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)


                ){
                    Image(
                        painter = painterResource(id = R.drawable.table),
                        contentDescription = "table",
                        modifier = Modifier


                            .height(80.dp)
                    )
                    Column(modifier = Modifier
                        .padding(start = 4.dp),
                        horizontalAlignment = Alignment.Start

                    ) {
                        Text(
                            text = "محاضرات تقانة المعلومات",
                            modifier = Modifier.padding(top = 4.dp),
                            fontSize = 14.sp,
                            fontFamily = cairo
                        )
                        Spacer(modifier = Modifier.padding(4.dp))

                        Text(
                            text = "",
                            modifier = Modifier.padding(top = 4.dp),
                            style = MaterialTheme.typography.h4.copy()

                            ,
                            fontSize = 7.sp,
                            fontFamily = cairo

                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_visibility_24),
                        contentDescription = "test",



                        )
                }
            }
            items(1) {
                Row(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)


                ){
                    Image(
                        painter = painterResource(id = R.drawable.table),
                        contentDescription = "table",
                        modifier = Modifier


                            .height(80.dp)
                    )
                    Column(modifier = Modifier
                        .padding(start = 4.dp)
                    ) {
                        Text(
                            text = "محاضرات تقانة المعلومات",
                            modifier = Modifier.padding(start = 4.dp),
                            fontSize = 14.sp,
                            fontFamily = cairo
                        )
                        Spacer(modifier = Modifier.padding(4.dp))

                        Text(
                            text = "",
                            modifier = Modifier.padding(top = 4.dp),
                            style = MaterialTheme.typography.h4.copy()

                            ,
                            fontSize = 7.sp,
                            fontFamily = cairo

                        )
                    }
                }
            }
            items(1) {
                Row(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)


                ){
                    Image(
                        painter = painterResource(id = R.drawable.table),
                        contentDescription = "table",
                        modifier = Modifier


                            .height(80.dp)
                    )
                    Column(modifier = Modifier
                        .padding(start = 4.dp)
                    ) {
                        Text(
                            text = "محاضرات تقانة المعلومات",
                            modifier = Modifier.padding(start = 4.dp),
                            fontSize = 14.sp,
                            fontFamily = cairo
                        )
                        Spacer(modifier = Modifier.padding(4.dp))

                        Text(
                            text = "currentDateAndTime",
                            modifier = Modifier.padding(top = 4.dp),
                            style = MaterialTheme.typography.h4.copy()

                            ,
                            fontSize = 7.sp,
                            fontFamily = cairo

                        )
                    }
                }
            }


        } }

    )
}
