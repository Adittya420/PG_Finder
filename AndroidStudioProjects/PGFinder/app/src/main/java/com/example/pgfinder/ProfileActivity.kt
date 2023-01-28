package com.example.pgfinder

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pgfinder.sealed.DataState
import com.example.pgfinder.ui.theme.PGFinderTheme
import com.example.pgfinder.ui.theme.Poppins
import com.example.pgfinder.ui.theme.PrimaryColor

class ProfileActivity : ComponentActivity() {
    lateinit var viewModel: AutherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var viewModel = ViewModelProvider(this).get(AutherViewModel::class.java)
            PGFinderTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}


@Composable
fun viewProf(
    viewModel: AutherViewModel,
    onClick: () -> Unit,
){
    when(val results = viewModel.response.value){
        is DataState.Loading ->{
            Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center) {
                CircularProgressIndicator()

            }
        }
        is DataState.Success ->{
           showLazyList(results.data)
        }
        is DataState.Failure ->{
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center) {
                Text(text = results.message,
                fontSize = 15.sp)

            }
        }
        else ->{
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center) {
                Text(text = "Error! Loading Data",
                    fontSize = 15.sp)

            }
        }
        

    }
    Button(
        onClick = {
            onClick()
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

        Text(text = "m", fontFamily = Poppins)
    }
}
@Composable
fun showLazyList(Authers : MutableList<Auther>) {
    LazyColumn{
        items(Authers){
             Auther1 -> {
               cardItem(Auther1)
        }
        }

    }
}
@Composable
 fun cardItem(Auther: Auther){
     Card(modifier = Modifier
         .fillMaxWidth()
         .height(150.dp)
         .padding(10.dp)) {
         Box(modifier = Modifier.fillMaxWidth()) {
             Text(text = Auther.name1!!)
         }
     }
}


@Composable
fun EditProfileScreen(viewModel:AutherViewModel) {

    //    val database = Firebase.database
//    val myRef = database.getReference()
//    val Context = LocalContext.current
    fun mToast(context: Context){
        Toast.makeText(context, "Field cannot be empty", Toast.LENGTH_LONG).show()
    }
    val mContext = LocalContext.current


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = Color.White,
                contentColor = PrimaryColor,

                )
        },

        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Text(
                    text = "Edit Profile", fontWeight = FontWeight.Bold, fontSize = 26.sp,
                    modifier = Modifier.padding(7.dp, 45.dp)
                )

                var Name1 by remember { mutableStateOf(value = "") }
                var MOb1 by remember { mutableStateOf(value = "") }
                var AGE by remember { mutableStateOf(value = "") }
                var INSTitute by remember { mutableStateOf(value = "") }
                var EMAil by remember { mutableStateOf(value = "") }
                var text by remember { mutableStateOf(value = "") }
                val maxNumber = 10

                OutlinedTextField(
                    modifier = Modifier.padding(7.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person, contentDescription = "emailIcon",
                            tint = PrimaryColor
                        )
                    },
                    value = Name1,
                    label = { Text(text = "Name") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    onValueChange = {
                        Name1 = it
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = PrimaryColor,
                        textColor = PrimaryColor
                    )
                )
                OutlinedTextField(
                    modifier = Modifier.padding(7.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Phone, contentDescription = "emailIcon",
                            tint = PrimaryColor
                        )
                    },

                    value = MOb1,
                    label = { Text(text = "Mobile") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    ),
                    onValueChange = {
//                 if(mob <= maxNumber){
//                     mob = it
//                 }
                        MOb1 = it
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = PrimaryColor,
                        textColor = PrimaryColor
                    )
                )
                OutlinedTextField(
                    modifier = Modifier.padding(7.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email, contentDescription = "emailIcon",
                            tint = PrimaryColor
                        )
                    },
                    value = EMAil,
                    label = { Text(text = "email") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    onValueChange = {
                        EMAil = it
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = PrimaryColor,
                        textColor = PrimaryColor
                    )
                )
                OutlinedTextField(
                    modifier = Modifier.padding(7.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Home, contentDescription = "emailIcon",
                            tint = PrimaryColor
                        )
                    },
                    value = INSTitute,
                    label = { Text(text = "Institute") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    onValueChange = {
                        INSTitute = it
                    },
                    maxLines = 2,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = PrimaryColor,
                        textColor = PrimaryColor
                    )
                )
                OutlinedTextField(
                    modifier = Modifier.padding(7.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Face, contentDescription = "emailIcon",
                            tint = PrimaryColor
                        )
                    },
                    value = AGE,
                    label = { Text(text = "Age") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    onValueChange = {
                        AGE = it
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = PrimaryColor,
                        textColor = PrimaryColor
                    )
                )
                Button(
                    onClick = {
                        val name = Name1.toString().trim()
                        val age = AGE
                        val mobNumber = MOb1
                        val email = EMAil.trim()
                        val institute = INSTitute

                        if (name.toString().isEmpty()) {
                            mToast(mContext)
                        }
                        if (age.equals(null)) {
                            mToast(mContext)
                        }
                        if (mobNumber.equals(null)) {
                            mToast(mContext)
                        }
                        if (email.toString().isEmpty()) {
                            mToast(mContext)
                        }
                        if (institute.toString().isEmpty()) {
                            mToast(mContext)
                        }

                        val author = Auther()
                        author.name1 = name.toString()
                        author.age = age
                        author.mobNumber = mobNumber
                        author.institute = institute
                        author.email = email

                        viewModel.addAuther(author)

//                        if(viewModel.result == null){
//                            Toast.makeText( mContext, "Success",Toast.LENGTH_LONG).show()
//                        }

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 27.dp)
                        .padding(top = 20.dp)
                        .padding(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = PrimaryColor,
                        contentColor = Color.Black
                    ),
                    contentPadding = PaddingValues(vertical = 14.dp)
                ) {

                    Text(text = "Save")
                }

            }
        }
    )
}
//
//@Composable
//fun ScaffoldWithTopBar() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "")
//                },
//                navigationIcon = {
//                    IconButton(onClick = {}) {
//                        Icon(Icons.Filled.ArrowBack, "backIcon")
//                    }
//                },
//                backgroundColor = Color.White,
//                contentColor = PrimaryColor,
//
//                )
//        },
//        content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Top
//            ) {
//
//                Text(
//                    text = "Edit Profile", fontWeight = FontWeight.Bold, fontSize = 26.sp,
//                    modifier = Modifier.padding(7.dp, 45.dp)
//                )
//                var name by remember { mutableStateOf(TextFieldValue("")) }
//                var mob by remember { mutableStateOf(TextFieldValue("")) }
//                var age by remember { mutableStateOf(TextFieldValue("")) }
//                var insitute by remember { mutableStateOf(TextFieldValue("")) }
//                var email by remember { mutableStateOf(TextFieldValue("")) }
//                var text by remember { mutableStateOf(TextFieldValue("")) }
//                val maxNumber = 10
//
//                OutlinedTextField(
//                    modifier = Modifier.padding(7.dp),
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Default.Person, contentDescription = "emailIcon",
//                            tint = PrimaryColor
//                        )
//                    },
//                    value = name,
//                    label = { Text(text = "Name") },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Text
//                    ),
//                    onValueChange = {
//                        name = it
//                    },
//                    singleLine = true,
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        unfocusedBorderColor = PrimaryColor,
//                        textColor = PrimaryColor
//                    )
//                )
//                OutlinedTextField(
//                    modifier = Modifier.padding(7.dp),
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Default.Phone, contentDescription = "emailIcon",
//                            tint = PrimaryColor
//                        )
//                    },
//
//                    value = mob,
//                    label = { Text(text = "Mobile") },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Phone
//                    ),
//                    onValueChange = {
////                 if(mob <= maxNumber){
////                     mob = it
////                 }
//                        mob = it
//                    },
//                    singleLine = true,
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        unfocusedBorderColor = PrimaryColor,
//                        textColor = PrimaryColor
//                    )
//                )
//                OutlinedTextField(
//                    modifier = Modifier.padding(7.dp),
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Default.Email, contentDescription = "emailIcon",
//                            tint = PrimaryColor
//                        )
//                    },
//                    value = email,
//                    label = { Text(text = "email") },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Email
//                    ),
//                    onValueChange = {
//                        email = it
//                    },
//                    singleLine = true,
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        unfocusedBorderColor = PrimaryColor,
//                        textColor = PrimaryColor
//                    )
//                )
//                OutlinedTextField(
//                    modifier = Modifier.padding(7.dp),
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Default.Home, contentDescription = "emailIcon",
//                            tint = PrimaryColor
//                        )
//                    },
//                    value = insitute,
//                    label = { Text(text = "Institute") },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Text
//                    ),
//                    onValueChange = {
//                        insitute = it
//                    },
//                    maxLines = 2,
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        unfocusedBorderColor = PrimaryColor,
//                        textColor = PrimaryColor
//                    )
//                )
//                OutlinedTextField(
//                    modifier = Modifier.padding(7.dp),
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Default.Face, contentDescription = "emailIcon",
//                            tint = PrimaryColor
//                        )
//                    },
//                    value = age,
//                    label = { Text(text = "Age") },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Number
//                    ),
//                    onValueChange = {
//                        age = it
//                    },
//                    singleLine = true,
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        unfocusedBorderColor = PrimaryColor,
//                        textColor = PrimaryColor
//                    )
//                )
//                Button(
//                    onClick = {
//
//                    },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 27.dp)
//                        .padding(top = 20.dp)
//                        .padding(12.dp),
//                    colors = ButtonDefaults.buttonColors(
//                        backgroundColor = PrimaryColor,
//                        contentColor = Color.Black
//                    ),
//                    contentPadding = PaddingValues(vertical = 14.dp)
//                ) {
//
//                    Text(text = "Save")
//                }
//            }
//        }
//
//    )
//}
//
