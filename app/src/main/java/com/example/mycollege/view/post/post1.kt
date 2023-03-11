package com.example.mycollege.view.post

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.view.Drawer
import com.example.mycollege.view.TopBar
import com.example.mycollege.view.cairo

@Composable
fun post1(navController: NavController){
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState,"عام") },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content ={
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(4.dp),

                contentPadding = PaddingValues(horizontal = 13.dp, vertical = 12.dp)){
                items(1) {
                    ZoomableImage("تسجيل الطلاب الجدد",R.drawable.table)
                }
                items(1) {
                    ZoomableImage("تسجيل الطلاب الجدد",R.drawable.table)
                }

                items(1) {
                    ZoomableImage("تسجيل الطلاب الجدد",R.drawable.table)
                }

                items(1) {
                    ZoomableImage("تسجيل الطلاب الجدد",R.drawable.table)
                }





            }
        })

}
@Composable
fun ZoomableImage(name:String,Icon:Int) {
    val scale = remember { mutableStateOf(1f) }
    val rotationState = remember { mutableStateOf(1f) }
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .background(Color(0xffF7F7FF))
            .fillMaxWidth()
            .horizontalScroll(scrollState)
            .clip(RectangleShape)
            .padding(1.dp)
            .pointerInput(Unit) {
                detectTransformGestures { centroid, pan, zoom, rotation ->
                    scale.value *= zoom
                    rotationState.value += rotation
                }
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center


    ){

        Column(modifier = Modifier
            .padding(start = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,


            ) {
            Image(
                painter = painterResource(Icon),
                contentDescription = "table",
                modifier = Modifier
                    .height(360.dp)
                    .width(320.dp)
                    .graphicsLayer(
                        // adding some zoom limits (min 50%, max 200%)
                        scaleX = maxOf(.5f, minOf(3f, scale.value)),
                        scaleY = maxOf(.5f, minOf(3f, scale.value)),
                        rotationZ = rotationState.value
                    ),
            )
            Text(
                text = name,
                modifier = Modifier.padding(top = 4.dp),
                fontSize = 14.sp,
                fontFamily = cairo
            )
            Spacer(modifier = Modifier.padding(4.dp))

        }
    }

}
