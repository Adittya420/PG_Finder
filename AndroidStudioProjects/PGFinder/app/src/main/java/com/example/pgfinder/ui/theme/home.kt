package com.example.pgfinder.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pgfinder.R


@Composable
fun home() {
    Column(
        modifier = Modifier
            .background(Grey)
            .fillMaxSize()
    ) {
        HeaderProfileComponent()
        SearchInputComponent()
//        FilterOptionsComponent()
//        MeditationTypesComponent()
    }
}

@Composable
fun HeaderProfileComponent() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.rohit_sharma),
                contentDescription = "Profile picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = "Welcome back",
                    fontFamily = nunitoLight,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    color = Color.White
                )
                Text(
                    text = "Hitman Rohit",
                    fontFamily = nunitoMedium,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    color = Color.White
                )
            }
        }

        BadgedBox(badge = { Badge(backgroundColor = Green) }) {
            Icon(
                Icons.Default.Notifications,
                contentDescription = "Notifications"

            )
        }
    }
}

@Preview
@Composable
fun SearchInputComponent() {
    OutlinedTextField(
        value = "", onValueChange = {},
        placeholder = { Text(text = "Search", fontFamily = nunitoLight) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.filter),
                modifier = Modifier.size(24.dp),
                contentDescription = "Filter Icon"
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp, start = 15.dp, end = 15.dp)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.White,
            cursorColor = Color.LightGray,
            trailingIconColor = Black,
            leadingIconColor = Color.Gray,
            placeholderColor = Color.LightGray
        )
    )
}
//
//@Composable
//fun FilterOptionsComponent() {
//    val filterOptions = FILTER_CONTENT_LIST
//    LazyRow(
//        Modifier.padding(top = 15.dp, start =15.dp),
//        horizontalArrangement = Arrangement.spacedBy(15.dp)
//    ) {
//        items(filterOptions.size) {
//            ChipComponent(filter = filterOptions[it])
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun ChipComponent(filter: FilterContent) {
//    val contentColor = filter.contentColor
//    val chipBackground = filter.backgroundColor
//    val filterText = filter.filterText
//    Chip(
//        onClick = { /*TODO*/ },
//        colors = ChipDefaults.chipColors(
//            contentColor = contentColor,
//            backgroundColor = chipBackground
//        ),
//        shape = RoundedCornerShape(8.dp)
//    ) {
//        Text(text = filterText, fontFamily = nunitoMedium)
//    }
//}
//
//@Composable
//fun MeditationTypesComponent() {
//    val meditationOptions = MEDITATION_TYPE_LIST
//    LazyColumn(
//        Modifier.padding(15.dp),
//        verticalArrangement = Arrangement.spacedBy(15.dp)
//    ) {
//        items(meditationOptions.size) {
//            MeditationOptionComponent(meditationTypes = meditationOptions[it])
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun MeditationOptionComponent(meditationTypes: PGdata) {
//    Card(
//        shape = RoundedCornerShape(14.dp),
//        modifier = Modifier.fillMaxSize(),
//        backgroundColor = meditationTypes.backgroundColor
//    ) {
//        Column(
//            verticalArrangement = Arrangement.SpaceEvenly,
//            horizontalAlignment = Alignment.Start,
//            modifier = Modifier.padding(20.dp)
//        ) {
//            Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
//                Chip(
//                    onClick = { /*TODO*/ },
//                    colors = ChipDefaults.chipColors(
//                        contentColor = Black,
//                        backgroundColor = meditationTypes.timeBackgroundColor
//                    ),
//                    shape = RoundedCornerShape(8.dp)
//                ) {
//                    Text(text = meditationTypes.vacancy.toString(), fontFamily = nunitoMedium)
//                }
//                Chip(
//                    onClick = { /*TODO*/ },
//                    colors = ChipDefaults.chipColors(
//                        contentColor = Black,
//                        backgroundColor = Color.White
//                    ),
//                    shape = RoundedCornerShape(8.dp)
//                ) {
//                    Text(text = meditationTypes.showmore, fontFamily = nunitoMedium)
//                }
//            }
//
//            Text(
//                text = meditationTypes.name.toString(),
//                fontFamily = nunitoBold,
//                fontSize = 18.sp,
//                color = meditationTypes.contentColor,
//                textAlign = TextAlign.Start
//            )
//
//            Text(
//                text = meditationTypes.address.toString(),
//                fontFamily = nunitoLight,
//                fontSize = 16.sp,
//                color = meditationTypes.contentColor,
//                textAlign = TextAlign.Start
//            )
//        }
//    }
//}
//
//
//
