package com.example.mycollege.view.aboutapp

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.ui.theme.Purple500
import com.example.mycollege.view.home.Drawer
import com.example.mycollege.view.home.TopBar
import com.example.mycollege.view.home.cairo

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AboutApp(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState, "حول التطبيق") },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content = {
                paddingValues ->
            Box(modifier = Modifier.padding(paddingValues))
            LazyColumn(
                modifier = Modifier
                    .background(color = Color(0xFFECF0F0))
                    .fillMaxHeight()
                    .padding(17.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            )
            {
                items(1) {
                    Box(
                        modifier = Modifier
                            .padding(all = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            modifier = Modifier
                                .width(250.dp)
                                .height(140.dp),
                            painter = painterResource(R.drawable.mycollege),
                            contentDescription = "حول التطبيق",
                            contentScale = ContentScale.Fit,


                            )
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "MyCollege",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontFamily = cairo,
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "V 1.0.0.0",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Thin,
                        color = Color.Black,
                        fontFamily = cairo,
                    )

                    Spacer(modifier = Modifier.padding(25.dp))

                }
                items(1) {


                    Row(
                        modifier = Modifier
                            .background(color = Color(0xFFECF0F0))
                            .clickable { navController.navigate("Polices") }
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween


                    ) {

                            Text(
                                text = "سياسة الخصوصية ",
                                modifier = Modifier.padding(top = 4.dp),
                                fontSize = 14.sp,
                                fontFamily = cairo,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                            Spacer(modifier = Modifier.padding(4.dp))

//                        }
                        Spacer(modifier = Modifier.padding(10.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                            contentDescription = "test",
                            tint = Color.LightGray,

                            modifier = Modifier

                                .clickable { navController.navigate("Polices") }
                        )


                    }

                }
                items(1) {


                    Row(
                        modifier = Modifier
                            .background(color = Color(0xFFECF0F0))
                            .clickable {  navController.navigate("Services") }
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween


                    ) {


                        Text(
                            text = "شروط الخدمة ",
                            modifier = Modifier.padding(top = 4.dp),
                            fontSize = 14.sp,
                            fontFamily = cairo,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.padding(4.dp))


                        Spacer(modifier = Modifier.padding(10.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                            contentDescription = "test",
                            tint = Color.LightGray,

                            modifier = Modifier

                                .clickable { navController.navigate("Services") }
                        )


                    }

                }
                items(1) {


                    Row(
                        modifier = Modifier
                            .background(color = Color(0xFFECF0F0))
                            .clickable {navController.navigate("Copywirghit")  }
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween


                    ) {


                        Text(
                            text = "حقوق التأليف والنشر ",
                            modifier = Modifier.padding(top = 4.dp),
                            fontSize = 14.sp,
                            fontFamily = cairo,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.padding(4.dp))


                        Spacer(modifier = Modifier.padding(10.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                            contentDescription = "test",
                            tint = Color.LightGray,

                            modifier = Modifier

                                .clickable { navController.navigate("Copywirghit") }
                        )
                    }

                }
                items(1) {
                    Box(
                        modifier = Modifier
                            .padding(all = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                    }
                    Spacer(modifier = Modifier.padding(50.dp))

                    Text(
                        text = "حقوق الطبع والنشر @ 2022-2023",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.DarkGray,
                        fontFamily = cairo,
                    )
                    Spacer(modifier = Modifier.padding(25.dp))
                }







            }
        }

    )
}
