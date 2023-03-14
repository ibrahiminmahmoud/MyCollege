package com.example.mycollege.view.lectuers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycollege.view.cairo

@Composable
fun listoflec(navController: NavController,

) {


        Column(

            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,

        ) {
            Text(text = "name",
                color = Color.Black,
                fontFamily = cairo,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(6.dp))

            Text(
                text = "des.pdf",
                color = Color.Black,
                fontFamily = cairo,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable { navController.navigate("pdfview_page") }
            )
            Spacer(modifier = Modifier.padding(6.dp))

            Text(text = "des.pdf",
                color = Color.Black,
                fontFamily = cairo,
                fontWeight = FontWeight.Bold)
        }


}