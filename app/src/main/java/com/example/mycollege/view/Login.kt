package com.example.mycollege.view

import android.widget.Toast
import androidx.compose.foundation.*
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
    val email= "110108327"
    val pass="123"
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
                     contentDescription = "?????????? ????????????",
                     contentScale = ContentScale.Fit,


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
                           text = "?????????? ????????????",
                           fontSize = 20.sp,
                           fontWeight = FontWeight.Bold,
                           color = Color.Black,
                           fontFamily = cairo,
                       )

                      Spacer(modifier = Modifier.padding(10.dp))

                       Column(
                           modifier = Modifier
                               .verticalScroll(rememberScrollState()),
                           horizontalAlignment = Alignment.CenterHorizontally
                       ) {
      //Email Filed
                           TextField(
                               value = emailVal.value,
                               onValueChange = {emailVal.value = it},
                               keyboardOptions = KeyboardOptions(
                                   keyboardType = KeyboardType.Email
                               ),
                              label = { Text(
                                  text = "?????? ????????????",
                                  color = Color.Black,
                                  fontFamily = cairo,
                              )} ,
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
                               label = { Text(
                                   text = "???????? ????????",
                                   color = Color.Black,
                                   fontFamily = cairo,
                               )} ,
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
                               colors = ButtonDefaults.buttonColors(Color(0xFF177E89)),
                               onClick =  {
                                   when{
                                       emailVal.value.isEmpty()->{
                                           Toast.makeText(context,"???????? ???????? ?????? ????????????",Toast.LENGTH_LONG).show()
                                       }
                                       passwordVal.value.isEmpty()->{
                                           Toast.makeText(context,"???????? ???????? ????????",Toast.LENGTH_LONG).show()
                                       }
                                       else -> {
                                           if(emailVal.value == email && passwordVal.value == pass){
                                               navController.navigate("home_page")
                                               Toast.makeText(context,"Sign in Successfully",Toast.LENGTH_LONG).show()
                                           }else if(emailVal.value != email){
                                               Toast.makeText(context,"?????? ?????? ???????? ???? ",Toast.LENGTH_LONG).show()
                                           }else if(passwordVal.value != pass){
                                               Toast.makeText(context,"???????? ???????? ?????? ?????????? ",Toast.LENGTH_LONG).show()
                                           }



                                       }
                                   }

                               },
                               modifier = Modifier.fillMaxWidth(0.8f)

                           ) {
                               Text(
                                   text = "?????????? ????????",
                                   fontSize = 20.sp,
                                   color = Color.White,
                                   fontFamily = cairo,
                                   modifier = Modifier
                                       .clickable { navController.navigate("home_page") }


                               )
                           }
                           Spacer(modifier = Modifier.padding(10.dp))
                           Text(
                               text = "?????????? ????????",
                               fontSize = 12.sp,
                               color = Color.Black,
                               fontFamily = cairo,
                               modifier = Modifier.clickable { navController.navigate("register_page") }

                           )
                           Spacer(modifier = Modifier.padding(10.dp))

                       }
                   }
               }
            }
          }



  }
