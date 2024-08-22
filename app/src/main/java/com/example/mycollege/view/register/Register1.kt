package com.example.mycollege.view.register

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
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
fun Register1(navController: NavController) {
    val context = LocalContext.current
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
    val confirmPasswordVal = remember {
        mutableStateOf("")
    }
    val passwordVisibility = remember {
        mutableStateOf(false)
    }
    val confirmPasswordVisibility = remember {
        mutableStateOf(false)
    }

    Scaffold(modifier = Modifier.fillMaxHeight(), scaffoldState = scaffoldState) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .fillMaxHeight()
                .padding(17.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        )
        {
            items(1) {
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
                        text = "إنشاء حساب",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontFamily = cairo,
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
            }
            items(1){
                /*Name Filed*/
                TextField(

                    value = nameVal.value,
                    textStyle = TextStyle(textDirection = TextDirection.Rtl),

                    onValueChange = {nameVal.value = it},
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    label = {
                        Text(
                            text = "الاسم كامل",
                            color = Color.Black,
                            fontFamily = cairo,
                        )
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(0.8f),

                    colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black,
                        textColor = Color.Black
                    )

                )
                Spacer(modifier = Modifier.padding(7.dp))


                /*StudentNumber Filed*/
                TextField(
                    value = studentnumberVal.value,
                    textStyle = TextStyle(textDirection = TextDirection.Ltr),

                    onValueChange = {studentnumberVal.value = it},
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
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                    colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black,
                        textColor = Color.Black
                    )

                )
                Spacer(modifier = Modifier.padding(7.dp))

            }
            items(1){
                TextField(
                            value = phonenumberVal.value,
                            textStyle = TextStyle(textDirection = TextDirection.Ltr),

                            onValueChange = {phonenumberVal.value = it},
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            label = {
                                Text(
                                    text = "رقم الهاتف",
                                    color = Color.Black,
                                    fontFamily = cairo,
                                )
                            },
                            //  singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black,
                                textColor = Color.Black
                            )
                )
                Spacer(modifier = Modifier.padding(7.dp))

            }
            items(1){
                /*password filed*/
                TextField(
                    value = passwordVal.value,
                    textStyle = TextStyle(textDirection = TextDirection.Ltr),

                    onValueChange = {passwordVal.value = it},
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
                    textStyle = TextStyle(textDirection = TextDirection.Ltr),

                    onValueChange = {confirmPasswordVal.value = it},
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    label = {
                        Text(
                            text = "تأكد كلمة السر",
                            color = Color.Black,
                            fontFamily = cairo,
                        )
                    },
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

            }
            items(1){
                //
                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF177E89)),
                            onClick = {
                                when{
                                    nameVal.value.isEmpty()->{
                                        Toast.makeText(
                                            context,
                                            "Please Enter Name",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                    studentnumberVal.value.isEmpty()-> {
                                        Toast.makeText(context,"Please Enter Student Number", Toast.LENGTH_LONG).show()
                                    }
                                    passwordVal.value.isEmpty()->{
                                        Toast.makeText(context,"Please Enter Password", Toast.LENGTH_LONG).show()
                                    }
                                    confirmPasswordVal.value.isEmpty()->{
                                        Toast.makeText(context,"Please Enter ConfirmPassword", Toast.LENGTH_LONG).show()
                                    }
                                    else -> {
                                        when{
                                            studentnumberVal.value.matches(Regex("([0-9]){2}(-)?(B)?(T)([0-9]){3}$"))->{
                                                navController.navigate("home_page")
                                                Toast.makeText(context,"Sign up Successfully", Toast.LENGTH_LONG).show()
                                            }
                                            studentnumberVal.value.matches(Regex("([0-9]){2}(-)?(b)?(t)([0-9]){3}$"))->{
                                                navController.navigate("home_page")
                                                Toast.makeText(context,"Sign up Successfully", Toast.LENGTH_LONG).show()
                                            }
                                            else ->{
                                                Toast.makeText(context,"انت بتقراء دبلوم يا اصلي", Toast.LENGTH_LONG).show()
                                            }
                                        }

                                    }
                                }

                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {
                            Text(
                                text = "انهاء",
                                fontSize = 20.sp,
                                color = Color(0xFFF8FCF8)
                            )
                        }
                Spacer(modifier = Modifier.padding(7.dp))

            }
            items(1) {
                Text(
                    text = "   ",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = cairo,

                )
                Spacer(modifier = Modifier.padding(10.dp))
            }
            items(1) {
                Text(
                    text = "   ",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = cairo,

                )
                Spacer(modifier = Modifier.padding(10.dp))
            }
            items(1) {
                Text(
                    text = "   ",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = cairo,

                )
                Spacer(modifier = Modifier.padding(10.dp))
            }
            items(1) {
                Text(
                    text = "   ",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = cairo,

                )
                Spacer(modifier = Modifier.padding(10.dp))
            }
            items(1) {
                Text(
                    text = "   ",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = cairo,

                )
                Spacer(modifier = Modifier.padding(0.dp))
            }




        }

    }
}


