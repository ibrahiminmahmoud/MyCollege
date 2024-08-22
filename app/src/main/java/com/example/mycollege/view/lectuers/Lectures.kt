package com.example.mycollege.view.lectuers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.view.home.Drawer
import com.example.mycollege.view.home.TopBar
import com.example.mycollege.view.home.amir

@Composable
fun Lectures(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()



   Scaffold(scaffoldState = scaffoldState,
       topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"محاضرات") },
       drawerContent = {
           Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
       }) {
           paddingValues ->
       Box(modifier = Modifier.padding(paddingValues))

           LazyVerticalGrid(
               columns = GridCells.Adaptive(170.dp),
               modifier = Modifier
                   .padding(17.dp)
           )
           {

               items(1) {
                   Boxlec(
                       title = "تشفير",
                       icon = R.drawable.leca,
                       route = "listoflec_page",
                       navController = navController
                   )
               }
               items(1) {
                   Boxlec(
                       title = "الامن السيبراني",
                       icon = R.drawable.leca,
                       route = "listoflec_page1",
                       navController = navController
                   )
               }
               items(1) {
                   Boxlec(
                       title = "نمذجة ومحاكة",
                       icon = R.drawable.leca,
                       route = "listoflec_page2",
                       navController = navController
                   )
               }
               items(1) {
                   Boxlec(
                       title = "ادارة شبكات",
                       icon = R.drawable.leca,
                       route = "listoflec_page3",
                       navController = navController
                   )
               }
           }
   }
}

/*[***Start Fun Box***]*/

@Composable
fun Boxlec(
   title:String,
    icon : Int,
    route:String,
    navController: NavController,
    ) {
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
                .height(170.dp)
                .width(130.dp)

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
                        fontFamily = amir,
                        fontWeight = FontWeight.Bold
                    )


            }

        }


    }
}