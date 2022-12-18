package com.example.jetpackcompose

import android.accounts.AuthenticatorDescription
import android.icu.text.CaseMap.Title
import android.media.Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.compose.material.ButtonElevation as ButtonElevation1

class my : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeTheme() {
                androidx.compose.material.Surface(color = MaterialTheme.colors.background) {
                    ImageCard()
                    LoginScreen()

                }

            }

        }
    }
    private fun logged(username : String,password: String){
        if(username == "chinmay" && password == "abc"){
            Toast.makeText(this,"Logged in successfully",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"wrong username or password ",Toast.LENGTH_SHORT).show()
        }
    }

    @Composable
    fun ImageCard(){
        Image(painterResource(id = R.drawable.def), contentDescription = null)

    }
    @Composable
    fun LoginScreen(){
        val username = remember {
            mutableStateOf(value= "")
        }
        val password = remember {
            mutableStateOf(value= "")
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(0.dp,25.dp,0.dp,0.dp)
            .padding(20.dp),
            verticalArrangement = Arrangement.Center) {
            Text(text = "Welcome To PG Finder....",color= Color.Blue, fontSize = 20.sp, fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace
            )
            Text(text = "Login to continue ...",color= Color.Blue, fontSize = 20.sp, fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
            OutlinedTextField(value = username.value,
                onValueChange = {
                    username.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Person , contentDescription = "Person")
                },
                label = {
                    Text("Username")
                },
                placeholder = {
                    Text("Enter Username")
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(value = password.value,
                onValueChange = {
                    password.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Lock , contentDescription = "Password")
                },
                label = {
                    Text("Password")
                },
                placeholder = {
                    Text("Enter Password")
                },
                modifier = Modifier.fillMaxWidth()
            )
            TextButton(onClick = { },modifier = Modifier.offset(170.dp) ) {
                Text("forgot password ?", color = Color.Black)
            }
            OutlinedButton(onClick = {logged(username.value,password.value) }, border = BorderStroke(1.dp, color = Color.Blue),
                modifier = Modifier.fillMaxWidth()) {
                Text("Login")
            }
        }
    }
}



