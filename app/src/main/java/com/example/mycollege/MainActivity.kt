package com.example.mycollege

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycollege.ui.theme.MyCollegeTheme
import com.example.mycollege.view.*
import com.example.mycollege.view.tables.Tables
import com.example.mycollege.view.tables.Tablesded

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
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





@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun  NavigatePage() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavigationItem.LoginPage.route) {
        composable(NavigationItem.LoginPage.route) {
            LoginPage(navController = navController)
        }
        composable(NavigationItem.Tablesded.route) {
            Tablesded(navController = navController)
        }
        composable(NavigationItem.Register.route) {
            Register(navController = navController)
        }
        composable(NavigationItem.Register1.route) {
            Register1(navController = navController)
        }

        composable(NavigationItem.MainScreen.route) {
            MainScreen(navController = navController)
        }

        composable(NavigationItem.Poster.route) {
            Poster(navController = navController)
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

