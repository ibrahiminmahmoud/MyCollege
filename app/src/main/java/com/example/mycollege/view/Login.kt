package com.example.mycollege.view

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.ui.theme.Purple500
import com.example.mycollege.view.home.cairo

@Composable
fun LoginPage(navController:NavController){


    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val emailVal = remember {
        mutableStateOf("")
    }
//    val setnum1 = remember {
//        mutableStateOf("16-bt002")
//    }
    val passwordVal = remember {
        mutableStateOf("")
    }
    val passwordVisibility = remember {
        mutableStateOf(false)
    }

    val setnum= "16-bt001"
    val setnum1= "16-bt002"
    val pass="123"
    val icon = if(passwordVisibility.value)
       painterResource(id = R.drawable.ic_baseline_remove_red_eye_24)
    else
        painterResource(id = R.drawable.ic_baseline_visibility_off_24)
    Scaffold(modifier = Modifier.fillMaxHeight(),scaffoldState = scaffoldState) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
        LazyColumn(
            modifier = Modifier
                .background(color = Color(0xFFECF0F0))
                .fillMaxHeight()
                .padding(17.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        )
        {
            items(1) {
                Box(
                    modifier = Modifier
                        .padding(all = 10.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        modifier = Modifier
                            .width(550.dp)
                            .height(340.dp),
                        painter = painterResource(R.drawable.mypro),
                        contentDescription = "تسجيل الدخول",
                        contentScale = ContentScale.Fit,


                        )
                }
                Spacer(modifier = Modifier.padding(10.dp))

            }
            items(1) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Text(
                        text = "تسجيل الدخول",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontFamily = cairo,
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
            }
            items(1) {
//
                //Email Filed
                TextField(
                    value = emailVal.value,
                    textStyle = TextStyle(textDirection = TextDirection.Ltr),
                    onValueChange = { emailVal.value = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text

                    ),
                    label = {
                        Text(
                            text = "رقم الجلوس",
                            color = Color.Black,
                            fontFamily = cairo,
                        )
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f),

//                    horizontalAlignment = Alignment.CenterHorizontally,

                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Black,
                        textColor = Color.Black
                    )

                )

                Spacer(modifier = Modifier.padding(5.dp))

            }
            items(1) {

                TextField(
                    value = passwordVal.value,
                    textStyle = TextStyle(textDirection = TextDirection.Ltr),

                    onValueChange = { passwordVal.value = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    label = {
                        Text(
                            text = "كلمة السر",
                            color = Color.Black,
                            fontFamily = cairo,
                        )
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Black,
                        textColor = Color.Black
                    ),
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Icon(
                                painter = icon,
                                contentDescription = "password",
                                tint = if (passwordVisibility.value) Purple500 else Color.Gray
                            )
                        }
                    },
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                    else
                        PasswordVisualTransformation(),

                    )

                Spacer(modifier = Modifier.padding(10.dp))
            }
            items(1) {
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFF177E89)),
                    onClick = {
                        when {
                            passwordVal.value.isEmpty() && emailVal.value.isEmpty() -> {
                                Toast.makeText(
                                    context,
                                    "ادخل كلمة السر ورقم الجلوس",
                                    Toast.LENGTH_LONG
                                ).show()
                            }

                            emailVal.value.isEmpty() -> {
                                Toast.makeText(context, "رجاء ادخل رقم الجلوس", Toast.LENGTH_LONG)
                                    .show()
                            }

                            passwordVal.value.isEmpty() -> {
                                Toast.makeText(context, "ادخل كلمة السر", Toast.LENGTH_LONG).show()
                            }

                            else -> {
                                when{

                                    emailVal.value == setnum && passwordVal.value == pass ->{
                                        navController.navigate("home_page")
                                        Toast.makeText(
                                            context,
                                            "Sign in Successfully",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                    emailVal.value == setnum1 && passwordVal.value == pass ->{
                                        navController.navigate("home_page")
                                        Toast.makeText(
                                            context,
                                            "Sign in Successfully",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }

                                }

                                if (emailVal.value == setnum && passwordVal.value == pass) {
                                    navController.navigate("home_page")
                                    Toast.makeText(
                                        context,
                                        "Sign in Successfully",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                                else if (emailVal.value != setnum) {
                                    Toast.makeText(
                                        context,
                                        "انت غير مسجل في النطام",
                                        Toast.LENGTH_LONG
                                    ).show()
                                } else if (passwordVal.value != pass) {
                                    Toast.makeText(
                                        context,
                                        "كلمة السر غير صحيحه ",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }

                        }


                    },
                    modifier = Modifier.fillMaxWidth(0.8f)

                ) {
                    Text(
                        text = "تسجيل دخول",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = cairo
                    )
                }


                Spacer(modifier = Modifier.padding(10.dp))
            }
            items(1) {
                Text(
                    text = "انشاء حساب",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = cairo,
                    modifier = Modifier.clickable { navController.navigate("register_page") }

                )
                Spacer(modifier = Modifier.padding(40.dp))
            }
            items(1) {
                Text(
                    text = "   ",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = cairo,
                    modifier = Modifier.clickable { navController.navigate("register_page") }

                )
                Spacer(modifier = Modifier.padding(40.dp))
            }
            items(1) {
                Text(
                    text = "   ",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = cairo,
                    modifier = Modifier.clickable { navController.navigate("register_page") }

                )
                Spacer(modifier = Modifier.padding(40.dp))
            }


        }
    }
    }


//               Scaffold(modifier = Modifier.fillMaxHeight(),scaffoldState = scaffoldState) {
//                       paddingValues ->
//                   Box(modifier = Modifier.padding(paddingValues))



//password filed





