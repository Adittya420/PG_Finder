package com.example.pgfinder

import android.graphics.Paint.Align
import android.location.Location
import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pgfinder.sealed.DataStatepg
import com.example.pgfinder.sealed.MessageGetState
import com.example.pgfinder.sealed.MessageState
import com.example.pgfinder.sealed.ParticularPGState
import com.example.pgfinder.ui.theme.*
import org.w3c.dom.Text

@Composable
fun ProfileScreen(viewModel: MessagesViewModel) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding()
            .background(PlaceholderColor)
    ) {

        val contexto = LocalContext.current
        var message by remember { mutableStateOf("") }
        val messageget = Messages()

        setMessage(MessagesViewModel())
        TextField(

            value = message, onValueChange = {
                message = it
            },
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 65.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = InputBoxShape.medium,
            singleLine = true,
            trailingIcon = {
                Row(
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {
                        if(message.isNotEmpty()) {
                            messageget.message = message
                            viewModel.addMessage(messageget)
                            message = ""
                        }else{
                            Toast.makeText(contexto , "message cannot be empty" , Toast.LENGTH_SHORT).show()
                        }

                    }) {
                        Icon(
                            imageVector = Icons.Default.Send, contentDescription = "",
                            tint = PrimaryColor,
                            modifier = Modifier.size(20.dp)
                        )
                    }
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
                Text(text = "Message", color = PlaceholderColor)
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )


    }
}

@Composable
fun cardItemMessage(eachmessage: Messages) {
    Column() {
        Surface(
            shape = RoundedCornerShape(40.dp),
            color = Color(0xFFDAE1E7),
            modifier = Modifier
                .height(100.dp)
                .padding(5.dp)
//                    .shadow(10.dp),
            //shadowElevation = 10.dp
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(2f),
                    verticalArrangement = Arrangement.Center
                ) {
//
                    Spacer(modifier = Modifier.height(1.dp))

                    if (eachmessage.message != null) {
                        if(user?.email == auth.currentUser?.email){
                        Text(
                            modifier = Modifier.width(350.dp),
                            text = "~${user?.email}",
                            fontSize = 8.sp,
                            textAlign = TextAlign.Right,
                            style = MaterialTheme.typography.overline,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                        }else{
                            Text(
                                text = "~${user?.email}",
                                fontSize = 8.sp,
                                textAlign = TextAlign.Left,
                                style = MaterialTheme.typography.overline,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black
                            )

                        }
                        Spacer(modifier = Modifier.height(1.dp))

                        Text(
                            text = eachmessage.message.toString(),
                            fontSize = 15.sp,
                            style = MaterialTheme.typography.overline,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )

                    }
                }


            }
        }
    }
}

@Composable
fun showLazyListMessage(data: MutableList<Messages>) {
    LazyColumn(
        Modifier
            .padding(),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(data) { eachmessage ->
            run {
                cardItemMessage(eachmessage)
            }
        }

    }
}

@Composable
fun setMessage(viewModel1: MessagesViewModel) {

    when (val results = viewModel1.responseM.value) {
        is MessageGetState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
//                LoadingAnimation()
//                    AnimatedShimmer()
            }
        }
        is MessageGetState.Success -> {
            showLazyListMessage(results.data)

        }
        is MessageGetState.Failure -> {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = results.message,
                    fontSize = 15.sp
                )

            }
        }
        else -> {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error! Loading Data",
                    fontSize = 15.sp
                )

            }
        }

    }
}
//


//
//    Box(
//        modifier = androidx.compose.ui.Modifier
//            .fillMaxSize()
//            .background(androidx.compose.ui.graphics.Color.Gray),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = "PROFILE",
//            fontSize = MaterialTheme.typography.h3.fontSize,
//            fontWeight = FontWeight.Bold,
//            color = androidx.compose.ui.graphics.Color.Blue
//        )
//    }
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                modifier = Modifier.background(Grey),
//                title = {
//                    Text(text = "Add Details")
//                },
//                navigationIcon = {
//                    IconButton(onClick = {}) {
//                        Icon(Icons.Filled.ArrowBack, "backIcon")
//                    }
//                },
//                backgroundColor = Grey,
//                contentColor = PrimaryColor,
//                )
//        },
//        content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize().padding(top = 30.dp).background(Grey),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Top
//            ) {
//                var pgname by remember { mutableStateOf(TextFieldValue("")) }
//                var location by remember { mutableStateOf(TextFieldValue("")) }
//                var rent by remember { mutableStateOf(TextFieldValue("")) }
//                var ownername by remember { mutableStateOf(TextFieldValue("")) }
//                var contact by remember { mutableStateOf(TextFieldValue("")) }
//                var vacancy by remember { mutableStateOf(TextFieldValue("")) }
//                var distance by remember { mutableStateOf(TextFieldValue("")) }
//                OutlinedTextField(
//                    modifier = Modifier.padding(7.dp),
//                    leadingIcon = {
//                        Icon(
//                            imageVector = Icons.Default.Home, contentDescription = "emailIcon",
//                            tint = PrimaryColor
//                        )
//                    },
//                    value =  pgname,
//                    label = { Text(text = "PG/Hostel Name",
//                    color = PrimaryColor) },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Text
//                    ),
//                    onValueChange = {
//                        pgname = it
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
//                            imageVector = Icons.Default.LocationOn, contentDescription = "emailIcon",
//                            tint = PrimaryColor
//                        )
//                    },
//                    value =  location,
//                    label = { Text(text = "Location",
//                        color = PrimaryColor) },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Text
//                    ),
//                    onValueChange = {
//                        location = it
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
//                            imageVector = Icons.Default.Send, contentDescription = "emailIcon",
//                            tint = PrimaryColor
//                        )
//                    },
//                    value =  rent,
//                    label = { Text(text = "Min. Rent",
//                        color = PrimaryColor) },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Number
//                    ),
//                    onValueChange = {
//                        rent = it
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
//                            imageVector = Icons.Default.Person, contentDescription = "emailIcon",
//                            tint = PrimaryColor
//                        )
//                    },
//                    value =  ownername,
//                    label = { Text(text = "Owner's Name",
//                        color = PrimaryColor) },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Text
//                    ),
//                    onValueChange = {
//                        ownername = it
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
//                    value =  contact,
//                    label = { Text(text = "Owner's Contact",
//                        color = PrimaryColor) },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Phone
//                    ),
//                    onValueChange = {
//                        contact = it
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
//                            imageVector = Icons.Default.AddCircle, contentDescription = "emailIcon",
//                            tint = PrimaryColor
//                        )
//                    },
//                    value =  vacancy,
//                    label = { Text(text = "Vacancy",
//                        color = PrimaryColor) },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Text
//                    ),
//                    onValueChange = {
//                        vacancy = it
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
//                            imageVector = Icons.Default.ArrowForward, contentDescription = "emailIcon",
//                            tint = PrimaryColor
//                        )
//                    },
//                    value =  distance,
//                    label = { Text(text = "Distance(From nearest college)",
//                        color = PrimaryColor) },
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Number
//                    ),
//                    onValueChange = {
//                        distance = it
//                    },
//                    singleLine = true,
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        unfocusedBorderColor = PrimaryColor,
//                        textColor = PrimaryColor
//                    )
//                )
//                Button(
//                    shape = InputBoxShape.small,
//                    onClick = {
//
//                    },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 50.dp)
//                        .padding(top = 20.dp)
//                        .padding(12.dp),
//                    colors = ButtonDefaults.buttonColors(
//                        backgroundColor = PrimaryColor,
//                        contentColor = Color.Black
//                    ),
//                    contentPadding = PaddingValues(vertical = 14.dp)
//                ) {
//
//                    Text(text = "Submit")
//                }
//            }
//        }
//    )

@Composable
fun ToCreate(onCreateclick:()->Unit){
    Column(modifier = Modifier.fillMaxSize().background(PlaceholderColor),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = { onCreateclick()}) {
            Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add PG", modifier = Modifier,
            tint = PrimaryColor)
        }
        Text(text = "Click Here to add PG" , color = SecondaryColor)
    }
}

@Composable
fun MyCreates(viewModel: PGviewModel) {

//    when (val results = viewModel.particularresponse.value) {
//        is ParticularPGState.Loading->{
//            CircularProgressIndicator()
//        }
//        is ParticularPGState.Success -> {
//
//            LazyPersonalPG(results
//                .data)
//
//        }
//        is ParticularPGState.Empty -> {
            Scaffold(
                topBar = {
                    TopAppBar(modifier = Modifier.fillMaxWidth(),
                        title = {
                            Text(text = "Add Details",
                            textAlign = TextAlign.Center)
                        },
//                        navigationIcon = {
//                            IconButton(onClick = {}) {
//                                Icon(Icons.Filled.ArrowBack, "backIcon")
//                            }
//                        },
                        backgroundColor = PlaceholderColor,
                        contentColor = PrimaryColor,

                        )
                },
                content = {
                    var contexto = LocalContext.current
                    Column(

                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                            .padding(bottom = 55.dp)
                            .background(PlaceholderColor),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        var pgname by remember { mutableStateOf(value = "") }
                        var location by remember { mutableStateOf(value = "") }
                        var rent by remember { mutableStateOf(value = "") }
                        var ownername by remember { mutableStateOf(value = "") }
                        var contact by remember { mutableStateOf(value = "") }
                        var vacancy by remember { mutableStateOf(value = "") }
                        var distance by remember { mutableStateOf(value = "") }
                        var gender by remember { mutableStateOf(value = "") }
                        var details by remember { mutableStateOf(value = "") }

                        OutlinedTextField(
                            modifier = Modifier.padding(7.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = "emailIcon",
                                    tint = PrimaryColor
                                )
                            },
                            value = pgname,
                            label = {
                                Text(
                                    text = "PG/Hostel Name",
                                    color = SecondaryColor
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text
                            ),
                            onValueChange = {
                                pgname = it
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = PrimaryColor,
                                textColor = SecondaryColor
                            )
                        )
                        OutlinedTextField(
                            modifier = Modifier.padding(7.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "emailIcon",
                                    tint = PrimaryColor
                                )
                            },
                            value = location,
                            label = { Text(text = "Location",
                                color = SecondaryColor) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text
                            ),
                            onValueChange = {
                                location = it
                            },
                            maxLines = 2,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = PrimaryColor,
                                textColor = SecondaryColor
                            )
                        )
                        OutlinedTextField(
                            modifier = Modifier.padding(7.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Send,
                                    contentDescription = "emailIcon",
                                    tint = PrimaryColor
                                )
                            },
                            value = rent,
                            label = { Text(text = "Min. Rent",
                                color = SecondaryColor) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            onValueChange = {
                                rent = it
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = PrimaryColor,
                                textColor = SecondaryColor
                            )
                        )
                        OutlinedTextField(
                            modifier = Modifier.padding(7.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "emailIcon",
                                    tint = PrimaryColor
                                )
                            },
                            value = ownername,
                            label = { Text(text = "Owner's Name",
                                color = SecondaryColor) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text
                            ),
                            onValueChange = {
                                ownername = it
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = PrimaryColor,
                                textColor = SecondaryColor
                            )
                        )

                        OutlinedTextField(
                            modifier = Modifier.padding(7.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Face,
                                    contentDescription = "emailIcon",
                                    tint = PrimaryColor
                                )
                            },
                            value =  gender,
                            label = { Text(text = "PG For",
                                color = SecondaryColor) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text
                            ),
                            onValueChange = {
                                gender = it

                            },
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = PrimaryColor,
                                textColor = SecondaryColor
                            )
                        )
                        OutlinedTextField(
                            modifier = Modifier.padding(7.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Phone,
                                    contentDescription = "emailIcon",
                                    tint = PrimaryColor
                                )
                            },
                            value = contact,
                            label = { Text(text = "Owner's Contact",
                                color = SecondaryColor) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Phone
                            ),
                            onValueChange = {
                                contact = it
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = PrimaryColor,
                                textColor = SecondaryColor
                            )
                        )
                        OutlinedTextField(
                            modifier = Modifier.padding(7.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.AddCircle,
                                    contentDescription = "emailIcon",
                                    tint = PrimaryColor
                                )
                            },
                            value = vacancy,
                            label = { Text(text = "Vacancy",
                                color = SecondaryColor) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text
                            ),
                            onValueChange = {
                                vacancy = it
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = PrimaryColor,
                                textColor = SecondaryColor
                            )
                        )
                        OutlinedTextField(
                            modifier = Modifier.padding(7.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "emailIcon",
                                    tint = PrimaryColor
                                )
                            },
                            value = distance,
                            label = { Text(text = "Distance(From nearest college)",
                                color = SecondaryColor) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            onValueChange = {
                                distance = it
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = PrimaryColor,
                                textColor = SecondaryColor
                            )
                        )

                        OutlinedTextField(
                            modifier = Modifier.padding(7.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "emailIcon",
                                    tint = PrimaryColor
                                )
                            },
                            value = details,
                            label = { Text(text = "Highlights about your PG",
                                color = SecondaryColor) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text
                            ),
                            onValueChange = {
                                details = it
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = PrimaryColor,
                                textColor = SecondaryColor
                            )
                        )
                        Button(
                            onClick = {
                                val pgadd = PGdata()

                                if(ownername.isEmpty()||details.isEmpty()||vacancy.isEmpty()||location.isEmpty()||pgname.isEmpty()||contact.isEmpty()||distance.isEmpty()){
                                    Toast.makeText(contexto , "Fields Cannot be Empty" , Toast.LENGTH_SHORT).show()
                                }else if(gender == "Boys" || gender == "Girls"){
                                    pgadd.owner = ownername
                                    pgadd.Details = details
                                    pgadd.vacancy = vacancy
                                    pgadd.Gender = gender
                                    pgadd.Location = location
                                    pgadd.Name = pgname
                                    pgadd.mono = contact
                                    pgadd.Distance = distance

                                    viewModel.addPG(pgadd)
                                    Toast.makeText(
                                        contexto,
                                        "Details Added Successfully!",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    } else {
                                        Toast.makeText(contexto , "Please Enter Boys or Girls" , Toast.LENGTH_SHORT).show()
                                    }



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

                            Text(text = "Submit")
                        }
                    }
                }
            )
        }



@Composable
fun LazyPersonalPG(data: MutableList<PGdata>) {
    LazyColumn(
        Modifier.padding(bottom = 55.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ){
        items(data){
                eachpg ->
            run {
//                if(eachpg.Location == query)
                cardItemnew(eachpg)
            }
        }

    }
}
@Composable
fun cardItemnew(eachpg: PGdata) {
    Column(
    ) {
        var pg = PGdata()
        var context = LocalContext.current
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = Color(0xFFDAE1E7),
            modifier = Modifier
                .height(170.dp)
                .padding(10.dp)
//                    .shadow(10.dp),
            //shadowElevation = 10.dp
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(2f),
                    verticalArrangement = Arrangement.Center
                ) {
//
                    Spacer(modifier = Modifier.height(1.dp))

                    Text(
                        text = "${eachpg.Name} (For ${pg.Gender})",
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.overline,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "Distance : ${eachpg.Distance} km",
                        color = SecondaryColor
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Vacancy : ${eachpg.vacancy}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.overline,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Vacancy : ${eachpg.owner}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.overline,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Vacancy : ${eachpg.Rent}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.overline,
                            color = Color.Black
                        )
                    }
                }
            }

        }
    }

}




