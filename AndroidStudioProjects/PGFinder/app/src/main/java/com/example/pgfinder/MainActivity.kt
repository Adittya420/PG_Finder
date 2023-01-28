package com.example.pgfinder

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.pgfinder.ui.theme.*
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


var Email : String = ""

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {
            PGFinderTheme {
                RootNavigationGraph(navController = rememberNavController())

            }
        }
    }

}
private lateinit var auth: FirebaseAuth
    @Composable
    fun LoginScreen(
        onLoginClick: () -> Unit,
//        onLoginClick: () -> Unit,
        onSignupClick: () -> Unit
    ) {
        auth = Firebase.auth
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isPasswordOpen by remember { mutableStateOf(false) }

        val isEmailValid by derivedStateOf {
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        val isPasswordValid by derivedStateOf {
            password.length > 7
        }

        Box(contentAlignment = Alignment.TopCenter) {
            Image(
                painter = painterResource(id = R.drawable.login_illustration),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
            )
        }
        Box(contentAlignment = Alignment.BottomCenter) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "WELCOME TO PG Finder",
                    fontSize = 28.sp,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .padding(top = 300.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontFamily = ReemKufi
                )

                Button(
                    onClick = {
                        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
                        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.


                        // Build a GoogleSignInClient with the options specified by gso.


                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White
                    ),
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(26.dp)
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "Continue with Google", color = PrimaryColor, fontSize = 16.sp)
                    }
                }


                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    backgroundColor = Color.White,
                    elevation = 0.dp,
                    shape = BottomBoxShape.medium
                ) {

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        val Context = LocalContext.current
                        Text(
                            text = "Log In with Email",
                            color = LightTextColor,
                            fontFamily = Poppins,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(top = 16.dp)
                        )

                        OutlinedTextField(
                            value = email, onValueChange = {
                                email = it
                            },
                            label = {
                                Text(text = "Email Address", color = PrimaryColor)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .padding(top = 10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = PrimaryColor,
                                textColor = PrimaryColor

                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType =
                                KeyboardType.Email
                            ),
                            singleLine = true,
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_email),
                                    contentDescription = "",
                                    tint = PrimaryColor,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        )

                        OutlinedTextField(

                            value = password, onValueChange = {
                                password = it
                            },
                            label = {
                                Text(text = "Password", color = PrimaryColor)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .padding(top = 10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = PrimaryColor,
                                textColor = PrimaryColor
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            singleLine = true,
                            visualTransformation = if (!isPasswordOpen) PasswordVisualTransformation() else VisualTransformation.None,
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_password),
                                    contentDescription = "",
                                    tint = PrimaryColor,
                                    modifier = Modifier.size(24.dp)
                                )
                            },
                            trailingIcon = {
                                IconButton(onClick = { isPasswordOpen = !isPasswordOpen }) {
                                    if (!isPasswordOpen) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_eye_open),
                                            contentDescription = "",
                                            tint = PrimaryColor,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    } else {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_eye_close),
                                            contentDescription = "",
                                            tint = PrimaryColor,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                }
                            }
                        )

                        Button(
                            onClick = {
                                if(isEmailValid && isPasswordValid) {
//
                                    auth.signInWithEmailAndPassword(email, password)
                                        .addOnCompleteListener {
                                            if (it.isSuccessful) {
                                                Email = email
                                                onLoginClick()
                                                Toast.makeText(
                                                    Context,
                                                    "SUCCESS",
                                                    Toast.LENGTH_LONG
                                                ).show()
//                    Toast.makeText( this,"The user has succesfully logged in", Toast.LENGTH_SHORT).show()
                                            } else {
                                                Toast.makeText(
                                                    Context,
                                                    "Failed",
                                                    Toast.LENGTH_LONG
                                                ).show()
                                            }

                                        }
                                }else{
                                    Toast.makeText(
                                        Context ,
                                        "Enter the details properly",
                                        Toast.LENGTH_LONG
                                    ).show()

                                }

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .padding(top = 20.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = PrimaryColor,
                                contentColor = Color.White
                            ),
                            contentPadding = PaddingValues(vertical = 14.dp)
                        ) {

                            Text(text = "Login", fontFamily = Poppins)
                        }


                        TextButton(
                            onClick = {},
                            contentPadding = PaddingValues(vertical = 0.dp)
                        ) {
                            Text(
                                text = "Forgot Password ?",
                                color = LightTextColor,
                                fontFamily = Poppins,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 26.dp)
                            )
                        }
                        TextButton(
                            onClick = {
                                      onSignupClick()

                            },
                            contentPadding = PaddingValues(vertical = 0.dp)
                        ) {
                            Text(
                                text = "Don't have an Account ? Sign Up",
                                color = LightTextColor,
                                fontFamily = Poppins,
                                fontSize = 12.sp,
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }



