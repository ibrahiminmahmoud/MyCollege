package com.example.mycollege

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycollege.data.model.MyViewModel
import com.example.mycollege.ui.theme.MyCollegeTheme
import com.example.mycollege.view.*
import com.example.mycollege.view.aboutapp.AboutApp
import com.example.mycollege.view.calender.Calender
import com.example.mycollege.view.home.MainScreen
import com.example.mycollege.view.lectuers.ComposePDFViewerw
import com.example.mycollege.view.lectuers.ComposePDFViewer
import com.example.mycollege.view.lectuers.Lectures
import com.example.mycollege.view.lectuers.Listoflec
import com.example.mycollege.view.post.Poster
import com.example.mycollege.view.post.Post1
import com.example.mycollege.view.post.Post2
import com.example.mycollege.view.register.Register
import com.example.mycollege.view.register.Register1
import com.example.mycollege.view.result.Result
import com.example.mycollege.view.tables.Tables
import com.example.mycollege.view.tables.Tablesded
import com.example.mycollege.view.tester.Tester

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyCollegeTheme{
                NavigatePage()
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun  NavigatePage() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavigationItem.AboutApp.route, builder = {

        composable(NavigationItem.LoginPage.route) {
            LoginPage(navController = navController)
        }
        composable(NavigationItem.Tablesded.route) {
            Tablesded(navController = navController)
        }
        composable(NavigationItem.Register.route) {
            Register(navController = navController)
        }
        composable(NavigationItem.Calender.route) {
            Calender(navController = navController)
        }
        composable(NavigationItem.Register1.route) {
            Register1(navController = navController)
        }

        composable(NavigationItem.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(NavigationItem.ComposePDFViewerw.route) {
            ComposePDFViewerw(navController = navController)
        }
        composable(NavigationItem.ComposePDFViewer.route) {
            ComposePDFViewer(navController = navController)
        }


        composable(NavigationItem.Listoflec.route) {
            Listoflec(navController = navController)
        }

        composable(NavigationItem.Poster.route) {
            Poster(navController = navController)
        }
        composable(NavigationItem.Post1.route) {
            Post1(navController = navController)
        }
        composable(NavigationItem.Post2.route) {
            Post2(navController = navController)
        }


        composable(NavigationItem.Tester.route) {
            Tester(navController = navController)
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
    })

}

