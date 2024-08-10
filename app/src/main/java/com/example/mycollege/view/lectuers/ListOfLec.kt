package com.example.mycollege.view.lectuers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.data.model.Lec
import com.example.mycollege.view.home.Drawer
import com.example.mycollege.view.home.TopBar
import com.example.mycollege.view.home.cairo

@Composable
fun Listoflec(navController: NavController,) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState, "المحاضرات") },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content = {
                paddingValues ->
            Box(modifier = Modifier.padding(paddingValues))
            LazyColumn(
                modifier = Modifier
                    .padding(17.dp)
            ){

                items(1) {

                    Row(
                        modifier = Modifier
                            .background(color = Color(0xFFECF0F0))
                            .fillMaxWidth()
                            .padding(all=8.dp),

                        ) {
                        Image(
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)
                                .clip(CircleShape),
                            painter = painterResource(R.drawable.pdf),
                            contentDescription = "lec",
                            contentScale = ContentScale.Fit,
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 8.dp),
//                horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top,

                            ) {
                            Lec(title = "المحاضرة الاولى شبكات", id = 0, lecId =R.raw.lecture9, description = "استاذة نجلاء")
                            Text(

                                text = "المحاضرة الاولى شبكات",
                                color = Color.Black,
                                fontFamily = cairo,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Right,
                                modifier = Modifier
                                    .padding(top = 4.dp)
                                    .clickable { navController.navigate("pdfview_page") }

                                ,

                                )

                            Text(
                                text = "استاذه نجلاء",
                                color = Color.Black,
                                fontFamily = cairo,
                                fontWeight = FontWeight.Bold,

                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))



                    }
                    Spacer(modifier = Modifier.padding(5.dp))

                }

                items(1) {

                    Row(
                        modifier = Modifier
                            .background(color = Color(0xFFECF0F0))
                            .fillMaxWidth()
                            .padding(all=8.dp),

                        ) {
                        Image(
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)
                                .clip(CircleShape),
                            painter = painterResource(R.drawable.pdf),
                            contentDescription = "lec",
                            contentScale = ContentScale.Fit,
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 8.dp),
//                horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top,

                            ) {
                            Text(

                                text = "المحاضره الثانية شبكات",
                                color = Color.Black,
                                fontFamily = cairo,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Right,
                                modifier = Modifier
                                    .padding(top = 4.dp)
                                    .clickable { navController.navigate("pdfview_page1") }

                                ,

                                )
                            Text(
                                text = "استاذه نجلاء",
                                color = Color.Black,
                                fontFamily = cairo,
                                fontWeight = FontWeight.Bold,


                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))



                    }
                    Spacer(modifier = Modifier.padding(5.dp))

                }




            }
        }
    )
}

