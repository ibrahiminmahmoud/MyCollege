package com.example.mycollege

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycollege.ui.theme.MyCollegeTheme
import com.example.mycollege.view.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyCollegeTheme {
               // NavigatePage()
                  NavigatePage()
            }
        }
    }
}





@Composable
fun  NavigatePage() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavigationItem.MainScreen.route) {
        composable(NavigationItem.LoginPage.route) {
            LoginPage(navController = navController)
        }
        composable(NavigationItem.Register.route) {
            Register(navController = navController)
        }

        composable(NavigationItem.MainScreen.route) {
            MainScreen(navController = navController)
        }

        composable(NavigationItem.Poster.route) {
            Poster()
        }
        composable(NavigationItem.Calender.route) {
            calender(navController = navController)
        }
        composable(NavigationItem.Tables.route) {
            Tables(navController = navController)
        }

        composable(NavigationItem.Lectures.route) {
            Lectures(navController = navController)
        }
        composable(NavigationItem.Result.route) {
            Result(navController = navController)
        }
        composable(NavigationItem.AboutApp.route) {
            AboutApp(navController = navController)
        }
    }

}


//@Composable
//fun NavigatePage() {
//
//    val navController = rememberNavController()
//
//    NavHost(
//        navController = navController,
//        startDestination = "login_page",
//        builder ={
//            composable("login_page", content = { LoginPage(navController = navController)})
//            composable("register_page", content = { Register(navController = navController)})
//            composable("home_page", content = { MainScreen(navController = navController) })
//            composable("Tables_page", content = { Tables(navController = navController) })
//    }
//    )
//}
