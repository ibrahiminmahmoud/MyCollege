package com.example.mycollege.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycollege.R
import com.example.mycollege.ui.theme.Purple500

@Composable
fun LoginPage(navController:NavController){


    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val emailVal = remember {
        mutableStateOf("")
    }
    val passwordVal = remember {
        mutableStateOf("")
    }
    val passwordVisibility = remember {
        mutableStateOf(false)
    }
   val icon = if(passwordVisibility.value)
       painterResource(id = R.drawable.ic_baseline_remove_red_eye_24)
    else
        painterResource(id = R.drawable.ic_baseline_visibility_off_24)

  Box(
      modifier = Modifier
          .fillMaxSize()
          .background(color = Color.White) , contentAlignment = Alignment.Center
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
                     .width(250.dp)
                     .height(190.dp),
                     painter =  painterResource(R.drawable.login),
                     contentDescription = "Login",
                     contentScale = ContentScale.Fit

                 )
             }
               //Spacer(modifier = Modifier.padding(5.dp))

               Scaffold(modifier = Modifier.fillMaxHeight(),scaffoldState = scaffoldState) {

                   Column(
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Center,
                       modifier = Modifier
                           .fillMaxWidth()
                           .background(Color.White)

                   ) {
                       Text(
                           text = "Sign In",
                           fontSize = 30.sp,
                           fontWeight = FontWeight.Bold,
                           color = Color.Black
                       )

                      Spacer(modifier = Modifier.padding(10.dp))

                       Column(
                           horizontalAlignment = Alignment.CenterHorizontally
                       ) {
      //Email Filed
                           TextField(
                               value = emailVal.value,
                               onValueChange = {emailVal.value = it},
                               keyboardOptions = KeyboardOptions(
                                   keyboardType = KeyboardType.Email
                               ),
                              label = { Text(text="Email Address", color= Color.Black)} ,
                               singleLine = true,
                               modifier = Modifier.fillMaxWidth(0.8f),
                               colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black,
                                   textColor = Color.Black
                               )

                           )
//password filed
                           TextField(
                               value = passwordVal.value,
                               onValueChange = {passwordVal.value = it},
                               keyboardOptions = KeyboardOptions(
                                   keyboardType = KeyboardType.Password
                               ),
                               label = { Text(text="Password ", color= Color.Black)} ,
                               singleLine = true,
                               modifier = Modifier.fillMaxWidth(0.8f),
                               colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black,
                                   textColor = Color.Black
                               ),
                               trailingIcon = {
                                   IconButton(onClick = {
                                       passwordVisibility.value = !passwordVisibility.value
                                   }) {
                                      Icon(painter = icon,
                                          contentDescription = "password",
                                          tint = if(passwordVisibility.value) Purple500 else Color.Gray
                                      )
                                   }
                               },
                               visualTransformation = if(passwordVisibility.value) VisualTransformation.None
                                               else
                                                   PasswordVisualTransformation(),

                           )
                           Spacer(modifier = Modifier.padding(10.dp))

                           Button(
                               colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF177E89)),
                               onClick =  {
                                   when{
                                       emailVal.value.isEmpty()->{
                                           Toast.makeText(context,"Please Enter Email",Toast.LENGTH_LONG).show()
                                       }
                                       passwordVal.value.isEmpty()->{
                                           Toast.makeText(context,"Please Enter Password",Toast.LENGTH_LONG).show()
                                       }
                                       else -> {
                                           navController.navigate("home_page")
                                           Toast.makeText(context,"Sign in Successfully",Toast.LENGTH_LONG).show()


                                       }
                                   }

                               },
                               modifier = Modifier.fillMaxWidth(0.8f)
                                   .height(50.dp)
                           ) {
                               Text(
                                   text = "Sign In",
                                   fontSize = 20.sp,
                                   color = Color(0xFFF8FCF8),
                                   modifier = Modifier
                                       .clickable { navController.navigate("home_page") }


                               )
                           }
                           Spacer(modifier = Modifier.padding(10.dp))
                           Text(
                               text = "Create an Account",
                               fontSize = 15.sp,
                               color = Color.Black,
                               modifier = Modifier.clickable { navController.navigate("register_page") }

                           )
                           Spacer(modifier = Modifier.padding(10.dp))

                       }
                   }
               }
            }
          }



  }
