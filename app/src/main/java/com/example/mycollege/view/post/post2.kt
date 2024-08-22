package com.example.mycollege.view.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.view.home.Drawer
import com.example.mycollege.view.home.TopBar
import com.example.mycollege.view.home.cairo

@Composable
fun Post2(navController: NavController){
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"خاص") },
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
                            .padding(9.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start


                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.post1),
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
                                text = "قرار حالة غـش",
                                modifier = Modifier.padding(top = 4.dp),
                                fontSize = 16.sp,
                                fontFamily = cairo,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )

                            Text(
                                text = "بتاريخ 22/02/2023",
                                color= Color.DarkGray,
                                modifier = Modifier.padding(top = 4.dp),
                                fontSize = 10.sp,
                                fontFamily = cairo

                            )
                        }
                        Spacer(modifier = Modifier.padding(9.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_visibility_24),
                            contentDescription = "test",
                            modifier = Modifier
                                .clickable { navController.navigate("PostViewer2") }
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
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