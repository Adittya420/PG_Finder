package com.example.pgfinder

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pgfinder.ui.theme.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.childEvents
import com.google.firebase.ktx.Firebase


class Registration : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            PGFinderTheme {
//                RegisterScreen(Auther() ?
                }

            }
        }
    }

    private lateinit var auth: FirebaseAuth
    @Composable
    fun RegisterScreen(auther: Auther ,
    onAlreadyClick :()->Unit, onClick :()->Unit) {
        auth=Firebase.auth
        val db = FirebaseDatabase.getInstance().getReference("Users")

        var username by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var checkBoxOne by remember { mutableStateOf(true) }
        var checkBoxTwo by remember { mutableStateOf(true) }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_register_img),
                contentDescription = "",
                modifier = Modifier.size(160.dp)
            )

            Text(
                text = "CREATE YOUR ACCOUNT",
                textAlign = TextAlign.Center,
                fontFamily = Poppins,
                color = SecondaryColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,

                )

            TextField(
                value = username, onValueChange = { username = it },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = PrimaryColor,
                    backgroundColor = Color.White,
                    cursorColor = PrimaryColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = InputBoxShape.medium,
                singleLine = true,
                leadingIcon = {
                    Row(
                        modifier = Modifier.padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user), contentDescription = "",
                            tint = PrimaryColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(6.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(1.dp)
                                .height(24.dp)
                                .background(BackgroundColor)
                        )
                    }
                },
                placeholder = {
                    Text(text = "Username", color = PlaceholderColor)
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Poppins
                )
            )

            TextField(
                value = email, onValueChange = { email = it },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = PrimaryColor,
                    backgroundColor = Color.White,
                    cursorColor = PrimaryColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = InputBoxShape.medium,
                singleLine = true,
                leadingIcon = {
                    Row(
                        modifier = Modifier.padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_email_outline),
                            contentDescription = "",
                            tint = PrimaryColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(6.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(1.dp)
                                .height(24.dp)
                                .background(BackgroundColor)
                        )
                    }
                },
                placeholder = {
                    Text(text = "Email Address", color = PlaceholderColor)
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Poppins
                )
            )

            TextField(
                value = password, onValueChange = {
                    password = it },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = PrimaryColor,
                    backgroundColor = Color.White,
                    cursorColor = PrimaryColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = InputBoxShape.medium,
                singleLine = true,
                leadingIcon = {
                    Row(
                        modifier = Modifier.padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_lock), contentDescription = "",
                            tint = PrimaryColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(6.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(1.dp)
                                .height(24.dp)
                                .background(BackgroundColor)
                        )
                    }
                },
                placeholder = {
                    Text(text = "Password", color = PlaceholderColor)
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Poppins
                )
            )

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 40.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkBoxOne, onCheckedChange = { checkBoxOne = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = PrimaryColor,
                        uncheckedColor = SecondaryColor,
                        checkmarkColor = SecondaryColor
                    ),
                    modifier = Modifier.clip(shape = Shapes1.medium)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Log In with Email",
                    fontFamily = Poppins,
                    color = SecondaryColor,
                    fontSize = 12.sp
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 40.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Checkbox(
                    checked = checkBoxTwo, onCheckedChange = { checkBoxTwo = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = PrimaryColor,
                        uncheckedColor = SecondaryColor,
                        checkmarkColor = SecondaryColor
                    ),
                    modifier = Modifier.clip(shape = Shapes1.medium)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Email me about special pricing",
                    fontFamily = Poppins,
                    color = SecondaryColor,
                    fontSize = 12.sp
                )
            }
            val Context = LocalContext.current

            Button(
                onClick = {
//                   auther.id = db.setValue(username).addOnCompleteListener {
//                       if (it.isSuccessful){
//                           Toast.makeText(Context, "USernameAdded", Toast.LENGTH_LONG)
//                               .show()
//                       }else{
//                           Toast.makeText(Context, "Failed", Toast.LENGTH_LONG)
//                               .show()
//                       }
//                   }.toString()
                    if(!email.isEmpty()|| !password.isEmpty()||!username.isEmpty()){
                        auth.createUserWithEmailAndPassword(email.trim(), password.trim()).addOnCompleteListener {task->
                            run {
                                if (task.isSuccessful) {
                                    onClick()
                                    auther.username = dbAuther.setValue(username).toString()
                                    Toast.makeText(Context, "Success", Toast.LENGTH_LONG)
                                        .show()
                                } else {
//                                    val e = task.getException()
//                                    Log.e("Registration", "Failed Registration", e);
                                    Toast.makeText(
                                        Context,
                                        "Email Already Exist",
                                        Toast.LENGTH_SHORT
                                    ).show()
//                                    print("Hello Aditya")
                                }
                            }

                        }
                    }else{
                        Toast.makeText(Context,"All fields are required ",Toast.LENGTH_SHORT).show()
                    }


                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = PrimaryColor
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                contentPadding = PaddingValues(vertical = 14.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 2.dp
                ),
                shape = Shapes1.medium
            ) {
                Text(
                    text = "Sign Up with Email",
                    fontFamily = Poppins,
                    color = SecondaryColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            TextButton(onClick = {
                                 onAlreadyClick()
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = "Already have an account ? Sign In",
                    fontFamily = Poppins,
                    color = SecondaryColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }



