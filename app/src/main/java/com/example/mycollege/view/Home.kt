@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.mycollege.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mycollege.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainScreen(navController: NavController){

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState) },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    ) {


        Home(navController = navController)
    }

}

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState){

    TopAppBar(

        title = { Text(
                   text = "My College ",
                   color = Color.Black,
                   fontSize = 18.sp,
                   fontWeight = FontWeight.SemiBold)

                 },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(Icons.Filled.Menu, "")
            }
        },
        backgroundColor = Color(0xFFB8CAED),
        contentColor = Color.Black
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
        NavigationItem.AboutApp
    )

    Column(
        modifier = Modifier
            .background(color = Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color(0xFF98afc7)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){

            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
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
fun DrawerItem(  item: NavigationItem, selected: Boolean, onItemClick: (NavigationItem) -> Unit){
    val background = if(selected) R.color.teal_200 else android.R.color.transparent
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
            colorFilter = ColorFilter.tint(Color.Black),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 16.sp,
            color = Color.Black
        )

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(navController: NavController) {

   LazyVerticalGrid(cells = GridCells.Adaptive(150.dp)) {
       items(1) {
           box("تقومي",R.drawable.ic_baseline_calendar_month_24,"calender_page",navController)
       }
       items(1) {
           box("جداولي",R.drawable.ic_baseline_table_view_24,"Tables_page",navController)
       }
       /****Lecture***/
       items(1) {
           box("محاضرات",R.drawable.ic_baseline_menu_book_24,"lectures_page",navController)
       }
       /****endLecture***/

       /****Start Post***/

       items(1) {
           box("اعلانات",R.drawable.ic_baseline_local_post_office_24,"post_page",navController)
       }
       /****End Post***/
       /****Start result***/

       items(1) {
           box("نتيجتي",R.drawable.ic_outline_wysiwyg_24,"result_page",navController)
       }
       /****End  result***/

       /****Start About***/

       items(1) {
           box("حول",
                R.drawable.ic_baseline_info_24,"about_page",navController)
       }
       /****End About***/
   }

}
@Composable
fun box(
    title:String,
    icon : Int,
    route:String,
    navController: NavController,

) {
    Box(
        modifier = Modifier
            .padding(15.dp)
            .background(color = Color(0xFFededed), shape = RoundedCornerShape(15.dp))
            .aspectRatio(1f),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(

            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF03AB2D)
            )
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "test",
                modifier = Modifier
                    .height(180.dp)
                    .clickable { navController.navigate(route) }
                    .width(150.dp),
                tint = Color(0xFF262826)

            )
        }
        Spacer(modifier = Modifier.padding(15.dp))

        Text(text = title, color = Color.White)


    }
}