package com.example.jetpackcompose

import android.accounts.AuthenticatorDescription
import android.content.Context
import android.icu.text.CaseMap.Title
import android.media.Image
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.compose.material.ButtonElevation as ButtonElevation1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme(darkTheme = false) {
                ProfileScreen()
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
            .background(color = Color.White) //"#0b0a25".color) //dark blue
            .fillMaxHeight()
    ) {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(color = Color.White)//"#0b0a25".color) //dark blue


        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                //.border(width=2.dp,color="#8bb2dd".color)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black,
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
                    TopAppbarProfile(context = LocalContext.current.applicationContext)
                }
            }

            ProfileImage()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 4.dp)
                    .shadow(5.dp, shape = RoundedCornerShape(5.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                "#e0ffff".color,
                                Color.Transparent
                            )
                        )
                    )
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(

                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = null,tint= Color.Black)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.Black,
                        focusedBorderColor = Color.Red,
                        unfocusedBorderColor = "#185a9d".color
                    ),
                    value = username1.value,
                    onValueChange = {
                        username1.value = it
                    },
                    label = {
                        Text("Name", color = Color.Black)
                    },
                    placeholder = {
                        Text("Enter Name",color= "#185a9d".color )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    //.border(width= 2.dp,color="#fffa06".color)//yellow
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 4.dp)
                    .shadow(5.dp, shape = RoundedCornerShape(5.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                "#e0ffff".color,
                                Color.Transparent
                            )
                        )
                    )
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Face, contentDescription = null,tint= Color.Black)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.Black,
                        focusedBorderColor = Color.Red,
                        unfocusedBorderColor = "#185a9d".color
                    ),
                    value = Age1.value,
                    onValueChange = {
                        Age1.value = it
                    },
                    label = {
                        Text("Age", color = Color.Black)
                    },
                    placeholder = {
                        Text("Enter Age (eg. 18)",color= "#185a9d".color)
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
                    .shadow(5.dp, shape = RoundedCornerShape(5.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                "#e0ffff".color,
                                Color.Transparent
                            )
                        )
                    )
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Call, contentDescription = null,tint= Color.Black)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.Black,
                        focusedBorderColor = Color.Red,
                        unfocusedBorderColor = "#185a9d".color
                    ),
                    value = Mob_No.value,
                    onValueChange = {
                        Mob_No.value = it
                    },
                    label = {
                        Text("Mobile No.", color = Color.Black)
                    },
                    placeholder = {
                        Text("xxxxxxxxx",color= "#185a9d".color)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    //.border(width= 2.dp,color="#fffa06".color)//yellow
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 4.dp)
                    .shadow(5.dp, shape = RoundedCornerShape(5.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                "#e0ffff".color,
                                Color.Transparent
                            )
                        )
                    )
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Email, contentDescription = null,tint= Color.Black)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.Black,
                        focusedBorderColor = Color.Red,
                        unfocusedBorderColor = "#185a9d".color
                    ),
                    value = E_mail.value,
                    onValueChange = {
                        E_mail.value = it
                    },
                    label = {
                        Text("E-mail ID", color = Color.Black)
                    },
                    placeholder = {
                        Text("abc@gmail.com",color= "#185a9d".color)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    //.border(width= 2.dp,color="#fffa06".color)//yellow
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 4.dp)
                    .shadow(5.dp, shape = RoundedCornerShape(5.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                "#e0ffff".color,
                                Color.Transparent
                            )
                        )
                    )
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Info, contentDescription = null,tint= Color.Black)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.Black,
                        focusedBorderColor = Color.Red,
                        unfocusedBorderColor = "#185a9d".color
                    ),
                    value = About1.value,
                    onValueChange = {
                        About1.value = it
                    },
                    label = {
                        Text("Adress/ Institute Name", color = Color.Black, textAlign = TextAlign.Center)
                    },
                    placeholder = {
                        Text("Enter your Address or Institute Name",color= "#185a9d".color)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    //.border(width= 2.dp,color="#fffa06".color)//yellow
                )
            }
            Row(
                modifier= Modifier.padding(145.dp,10.dp)
            ) {
                GradientButton(text = "Save", textColor = Color.White, //"#ff8c00".color,
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
                            "#0b0a25".color,
                            "#0b0a25".color
                        )
                    ),
                ) {

                }
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
                        Color.Black,
                        Color.Transparent
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .border(3.dp, color = "#185a9d".color, shape = CircleShape)
                .padding(0.dp)
                .size(100.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color.Black,
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
                    "#0b0a25".color,
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
    get() = Color(android.graphics.Color.parseColor(this))


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
                "#185a9d".color,
                Color.Black
            )
        )
        Text(text = "Male", color = Color.Black, modifier = Modifier.padding(2.dp,16.dp))
        Checkbox(
            checked = checkedState2.value,
            modifier = Modifier.padding(5.dp),
            onCheckedChange = { checkedState2.value = it },
            colors= CheckboxDefaults.colors(
                "#185a9d".color,
                Color.Black
            )
        )
        Text(text = "Female", color = Color.Black, modifier = Modifier.padding(2.dp,16.dp))
        Checkbox(
            checked = checkedState3.value,
            modifier = Modifier.padding(5.dp),
            onCheckedChange = { checkedState3.value = it },
            colors= CheckboxDefaults.colors(
                "#185a9d".color,
                Color.Black
            )
        )
        Text(text = "Other", color = Color.Black, modifier = Modifier.padding(2.dp,16.dp))

    }
}
@Composable
fun TopAppbarProfile(context: Context) {
    TopAppBar(
        title = {
            Text(
                text = "Profile",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "Nav Button", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Go back",
                )
            }
        }
    )
}

