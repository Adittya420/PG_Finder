package com.example.jetpackcompose.ui.theme

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.compose.rememberImagePainter
import com.example.jetpackcompose.R
import com.example.jetpackcompose.data.Auther

class AddAutherDialogFragment : AppCompatActivity() {

    lateinit var viewModel: AutherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_auther_dialog_fragment)
        var viewModel = ViewModelProvider(this).get(AutherViewModel::class.java)

    }

}



@Composable
fun ProfileScreen(viewModel: AutherViewModel) {

     fun mToast(context: Context){
        Toast.makeText(context, "Field cannot be empty", Toast.LENGTH_LONG).show()
    }
    val mContext = LocalContext.current
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
                    Text(text = "   Cancel   ", color = "#ff8c00".color, textAlign = TextAlign.Center,
                        modifier = Modifier
                            .clickable { notification.value = "Cancelled" }
                            .padding(8.dp, 9.dp, 0.dp, 8.dp)
                            .fillMaxHeight()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        "#181852".color,
                                        "#0b0a25".color
                                    )
                                )
                            )
                    )
                    //.background(color = "#ba160c".color)//orange red
//                    Text(text = "     Save     ", color = "#ff8c00".color,
//                        modifier = Modifier
//                            .clickable { notification.value = "Profile updated" }
//                            .padding(0.dp, 9.dp, 9.dp, 8.dp)
//                            .fillMaxHeight()
//                            .background(
//                                brush = Brush.verticalGradient(
//                                    colors = listOf(
//                                        "#181852".color,
//                                        "#0b0a25".color
//                                    )
//                                )
//                            ))
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues(),
                        onClick = {
                            val name = username1.toString().trim()
                            var age = Age1.value.toInt()
                            var mobNumber = Mob_No.value.toInt()
                            var email=E_mail.toString().trim()
                            var institute = About1.toString().trim()

                            if(name.isEmpty()){
                                mToast(mContext)
                            }
                            if(age.equals(null)){
                                mToast(mContext)
                            }
                            if(mobNumber.equals(null)){
                            mToast(mContext)
                        }
                            if(email.isEmpty()){
                            mToast(mContext)
                        }
                            if(institute.isEmpty()){
                            mToast(mContext)
                        }

                            val author = Auther()
                            author.name = name
                            author.age = age
                            author.mobNumber = mobNumber
                            author.institute = institute
                            author.email = email

                            viewModel.addAuther(author)





                        })
                    {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            contentAlignment = Alignment.TopEnd
                        ) {
                            Text(text = "Save", color = Color(0xFFBB86FC))
                        }
                    }
                }
            }

            ProfileImage()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 4.dp)
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(

                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = null,tint= Color.White)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.White,
                        focusedBorderColor = Color.Green,
                        unfocusedBorderColor = Color.Yellow
                    ),
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
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Face, contentDescription = null,tint= Color.White)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.White,
                        focusedBorderColor = Color.Green,
                        unfocusedBorderColor = Color.Yellow
                    ),
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
//            SimpleCheckboxComponent()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 4.dp)
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Call, contentDescription = null,tint= Color.White)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.White,
                        focusedBorderColor = Color.Green,
                        unfocusedBorderColor = Color.Yellow
                    ),
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
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Email, contentDescription = null,tint= Color.White)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.White,
                        focusedBorderColor = Color.Green,
                        unfocusedBorderColor = Color.Yellow
                    ),
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
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Info, contentDescription = null,tint= Color.White)
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor= Color.White,
                        focusedBorderColor = Color.Green,
                        unfocusedBorderColor = Color.Yellow
                    ),
                    value = About1.value,
                    onValueChange = {
                        About1.value = it
                    },
                    label = {
                        Text("Institute Name", color = Color.White, textAlign = TextAlign.Center)
                    },
                    placeholder = {
                        Text("Enter your Institute Name",color= "#fffa06".color)
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
                .padding(20.dp)
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
                    .wrapContentSize()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop
            )
        }
        Text(text = "Change profile picture", textAlign = TextAlign.Center, color = "#ff8c00".color // orange
        )
    }
}
val String.color
    get() = Color(android.graphics.Color.parseColor(this))


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    JetpackComposeTheme() {
//        ProfileScreen()
//    }
//}
//@Composable
//fun SimpleCheckboxComponent() {
//    val checkedState1 = remember { mutableStateOf(true) }
//    val checkedState2 = remember { mutableStateOf(true) }
//    val checkedState3 = remember { mutableStateOf(true) }
//    Row {
//        Checkbox(
//            checked = checkedState1.value,
//            modifier = Modifier.padding(5.dp),
//            onCheckedChange = { checkedState1.value = it },
//        )
//        Text(text = "Male", color = Color.White, modifier = Modifier.padding(2.dp))
//        Checkbox(
//            checked = checkedState2.value,
//            modifier = Modifier.padding(5.dp),
//            onCheckedChange = { checkedState2.value = it },
//        )
//        Text(text = "Female", color = Color.White, modifier = Modifier.padding(5.dp))
//        Checkbox(
//            checked = checkedState3.value,
//            modifier = Modifier.padding(5.dp),
//            onCheckedChange = { checkedState3.value = it },
//        )
//        Text(text = "Other", color = Color.White, modifier = Modifier.padding(5.dp))
//
//    }
//}
