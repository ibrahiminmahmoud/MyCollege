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
fun Register1(navController: NavController){ val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val nameVal = remember {
        mutableStateOf("")
    }
    val studentnumberVal = remember {
        mutableStateOf("")
    }
    val phonenumberVal = remember {
        mutableStateOf("")
    }
    val passwordVal = remember {
        mutableStateOf("")
    }
    val confirmPasswordVal= remember {
        mutableStateOf("")
    }
    val passwordVisibility = remember {
        mutableStateOf(false)
    }
    val  confirmPasswordVisibility = remember {
        mutableStateOf(false)
    }



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
                        text = "Sign up",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        /*Name Filed*/
                        TextField(

                            value = nameVal.value,
                            onValueChange = {nameVal.value = it},
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email
                            ),
                            placeholder = { Text(text="Name", color= Color.Black) },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth(0.8f),

                            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black,
                                textColor = Color.Black
                            )

                        )
                        Spacer(modifier = Modifier.padding(7.dp))


                        /*StudntNumber Filed*/
                        TextField(
                            value = studentnumberVal.value,
                            onValueChange = {studentnumberVal.value = it},
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            placeholder = { Text(text="StudentNumber", color= Color.Black) },
                            //  singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black,
                                textColor = Color.Black
                            )

                        )
                        Spacer(modifier = Modifier.padding(7.dp))
                        TextField(
                            value = phonenumberVal.value,
                            onValueChange = {phonenumberVal.value = it},
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            placeholder = { Text(text="PhoneNumber", color= Color.Black) },
                            //  singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black,
                                textColor = Color.Black
                            )

                        )
                        /*password filed*/
                        TextField(
                            value = passwordVal.value,
                            onValueChange = {passwordVal.value = it},
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password
                            ),
                            placeholder = { Text(text="password ", color= Color.Black) },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black,
                                textColor = Color.Black
                            ),
                            trailingIcon = {
                                IconButton(onClick = {
                                    passwordVisibility.value = !passwordVisibility.value
                                }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_baseline_visibility_24),
                                        contentDescription = "password",
                                        tint = if(passwordVisibility.value) Purple500 else Color.Gray
                                    )
                                }
                            },
                            visualTransformation = if(passwordVisibility.value) VisualTransformation.None
                            else
                                PasswordVisualTransformation(),

                            )
                        Spacer(modifier = Modifier.padding(7.dp))

                        /*confirm password filed*/
                        TextField(
                            value = confirmPasswordVal.value,
                            onValueChange = {confirmPasswordVal.value = it},
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password
                            ),
                            placeholder = { Text(text="ConfirmPassword ", color= Color.Black) },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black,
                                textColor = Color.Black
                            ),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                                    }) {
                                    Icon(painter = painterResource(id = R.drawable.ic_baseline_visibility_24),
                                        contentDescription = "password Eye",
                                        tint = if(confirmPasswordVisibility.value) Purple500 else Color.Gray
                                    )
                                }
                            },
                            visualTransformation = if(confirmPasswordVisibility.value) VisualTransformation.None
                            else
                                PasswordVisualTransformation(),

                            )
                        Spacer(modifier = Modifier.padding(7.dp))

                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF177E89)),
                            onClick = {
                                when{
                                    nameVal.value.isEmpty()->{
                                        Toast.makeText(context,"Please Enter Name", Toast.LENGTH_LONG).show()
                                    }
                                    studentnumberVal.value.isEmpty()->{
                                        Toast.makeText(context,"Please Enter Student Number", Toast.LENGTH_LONG).show()
                                    }
                                    passwordVal.value.isEmpty()->{
                                        Toast.makeText(context,"Please Enter Password", Toast.LENGTH_LONG).show()
                                    }
                                    confirmPasswordVal.value.isEmpty()->{
                                        Toast.makeText(context,"Please Enter ConfirmPassword", Toast.LENGTH_LONG).show()
                                    }
                                    else -> {
                                        navController.navigate("home_page")

                                        Toast.makeText(context,"Sign in Successfully",Toast.LENGTH_LONG).show()

                                    }
                                }

                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {
                            Text(
                                text = "Sign up",
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

