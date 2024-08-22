package com.example.mycollege.view.calender

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import com.example.mycollege.view.home.Drawer
import com.example.mycollege.view.home.TopBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.view.home.cairo

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Calender(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope,scaffoldState = scaffoldState,"التقويم") },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content = {
                paddingValues ->
            Box(modifier = Modifier.padding(paddingValues))
            LazyColumn(
                modifier = Modifier
                    .padding(17.dp)
            )
            {

                items(1) {


                    Row(
                        modifier = Modifier
                            .background(color = Color(0xFFECF0F0))
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)


                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.clander),
                            contentDescription = "table",
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp)
                        )
                        Column(
                            modifier = Modifier
                                .padding(all= 8.dp),
                            horizontalAlignment = Alignment.Start

                        ) {
                            Text(
                                text = "التقويم الدراسي بالكلية  ",
                                modifier = Modifier.padding(top = 4.dp),
                                fontSize = 14.sp,
                                fontFamily = cairo,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                            Spacer(modifier = Modifier.padding(4.dp))

                            Text(
                                text = "للعام 2024/2025",
                                color=Color.DarkGray,
                                modifier = Modifier.padding(top = 4.dp),
                                fontSize = 10.sp,
                                fontFamily = cairo

                            )
                        }
                        Spacer(modifier = Modifier.padding(10.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_visibility_24),
                            contentDescription = "test",
                            modifier = Modifier

                                .clickable { navController.navigate("CalenderViewer") }
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_download_24),
                            contentDescription = "test2",
                            tint = Color(0xFF04AB0B),


                            )

                    }

                }



            }
        }
    )
}


