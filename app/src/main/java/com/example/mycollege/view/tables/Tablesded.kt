package com.example.mycollege.view.tables



import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
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
import com.example.mycollege.view.Drawer
import com.example.mycollege.view.TopBar
import com.example.mycollege.view.cairo


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tablesded(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"محاضرات") },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content = { LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),

            contentPadding = PaddingValues(horizontal = 13.dp, vertical = 8.dp)){
            items(1) {
                Row(
                    modifier = Modifier
                        .background(Color(0xffF7F7FF))
                        .fillMaxWidth()
                        .padding(1.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center


                ){

                    Column(modifier = Modifier
                        .padding(start = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,


                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.table),
                            contentDescription = "table",
                            modifier = Modifier
                                .height(360.dp)
                                .width(320.dp)
                        )
                        Text(
                            text = "محاضرات تقانة المعلومات",
                            modifier = Modifier.padding(top = 4.dp),
                            fontSize = 14.sp,
                            fontFamily = cairo
                        )
                        Spacer(modifier = Modifier.padding(4.dp))

                    }
                }
            }
            items(1) {
                Row(
                    modifier = Modifier
                        .background(Color(0xffF7F7FF))
                        .fillMaxWidth()
                        .padding(1.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center


                ){

                    Column(modifier = Modifier
                        .padding(start = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,


                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.table),
                            contentDescription = "table",
                            modifier = Modifier
                                .height(360.dp)
                                .width(320.dp)
                        )
                        Text(
                            text = "محاضرات تقانة المعلومات",
                            modifier = Modifier.padding(top = 4.dp),
                            fontSize = 14.sp,
                            fontFamily = cairo
                        )
                        Spacer(modifier = Modifier.padding(4.dp))

                    }
                }
            }
            items(1) {
                Row(
                    modifier = Modifier
                        .background(Color(0xffF7F7FF))
                        .fillMaxWidth()
                        .padding(1.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center


                ){

                    Column(modifier = Modifier
                        .padding(start = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,


                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.table),
                            contentDescription = "table",
                            modifier = Modifier
                                .height(360.dp)
                                .width(320.dp)
                        )
                        Text(
                            text = "محاضرات تقانة المعلومات",
                            modifier = Modifier.padding(top = 4.dp),
                            fontSize = 14.sp,
                            fontFamily = cairo
                        )
                        Spacer(modifier = Modifier.padding(4.dp))

                    }
                }
            }



        } }

    )

}
