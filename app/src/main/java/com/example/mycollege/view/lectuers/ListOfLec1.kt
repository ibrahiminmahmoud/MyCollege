package com.example.mycollege.view.lectuers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.data.model.Lec
import com.example.mycollege.view.home.Drawer
import com.example.mycollege.view.home.TopBar
import com.example.mycollege.view.home.cairo

@Composable
fun Listoflec1(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"الامن السيبراني") },
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
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp)


                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.leca),
                            contentDescription = "table",
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp)
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 4.dp),
                            horizontalAlignment = Alignment.Start

                        ) {
                            Text(
                                text = "المحاضرة الاولى سيبراني",
                                modifier = Modifier.padding(top = 4.dp),
                                fontSize = 14.sp,
                                fontFamily = cairo
                            )
                            Spacer(modifier = Modifier.padding(4.dp))

                            Text(
                                text = "الثلاثاء 23/07/2024استاذ مجتبى",
                                color=Color.DarkGray,
                                modifier = Modifier.padding(top = 4.dp),
                                fontSize = 10.sp,
                                fontFamily = cairo

                            )
                        }

                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_visibility_24),
                            contentDescription = "test",
                            modifier = Modifier
                                .clickable { navController.navigate("Listoflec1") }
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_download_24),
                            contentDescription = "test2",
                            tint = Color(0xFF04AB0B),


                            )

                    }
                    Spacer(modifier = Modifier.padding(5.dp))

                }
                items(1) {

                    Row(
                        modifier = Modifier
                            .background(color = Color(0xFFECF0F0))
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp)


                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.leca),
                            contentDescription = "table",
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp)
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 4.dp),
                            horizontalAlignment = Alignment.Start

                        ) {
                            Text(
                                text = "المحاضرة الثانية سيبراني",
                                modifier = Modifier.padding(top = 4.dp),
                                fontSize = 14.sp,
                                fontFamily = cairo
                            )
                            Spacer(modifier = Modifier.padding(4.dp))

                            Text(
                                text = "الخميس 25/07/2024استاذ مجتبى",
                                color=Color.DarkGray,
                                modifier = Modifier.padding(top = 4.dp),
                                fontSize = 10.sp,
                                fontFamily = cairo

                            )
                        }

                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_visibility_24),
                            contentDescription = "test",
                            modifier = Modifier
                                .clickable { navController.navigate("Listoflec1") }
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_download_24),
                            contentDescription = "test2",
                            tint = Color(0xFF04AB0B),


                            )

                    }
                    Spacer(modifier = Modifier.padding(5.dp))

                }

            }
        }

    )
}
