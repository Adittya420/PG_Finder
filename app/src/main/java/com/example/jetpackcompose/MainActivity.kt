package com.example.jetpackcompose

import android.content.Context
import android.graphics.Color.parseColor
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme() {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    val username1 = remember {
        mutableStateOf(value = "")
    }
    val Age1 = remember {
        mutableStateOf(value = "")
    }
    val Gender1 = remember {
        mutableStateOf(value = "")
    }
    val Mob_No = remember {
        mutableStateOf(value = "")
    }
    val E_mail = remember {
        mutableStateOf(value = "")
    }
    val About1 = remember {
        mutableStateOf(value = "")
    }

    val notification = rememberSaveable { mutableStateOf("") }
    if (notification.value.isNotEmpty()) {
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }


    Box(
        modifier = Modifier
            .background(color = "#0b0a25".color) //dark blue
            .fillMaxHeight()
    ) {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(color = "#0b0a25".color) //dark blue


        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                //.border(width=2.dp,color="#8bb2dd".color)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White,
                            Color.Transparent
                        )
                    )
                )
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = "#181852".color),//blue
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "   Cancel   ", color = Color.White, textAlign = TextAlign.Center,
                        modifier = Modifier
                            .clickable { notification.value = "Cancelled" }
                            .padding(8.dp, 9.dp, 0.dp, 8.dp)
                            .fillMaxHeight()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Cyan,
                                        "#181852".color,
                                        "#0b0a25".color
                                    )
                                )
                            )
                            )
                            //.background(color = "#ba160c".color)//orange red
                    Text(text = "     Save     ", color = Color.White,//"#ff8c00".color,
                        modifier = Modifier
                            .clickable { notification.value = "Profile updated" }
                            .padding(0.dp, 9.dp, 9.dp, 8.dp)
                            .fillMaxHeight()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Cyan,
                                        "#181852".color,
                                        "#0b0a25".color
                                    )
                                )
                            ))
                }
            }

            ProfileImage()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 4.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                "#0b0a25".color,
                                "#181852".color,
                                "#0b0a25".color
                            )
                        )
                    )
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(

                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = null,tint=Color.White)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.White,
                        focusedBorderColor = Green,
                        unfocusedBorderColor = Yellow),
                    value = username1.value,
                    onValueChange = {
                        username1.value = it
                    },
                    label = {
                        Text("Name", color = Color.White)
                    },
                    placeholder = {
                        Text("Enter Name",color= "#fffa06".color)
                    },
                    modifier = Modifier.fillMaxWidth(),
                        //.border(width= 2.dp,color="#fffa06".color)//yellow
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 4.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                "#0b0a25".color,
                                "#181852".color,
                                "#0b0a25".color
                            )
                        )
                    )
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Face, contentDescription = null,tint=Color.White)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.White,
                        focusedBorderColor = Green,
                        unfocusedBorderColor = Yellow),
                    value = Age1.value,
                    onValueChange = {
                        Age1.value = it
                    },
                    label = {
                        Text("Age", color = Color.White)
                    },
                    placeholder = {
                        Text("Enter Age (eg. 18)",color= "#fffa06".color)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    //.border(width= 2.dp,color="#fffa06".color)//yellow
                )
            }
            /*Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 4.dp)
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Star, contentDescription = null,tint=Color.White)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.White,
                        focusedBorderColor = Green,
                        unfocusedBorderColor = Yellow),
                    value = Gender1.value,
                    onValueChange = {
                        Gender1.value = it
                    },
                    label = {
                        Text("Gender", color = Color.White)
                    },
                    placeholder = {
                        Text("Male/ Female/ Other",color= "#fffa06".color)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    //.border(width= 2.dp,color="#fffa06".color)//yellow
                )
            }*/
            SimpleCheckboxComponent()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 4.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                "#0b0a25".color,
                                "#181852".color,
                                "#0b0a25".color
                            )
                        )
                    )
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Call, contentDescription = null,tint=Color.White)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.White,
                        focusedBorderColor = Green,
                        unfocusedBorderColor = Yellow),
                    value = Mob_No.value,
                    onValueChange = {
                        Mob_No.value = it
                    },
                    label = {
                        Text("Mobile No.", color = Color.White)
                    },
                    placeholder = {
                        Text("xxxxxxxxx",color= "#fffa06".color)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    //.border(width= 2.dp,color="#fffa06".color)//yellow
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 4.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                "#0b0a25".color,
                                "#181852".color,
                                "#0b0a25".color
                            )
                        )
                    )
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Email, contentDescription = null,tint=Color.White)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.White,
                        focusedBorderColor = Green,
                        unfocusedBorderColor = Yellow),
                    value = E_mail.value,
                    onValueChange = {
                        E_mail.value = it
                    },
                    label = {
                        Text("E-mail ID", color = Color.White)
                    },
                    placeholder = {
                        Text("abc@gmail.com",color= "#fffa06".color)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    //.border(width= 2.dp,color="#fffa06".color)//yellow
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 4.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                "#0b0a25".color,
                                "#181852".color,
                                "#0b0a25".color
                            )
                        )
                    )
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Info, contentDescription = null,tint=Color.White)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.White,
                        focusedBorderColor = Green,
                        unfocusedBorderColor = Yellow),
                    value = About1.value,
                    onValueChange = {
                        About1.value = it
                    },
                    label = {
                        Text("Adress/ Institute Name", color = Color.White, textAlign = TextAlign.Center)
                    },
                    placeholder = {
                        Text("Enter your Address or Institute Name",color= "#fffa06".color)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    //.border(width= 2.dp,color="#fffa06".color)//yellow
                )
            }
        }
    }
}



@Composable
fun ProfileImage() {
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberImagePainter(
        if (imageUri.value.isEmpty())
            R.drawable.ic_user
        else
            imageUri.value
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { imageUri.value = it.toString() }
    }

    Column(
        modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.White,
                        Color.Transparent
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .border(3.dp,color=Color.Yellow,shape= CircleShape)
                .padding(0.dp)
                .size(100.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color.White,
                            Color.Transparent
                        )
                    )
                )
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop
            )
        }
        GradientButton(text = "Change Profile Picture", textColor = Color.White, //"#ff8c00".color,
            gradient = Brush.verticalGradient(
                colors = listOf(
                    Color.Cyan,
                    "#00d3e0".color,
                    "#00a9b3".color,
                    "#00a9b3".color,
                    "#43cea2".color,
                    "#43cea2".color,
                    "#185a9d".color,
                    "#185a9d".color,
                    "#0b0a25".color
                )
            ),
        ) {

        }
        /*val context= LocalContext.current
        Button(onClick = { Toast.makeText(context,"Click on the Icon to change the Profile Photo",Toast.LENGTH_LONG).show() },
            modifier = Modifier.shadow(elevation = 15.dp, shape = RoundedCornerShape(15.dp)),
            shape= RoundedCornerShape(size= 10.dp),

                ) {
            Text("Change Profile Picture",color= "#ff8c00".color)
        }*/
        //Text(text = "Change profile picture", textAlign = TextAlign.Center, color = "#ff8c00".color // orange

    }
}
val String.color
    get() = Color(parseColor(this))


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme() {
        ProfileScreen()
    }
}
@Composable
fun SimpleCheckboxComponent() {
    val checkedState1 = remember { mutableStateOf(false) }
    val checkedState2 = remember { mutableStateOf(false) }
    val checkedState3 = remember { mutableStateOf(false) }
    Row {
            Checkbox(
                checked = checkedState1.value,
                modifier = Modifier.padding(5.dp),
                onCheckedChange = { checkedState1.value = it },
                colors= CheckboxDefaults.colors(
                    Color.Red,
                    Color.Cyan
                )
            )
            Text(text = "Male", color = Color.White, modifier = Modifier.padding(2.dp,16.dp))
            Checkbox(
                checked = checkedState2.value,
                modifier = Modifier.padding(5.dp),
                onCheckedChange = { checkedState2.value = it },
                colors= CheckboxDefaults.colors(
                    Color.Red,
                    Color.Cyan
                )
            )
            Text(text = "Female", color = Color.White, modifier = Modifier.padding(2.dp,16.dp))
            Checkbox(
                checked = checkedState3.value,
                modifier = Modifier.padding(5.dp),
                onCheckedChange = { checkedState3.value = it },
                colors= CheckboxDefaults.colors(
                    Color.Red,
                    Color.Cyan
                )
            )
            Text(text = "Other", color = Color.White, modifier = Modifier.padding(2.dp,16.dp))

    }
}


