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
import com.example.mycollege.view.aboutapp.AboutApp
import com.example.mycollege.view.aboutapp.Copywirghit
import com.example.mycollege.view.aboutapp.Polices
import com.example.mycollege.view.aboutapp.Services
import com.example.mycollege.view.calender.Calender
import com.example.mycollege.view.calender.CalenderViewer
import com.example.mycollege.view.home.MainScreen
import com.example.mycollege.view.lectuers.ComposePDFViewer
import com.example.mycollege.view.lectuers.LectuersView
import com.example.mycollege.view.lectuers.LectuersView1
import com.example.mycollege.view.lectuers.LectuersView2
import com.example.mycollege.view.lectuers.LectuersView3
import com.example.mycollege.view.lectuers.Lectures
import com.example.mycollege.view.lectuers.Listoflec
import com.example.mycollege.view.lectuers.Listoflec1
import com.example.mycollege.view.lectuers.Listoflec2
import com.example.mycollege.view.lectuers.Listoflec3
import com.example.mycollege.view.post.Poster
import com.example.mycollege.view.post.Post1
import com.example.mycollege.view.post.Post2
import com.example.mycollege.view.post.PostViewer1
import com.example.mycollege.view.post.PostViewer2
import com.example.mycollege.view.register.Register
import com.example.mycollege.view.register.Register1
import com.example.mycollege.view.result.Result
import com.example.mycollege.view.result.ResultViewer
import com.example.mycollege.view.tables.Tables
import com.example.mycollege.view.tables.TablesViewer1
import com.example.mycollege.view.tables.TablesViewer2
import com.example.mycollege.view.tables.TablesViewer3
import com.example.mycollege.view.tables.Tablesded
import com.example.mycollege.view.tables.Tablesded1
import com.example.mycollege.view.tables.Tablesded2
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
    NavHost(navController, startDestination = NavigationItem.LoginPage.route, builder = {

        composable(NavigationItem.LoginPage.route) {
            LoginPage(navController = navController)
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


        composable(NavigationItem.Tables.route) {
            Tables(navController = navController)
        }
        composable(NavigationItem.Tablesded.route) {
            Tablesded(navController = navController)
        }
        composable(NavigationItem.Tablesded1.route) {
            Tablesded1(navController = navController)
        }
        composable(NavigationItem.Tablesded2.route) {
            Tablesded2(navController = navController)
        }
        composable(NavigationItem.TablesViewer1.route) {
            TablesViewer1()
        }
        composable(NavigationItem.TablesViewer2.route) {
            TablesViewer2()
        }
        composable(NavigationItem.TablesViewer3.route) {
            TablesViewer3()
        }


        composable(NavigationItem.Calender.route) {
            Calender(navController = navController)
        }
        composable(NavigationItem.CalenderViewer.route) {
            CalenderViewer()
        }

        composable(NavigationItem.Lectures.route) {
            Lectures(navController = navController)
        }
        composable(NavigationItem.Listoflec.route) {
            Listoflec(navController = navController)
        }
        composable(NavigationItem.Listoflec1.route) {
            Listoflec1(navController = navController)
        }
        composable(NavigationItem.Listoflec2.route) {
            Listoflec2(navController = navController)
        }
        composable(NavigationItem.Listoflec3.route) {
            Listoflec3(navController = navController)
        }
        composable(NavigationItem.LectuersView.route) {
            LectuersView()
        }
        composable(NavigationItem.LectuersView1.route) {
            LectuersView1()
        }
        composable(NavigationItem.LectuersView2.route) {
            LectuersView2()
        }
        composable(NavigationItem.LectuersView3.route) {
            LectuersView3()
        }
        composable(NavigationItem.ComposePDFViewer.route) {
            ComposePDFViewer()
        }


        composable(NavigationItem.Poster.route) {
            Poster(navController = navController)
        }
        composable(NavigationItem.Post1.route) {
            Post1(navController = navController)
        }
        composable(NavigationItem.PostViewer1.route) {
            PostViewer1()
        }
        composable(NavigationItem.Post2.route) {
            Post2(navController = navController)
        }
        composable(NavigationItem.PostViewer2.route) {
            PostViewer2()
        }


        composable(NavigationItem.Tester.route) {
            Tester(navController = navController)
        }



        composable(NavigationItem.Result.route) {
            Result(navController = navController)
        }
        composable(NavigationItem.ResultViewer.route) {
            ResultViewer()
        }


        composable(NavigationItem.AboutApp.route) {
            AboutApp(navController = navController)
        }
        composable(NavigationItem.Polices.route) {
            Polices(navController = navController)
        }
        composable(NavigationItem.Services.route) {
            Services(navController = navController)
        }
        composable(NavigationItem.Copywirghit.route) {
            Copywirghit(navController = navController)
        }
    })

}

