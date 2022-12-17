package com.example.loginapp


import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.app.ActivityOptions
import android.os.Bundle
import android.view.View.inflate
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import com.example.loginapp.ui.theme.LoginAppTheme
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class Registerpage : ComponentActivity() {

    private val MyTypography = Typography(
        body2 = TextStyle(
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LoginAppTheme {
                Registerpage()
            }
        }
    }


    @SuppressLint("NotConstructor")
    @Composable
    fun Registerpage() {
        var database = FirebaseDatabase.getInstance().reference

        val focusManager2 = LocalFocusManager.current

        var name by remember {
            mutableStateOf("")
        }

        var number by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .background(Color.Unspecified)
                .fillMaxSize()
                .padding(bottom = 130.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.register_new),
                contentDescription = "Register Image",
                modifier = Modifier.size(200.dp)
            )
//        Image(painter = painterResource(id = R.drawable.pexels_img), contentDescription ="" ,
//        modifier = Modifier.fillMaxSize())


            MaterialTheme(typography = MyTypography) {
                Text(
                    text = "REGISTRATION",
                    style = MaterialTheme.typography.overline,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            MaterialTheme(typography = MyTypography) {
                Text(
                    text = "Please fill in the details to continue",
                    style = MaterialTheme.typography.overline,
                    color = Color.DarkGray,
                    fontStyle = FontStyle.Normal,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )


                Card(
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                    shape = MaterialTheme.shapes.large,
                    border = BorderStroke(1.dp, color = Color.Unspecified)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .background(color = Color.White)
                            .padding(all = 10.dp),
                    ) {
                        OutlinedTextField(value = name,
                            colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black),
                            onValueChange = { name = it },
                            label = {
                                Text(
                                    text = "Enter Name",
                                    color = Color.Black
                                )
                            } ,placeholder = {
                                Text(text = "",
                                    color = Color.DarkGray)
                            }, singleLine = true,
                            modifier = Modifier,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Done
                            ) ,keyboardActions = KeyboardActions(
                                    onNext = { focusManager2.moveFocus(FocusDirection.Down) }
                            ),
                        )

                        OutlinedTextField(value = number,shape =  MaterialTheme.shapes.medium,
                            colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black),
                            onValueChange = { number = it },
                            label = {
                                Text(
                                    text = "Enter Number",
                                    color = Color.Black
                                )
                            }, placeholder = {
                                Text(text = "",
                                    color = Color.DarkGray,
                                )
                            }, singleLine = true,
                            modifier = Modifier,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            )
                        )

                    }
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "CONTINUE",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 16.sp)
                }
            }
        }

    }
}


