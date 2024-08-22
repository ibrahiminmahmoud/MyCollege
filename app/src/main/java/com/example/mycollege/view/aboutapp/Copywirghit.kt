package com.example.mycollege.view.aboutapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.view.home.Drawer
import com.example.mycollege.view.home.TopBar
import com.example.mycollege.view.home.cairo

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Copywirghit(navController: NavController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState, "حقوق التأليف والنشر") },
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
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
            )
            {
                items(1) {
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "حقوق التأليف والنشر على النحو الاتي:",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontFamily = cairo,
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "1-هذا التطبيق عبارة عن نسخة تجربية من مشروع بحث التخرج لطلاب من كلية دراسات الحاسوب والإحصاء ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Thin,
                        color = Color.Black,
                        fontFamily = cairo,
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                }
                items(1) {
                    Text(
                        text = "2-لايسمح بالتصرف في هذا التطبيق الا بعد الرجوع الي مطورين هذا التطبيق  ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Thin,
                        color = Color.Black,
                        fontFamily = cairo,
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                }
                items(1) {
                    Text(
                        text = "3-هذه النسخة غير قابلة للنشر والاستخدام العام لانها نسخة تجربية ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Thin,
                        color = Color.Black,
                        fontFamily = cairo,
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                }


            }
        }

    )
}
