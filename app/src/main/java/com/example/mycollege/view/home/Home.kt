package com.example.mycollege.view.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mycollege.R
import com.example.mycollege.view.NavigationItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun MainScreen(navController: NavController){

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"كلية دراسات الحاسوب واﻹحصاء") },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    )
    {

        paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))


        Home(navController = navController)
    }

}

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState:ScaffoldState,name:String){

    TopAppBar(

        title = {
            Text(
                text = name,
                color = Color(0xFF1E2019),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Justify,
                fontFamily = cairo
            )

        },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(
                    Icons.Filled.Menu, "menu",
                   tint =  Color(0xff1E2019)
                )
            }
        },
        backgroundColor  = Color(0xffF7F7FF),
        contentColor = Color.White
    )

}

@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController){

    val items = listOf(
        NavigationItem.MainScreen,
        NavigationItem.Poster,
        NavigationItem.Calender,
        NavigationItem.Tables,
        NavigationItem.Lectures,
        NavigationItem.Result,
        NavigationItem.Tester,
        NavigationItem.AboutApp,

        )



    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(Color(0xffF7F7FF)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){

            Image(
                painter = painterResource(id = R.drawable.log),
                contentDescription = "",
                modifier = Modifier
                    .height(360.dp)
                    .width(190.dp)
                    //.fillMaxWidth()
                    .padding(10.dp)
            )

        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { items ->
            DrawerItem(item = items, selected = currentRoute == items.route, onItemClick = {

                navController.navigate(items.route){
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route){
                            saveState = false
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }

                scope.launch {
                    scaffoldState.drawerState.close()
                }

            })
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "2023-2022",
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )

    }
}
@Composable
fun DrawerItem(item: NavigationItem, selected: Boolean, onItemClick: (NavigationItem) -> Unit){
    val background = if(selected) R.color.white else android.R.color.transparent
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .height(45.dp)
            .background(colorResource(id = background))
            .padding(start = 10.dp)
    ) {

        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color(0xFF0C7C59)),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 16.sp,
            color = Color.Black,
            fontFamily = cairo
        )

    }

}
val cairo = FontFamily(
    Font(R.font.cairo_semibold)
)
val cairo1 = FontFamily(
    Font(R.font.cairo_extralight)
)
val amir = FontFamily(
    Font(R.font.amiri)
)

val ben = FontFamily(
    Font(R.font.ben)
)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(navController: NavController) {

   LazyVerticalGrid(
       columns = GridCells.Adaptive(170.dp),
       modifier = Modifier
           .padding(17.dp)
           .background(color = Color.Transparent)) {
       /****Start Calender***/
       items(1) {
           Box("تقويم",R.drawable.clander,"calender_page",navController,80,80)
       }
       /****End Calender***/

       /****Start Tables***/
       items(1) {
           Box("جداول",R.drawable.grid,"Tables_page",navController,60,60)
       }
       /****End Tables***/

       /****Start Lecture***/
       items(1) {
               Box("محاضرات",R.drawable.leca,"lectures_page",navController,80,80)
       }
       /****End Lecture***/

       /****Start Post***/
       items(1) {
           Box("اعلانات",R.drawable.post1,"post_page",navController,80,80)
       }
       /****End Post***/

       /****Start result***/
       items(1) {
           Box("نتيجة",R.drawable.notepad,"result_page",navController,60,60)
       }
       /****End  result***/

       /****Start About***/
       items(1) {
           Box("اختبارات",
                R.drawable.test1,"tester_page",navController,80,80)
       }
       /****End About***/

       /****Start About***/
       items(1) {
           Box("حول",
               R.drawable.info,"about_page",navController,60,60)
       }
       /****End About***/

       /****Start About***/
       items(1) {
           Box("خروج",
               R.drawable.logout,"login_page",navController,60,60)
       }
       /****End About***/
   }

}
/*[***Start Fun Box***]*/

@Composable
fun Box(
    title: String,
    icon: Int,

    route:String,
    navController: NavController,
    wth:Int,
    he:Int,

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
                backgroundColor = Color(0xFFECF0F0),

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
                        .height(he.dp)
                        .width(wth.dp),


                    )
                Spacer(modifier = Modifier.padding(9.dp))
                Row(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .height(1.dp)
                        .width(120.dp)
                        .background(Color(0xFF177E89)),



                ){}
                Spacer(modifier = Modifier.padding(3.dp))
                Text(text = title,
                    color = Color.Black,
                    fontFamily = ben,
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(1.dp))

            }

        }






    }
}
//*[***End Fun Box ***]*//
