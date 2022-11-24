package com.example.loginapp

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.ui.theme.LoginAppTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    private val auth by lazy {
        Firebase.auth
    }
    companion object{
        val Tag : String = MainActivity :: class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppTheme {
                // A surface container using the 'background' color from the theme
                Login(auth)
            }
        }
    }

@Composable
fun Login(auth: FirebaseAuth){

    val focusManager = LocalFocusManager.current
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val isEmailValid by derivedStateOf {
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    val isPasswordValid by derivedStateOf {
        password.length > 7
    }

    val isPasswordVisible by remember {
        mutableStateOf(false)
    }


    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top) {
//        Image(painter = painterResource(id = R.drawable.pexels_img), contentDescription ="" ,
//        modifier = Modifier.fillMaxSize())
        
        Text(text = "Welcome back........",
        fontFamily = FontFamily.Companion.SansSerif,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Image(painter = painterResource(id = R.drawable.image_login),
            contentDescription = "Login Image",
            modifier = Modifier.size(200.dp)
            )


//        Text(text = "Hello Sir",
//            fontFamily = FontFamily.Companion.SansSerif,
//            fontWeight = FontWeight.Bold,
//            fontStyle = FontStyle.Italic,
//            fontSize = 30.sp,
//            modifier = Modifier.padding(top = 16.dp)
//        )
        Card(modifier = Modifier
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, color = Color.White)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(all = 10.dp),) {
               OutlinedTextField(value = email, onValueChange ={email = it},
               label = {
                   Text(text = "Email Address")
               },
               placeholder = {
                   Text(text = "example123@gmail.com")
               },
               singleLine = true,
                   modifier = Modifier,
                   keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                       imeAction = ImeAction.Next
                   ),
                   keyboardActions = KeyboardActions(
                       onNext = { focusManager.moveFocus(FocusDirection.Down) }
                   ),
                   isError = !isEmailValid,
                   trailingIcon = {
                       if (email.isNotBlank()){
                           IconButton(onClick = {email = ""}) {
                               Icon(  imageVector = Icons.Filled.Clear ,
                                   contentDescription = "Clear Email")

                           }
                       }
                   }
               )

                OutlinedTextField(value = password, onValueChange ={password = it},
                    label = {
                        Text(text = "Password")
                    },
                    placeholder = {
                        Text(text = "guyff5677")
                    },
                    singleLine = true,
                    modifier = Modifier,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    isError = !isPasswordValid,
                    trailingIcon = {
                            IconButton(onClick = {isPasswordVisible != isPasswordVisible}) {
                                Icon(  imageVector = if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = "Toggle Password Visibility")

                            }

                    },
                    visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
                )
//                Button(onClick = {
//                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
//                        if (it.isSuccessful) {
//                            Log.d(TAG, "The user has succesfully logged in")
//                        } else {
//                            Log.w(TAG, "Sorry! could'nt find the user", it.exception)
//                        }
//
//                    }
//                }) {
//                    Text(text = "Login",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 16.sp,)
//
//                }



            }

        }
        Row(horizontalArrangement = Arrangement.End,
        modifier = Modifier.fillMaxWidth()) {
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                color = Color.Black,
                fontStyle = FontStyle.Italic,
                    text = "Forgot Password ?",
                    modifier = Modifier.padding(end = 8.dp)

                )


            }

        }
        Button(onClick =  {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d(TAG, "The user has succesfully logged in")
                } else {
                    Log.w(TAG, "Sorry! could'nt find the user", it.exception)
                }

            }
        },
        enabled = isEmailValid && isPasswordValid,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan)) {
            Text(text = "Login",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp)


        }
}
}



}

@Preview
@Composable
fun prev(){

}

