@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.mycollege.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AboutApp(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"حول التطبيق") },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content = { LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),

            contentPadding = PaddingValues(horizontal = 13.dp, vertical = 8.dp)){
            items(1) {
                Row(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)


                ){
                    Text(text = "هذا التطبيق يعمل على توفير كل جديد في الكلية للطلاب من محاضرات وتقويم واعلانات ونتائج الامتحانات \nوالمتحوى الدراسي",
                        color = Color.Black,
                        fontFamily = cairo,
                        fontWeight = FontWeight.Bold)
                }
            }


        } }

    )
}
