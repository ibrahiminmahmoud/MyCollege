package com.example.mycollege.view.lectuers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.view.Drawer
import com.example.mycollege.view.TopBar
import com.example.mycollege.view.cairo as cairo1

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Lectures(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val suggestions4 = listOf("الامن السيبراني", "تشفير ", "تنقيب بيانات", "شبكات","قواعد بيانات", "نمذجةومحاكاة")
    val count = 6



    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"محاضرات") },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content = {
                LazyVerticalGrid(cells = GridCells.Adaptive(130.dp)){

                items(suggestions4.size) { i->

                        Boxlec(
                            title = suggestions4[i],
                            icon = R.drawable.openbook,
                            route = "listoflec_page",
                            navController = navController
                        )
                    }




            }



        }

    )
}

/*[***Start Fun Box***]*/

@Composable
fun Boxlec(
   title:String,
    icon : Int,
    route:String,
    navController: NavController,


    ) {

    val suggestions4 = listOf("الامن السيبراني", "تشفير ", "تنقيب بيانات", "شبكات","قواعد بيانات", "نمذجةومحاكاة")
    Box(
        modifier = Modifier
            .padding(15.dp)
            .background(color = Color.Transparent, shape = RoundedCornerShape(15.dp))
            .aspectRatio(1f),
        contentAlignment = Alignment.BottomCenter

    ) {
        Button(
            onClick = { navController.navigate(route) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFF7F7FF),

                ),
            modifier = Modifier
                .height(150.dp)
                .width(130.dp)
            // .padding(10.dp)


        ) {
            Column(modifier = Modifier
                .padding(start = 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "test",
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),


                    )
                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .height(1.dp)
                        .width(120.dp)
                        .background(Color(0xFF177E89)),



                    ){}
                Spacer(modifier = Modifier.padding(6.dp))
                Text(
                        text = title,
                        color = Color.Black,
                        fontFamily = cairo1,
                        fontWeight = FontWeight.Bold
                    )


            }

        }






    }
}