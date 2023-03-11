package com.example.mycollege.view

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.mycollege.R

@Composable
fun Register(navController: NavController) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    var expanded by remember { mutableStateOf(false) }
    var expanded1 by remember { mutableStateOf(false) }
    val suggestions = listOf("بكلاريوس", "دبلوم")
    val suggestions1 = listOf("علوم حاسوب", "تقانة معلومات", "حوسبة احصائية", "شبكات")
    val selectedText = remember { mutableStateOf("") }
    val selectedText1 =remember { mutableStateOf("") }

    var textfieldSize by remember {
        mutableStateOf(androidx.compose.ui.geometry.Size.Zero)
    }
    var textfieldSize1 by remember {
        mutableStateOf(androidx.compose.ui.geometry.Size.Zero)
    }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowDown
    else
        Icons.Filled.KeyboardArrowDown

    val icon1 = if (expanded)
        Icons.Filled.KeyboardArrowDown
    else
        Icons.Filled.KeyboardArrowDown


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()

        )
        {
            Box(
                modifier = Modifier.background(Color.White),


                contentAlignment = Alignment.Center
            ) {

                Image(
                    modifier = Modifier
                        .width(220.dp)
                        .height(190.dp),
                    painter = painterResource(R.drawable.register),
                    contentDescription = "Login",
                    contentScale = ContentScale.Fit

                )
            }
            //Spacer(modifier = Modifier.padding(5.dp))

            Scaffold(
                modifier = Modifier
                    .fillMaxWidth(),

                scaffoldState = scaffoldState
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth()
                        .background(Color.White)
                        .clip(RoundedCornerShape(30.dp))
                        .padding(7.dp)

                ) {
                    Text(
                        text = "انشاء حساب",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontFamily = cairo,

                        )
                    Column(Modifier.padding(20.dp)) {
                        TextField(
                            value = selectedText.value,
                            readOnly = true,
                            onValueChange = { selectedText.value = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { expanded = !expanded }
                                .onGloballyPositioned { coordinates ->
                                    //This value is used to assign to the DropDown the same width
                                    textfieldSize = coordinates.size.toSize()
                                },
                            label = { Text("اختر المساق الاكاديمي ",
                                fontFamily = cairo,

                                ) },
                            trailingIcon = {
                                Icon(icon, "contentDescription",
                                    Modifier.clickable { expanded = !expanded })
                            }
                        )
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier
                                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
                        ) {
                            suggestions.forEach { label ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedText.value = label
                                        expanded = false
                                    }) {
                                    Text(text = label,
                                        fontFamily = cairo,

                                        )

                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(5.dp))

                    Column(Modifier.padding(20.dp)) {
                        TextField(
                            value = selectedText1.value,
                            readOnly = true,
                            onValueChange = { selectedText1.value = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { expanded1 = !expanded1 }
                                .onGloballyPositioned { coordinates ->
                                    //This value is used to assign to the DropDown the same width
                                    textfieldSize1 = coordinates.size.toSize()
                                },
                            label = { Text(text="اختر التخصص ",
                                fontFamily = cairo,
                            ) },
                            trailingIcon = {
                                Icon(icon1, "contentDescription",
                                    Modifier.clickable { expanded1 = !expanded1 })
                            }
                        )
                        DropdownMenu(
                            expanded = expanded1,
                            onDismissRequest = { expanded1 = false },
                            modifier = Modifier
                                .width(with(LocalDensity.current) { textfieldSize1.width.toDp() })
                        ) {
                            suggestions1.forEach { label ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedText1.value = label
                                        expanded1 = false
                                    }) {
                                    Text(text = label,
                                        fontFamily = cairo,
                                    )

                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(7.dp))

                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF177E89)),
                        onClick = {
                            when {
                                selectedText.value.isEmpty() -> {
                                    Toast.makeText(context, "اخترالمساق", Toast.LENGTH_LONG).show()
                                }
                                selectedText1.value.isEmpty() -> {
                                    Toast.makeText(context, "اختار التخصص", Toast.LENGTH_LONG)
                                        .show()
                                }
                                else -> {
                                    if (selectedText.value== "بكلاريوس" && selectedText1.value == "شبكات"
                                    ) {
                                        Toast.makeText(
                                            context,
                                            "تخصص شبكات غير متاح في بكلاريوس",
                                            Toast.LENGTH_LONG
                                        ).show()

                                    } else {
                                        navController.navigate("register1_page")
                                    }

                                }
                            }

                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text(
                            text = "التالي",
                            fontSize = 20.sp,
                            color = Color.White,
                            fontFamily = cairo,

                            )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))


                }
            }
        }
    }
}
