package com.example.pgfinder

import android.location.Location
import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pgfinder.ui.theme.BottomBoxShape
import com.example.pgfinder.ui.theme.Grey
import com.example.pgfinder.ui.theme.InputBoxShape
import com.example.pgfinder.ui.theme.PrimaryColor

@Composable
fun ProfileScreen() {

    Box(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(androidx.compose.ui.graphics.Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "PROFILE",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = androidx.compose.ui.graphics.Color.Blue
        )
    }
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.background(Grey),
                title = {
                    Text(text = "Add Details")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = Grey,
                contentColor = PrimaryColor,
                )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize().padding(top = 30.dp).background(Grey),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                var pgname by remember { mutableStateOf(TextFieldValue("")) }
                var location by remember { mutableStateOf(TextFieldValue("")) }
                var rent by remember { mutableStateOf(TextFieldValue("")) }
                var ownername by remember { mutableStateOf(TextFieldValue("")) }
                var contact by remember { mutableStateOf(TextFieldValue("")) }
                var vacancy by remember { mutableStateOf(TextFieldValue("")) }
                var distance by remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(
                    modifier = Modifier.padding(7.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Home, contentDescription = "emailIcon",
                            tint = PrimaryColor
                        )
                    },
                    value =  pgname,
                    label = { Text(text = "PG/Hostel Name",
                    color = PrimaryColor) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    onValueChange = {
                        pgname = it
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
                            imageVector = Icons.Default.LocationOn, contentDescription = "emailIcon",
                            tint = PrimaryColor
                        )
                    },
                    value =  location,
                    label = { Text(text = "Location",
                        color = PrimaryColor) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    onValueChange = {
                        location = it
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
                            imageVector = Icons.Default.Send, contentDescription = "emailIcon",
                            tint = PrimaryColor
                        )
                    },
                    value =  rent,
                    label = { Text(text = "Min. Rent",
                        color = PrimaryColor) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    onValueChange = {
                        rent = it
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
                            imageVector = Icons.Default.Person, contentDescription = "emailIcon",
                            tint = PrimaryColor
                        )
                    },
                    value =  ownername,
                    label = { Text(text = "Owner's Name",
                        color = PrimaryColor) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    onValueChange = {
                        ownername = it
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
                    value =  contact,
                    label = { Text(text = "Owner's Contact",
                        color = PrimaryColor) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    ),
                    onValueChange = {
                        contact = it
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
                            imageVector = Icons.Default.AddCircle, contentDescription = "emailIcon",
                            tint = PrimaryColor
                        )
                    },
                    value =  vacancy,
                    label = { Text(text = "Vacancy",
                        color = PrimaryColor) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    onValueChange = {
                        vacancy = it
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
                            imageVector = Icons.Default.ArrowForward, contentDescription = "emailIcon",
                            tint = PrimaryColor
                        )
                    },
                    value =  distance,
                    label = { Text(text = "Distance(From nearest college)",
                        color = PrimaryColor) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    onValueChange = {
                        distance = it
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = PrimaryColor,
                        textColor = PrimaryColor
                    )
                )
                Button(
                    shape = InputBoxShape.small,
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)
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
fun MyCreates(viewModel: PGviewModel){
 Column(
  modifier = Modifier.fillMaxSize()
 ) {
  Text(text = "MY Create", modifier = Modifier.fillMaxSize().background(Grey), textAlign = TextAlign.Center)
  var pgname by remember { mutableStateOf(value = "") }
  var location by remember { mutableStateOf(value = "") }
  var rent by remember { mutableStateOf(value = "") }
  var ownername by remember { mutableStateOf(value = "") }
  var contact by remember { mutableStateOf(value = "") }
  var vacancy by remember { mutableStateOf(value = "") }
  var distance by remember { mutableStateOf(value = "") }
  var gender by remember { mutableStateOf(value = "") }
  val pg = PGdata()

  pg.Distance = distance.toInt()
  pg.Gender = gender
  pg.vacancy = vacancy.toInt()
  pg.Name = pgname
  pg.Rent = rent.toInt()
  pg.Location = location
  pg.mono = contact.toLong()
  pg.owner = ownername

  viewModel.addPG(pg)
 }

}

