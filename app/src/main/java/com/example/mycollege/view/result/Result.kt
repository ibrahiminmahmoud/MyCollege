package com.example.mycollege.view.result

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
fun Result(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"النتيجة") },
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
                    painter = painterResource(id = R.drawable.notepad),
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
                        text = "نتيجة الفصل الدراسي الاول ",
                        modifier = Modifier.padding(top = 4.dp),
                        fontSize = 14.sp,
                        fontFamily = cairo
                    )
                    Spacer(modifier = Modifier.padding(4.dp))

                    Text(
                        text = "الثلاثاء 23/07/2024",
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
                            .clickable { navController.navigate("ResultViewer") }
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