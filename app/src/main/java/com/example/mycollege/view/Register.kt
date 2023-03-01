package com.example.mycollege.view

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.ui.theme.Purple500

@Composable
fun Register(navController: NavController){
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    var expanded by remember { mutableStateOf(false) }
    var expanded1 by remember { mutableStateOf(false) }
    val suggestions = listOf("بكلاريوس","دبلوم")
    val suggestion2 = listOf("علوم حاسوب", "تقانة معلومات","حوسبة احصائية","شبكات")
    var selectedText by remember { mutableStateOf("") }
    var selectedText1 by remember { mutableStateOf("") }

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
    val icon1 = if (expanded1)
        Icons.Filled.KeyboardArrowDown
    else
        Icons.Filled.KeyboardArrowDown

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White) ,
        contentAlignment = Alignment.Center
    ){
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
            ){

                Image(modifier = Modifier
                    .width(220.dp)
                    .height(190.dp),
                    painter =  painterResource(R.drawable.register),
                    contentDescription = "Login",
                    contentScale = ContentScale.Fit

                )
            }
            //Spacer(modifier = Modifier.padding(5.dp))

            Scaffold(
                modifier = Modifier
                    .fillMaxWidth(),

                scaffoldState = scaffoldState) {

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
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.padding(5.dp))
                    //dropDownMenu()
                    Column(Modifier.padding(20.dp)) {
                        TextField(
                            value = selectedText,
                            readOnly = true,
                            onValueChange = { selectedText = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { expanded = !expanded }
                                .onGloballyPositioned { coordinates ->
                                    //This value is used to assign to the DropDown the same width
                                    textfieldSize = coordinates.size.toSize()
                                },
                            label = { Text("اختر المساق الاكادمي") },
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
                                        selectedText = label.toString()
                                        expanded = false
                                    }) {
                                    Text(text = label)

                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    //dropDownMenu1()
                    Column(Modifier.padding(20.dp)) {
                        TextField(
                            value = selectedText1,
                            readOnly = true,
                            onValueChange = { selectedText1 = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { expanded1 = !expanded1 }
                                .onGloballyPositioned { coordinates ->
                                    //This value is used to assign to the DropDown the same width
                                    textfieldSize1 = coordinates.size.toSize()
                                },
                            label = { Text("اختر التخصص ") },
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
                            suggestion2.forEach { label ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedText1 = label.toString()
                                        expanded1 = false
                                    }) {
                                    Text(text = label)

                                }
                            }
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.padding(7.dp))

                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF177E89)),
                            onClick = {
                                when{
                                    selectedText.isEmpty()->{
                                        Toast.makeText(context,"اخترالمساق",Toast.LENGTH_LONG).show()
                                    }
                                    selectedText1.isEmpty()->{
                                        Toast.makeText(context,"اختار التخصص",Toast.LENGTH_LONG).show()
                                    }else -> {
                                      navController.navigate("register1_page")
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
                                color = Color(0xFFF8FCF8)
                            )
                        }
                        Spacer(modifier = Modifier.padding(10.dp))

                    }
                }
            }
        }
    }
}

@Composable
fun dropDownMenu(


) {

    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("بكلاريوس","دبلوم")
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember {
        mutableStateOf(androidx.compose.ui.geometry.Size.Zero)
    }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowDown
    else
        Icons.Filled.KeyboardArrowDown


    Column(Modifier.padding(20.dp)) {

        TextField(
            value = selectedText,
            readOnly = true,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = { Text("اختر المساق الاكادمي") },
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
                        selectedText = label.toString()
                        expanded = false
                    }) {
                    Text(text = label.toString())
                }
            }
        }

    }

}
@Composable
fun dropDownMenu1(

) {

    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("علوم حاسوب", "تقانة معلومات","حوسبة احصائية","شبكات")
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember {
        mutableStateOf(androidx.compose.ui.geometry.Size.Zero)
    }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowDown
    else
        Icons.Filled.KeyboardArrowDown


    Column(Modifier.padding(20.dp)) {
        TextField(
            value = selectedText,
            readOnly = true,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = { Text("اختر التخصص ") },
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
                        selectedText = label.toString()
                        expanded = false
                    }) {
                    Text(text = label)

                }
            }
        }
    }

}