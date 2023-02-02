package com.example.pgfinder.ui.theme

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Toast
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pgfinder.*
import com.example.pgfinder.R
import com.example.pgfinder.sealed.DataStatepg
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay

var PGid:Int? = null
@Composable
fun home(
    onReadClick:()->Unit,
//    onLogoutClick:()->Unit
) {
    Column(
        modifier = Modifier
            .background(PlaceholderColor)
            .fillMaxSize()
    ) {
//        FloatingActionButton(onClick = {}) {
//
//        }
        HeaderProfileComponent(AutherViewModel() )
        SearchInputComponent()
        setData(PGviewModel()  , onReadClick)
//        FilterOptionsComponent()
//        MeditationTypesComponent()
    }
}

@Composable
fun setData(viewModel: PGviewModel , onReadClick: () -> Unit) {
    when (val results = viewModel.pgresponse.value) {
        is DataStatepg.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
//                CircularProgressIndicator()
                LoadingAnimation()
//                    AnimatedShimmer()
            }
        }
        is DataStatepg.Success -> {
            showLazyList2(results.data , onReadClick)
        }
        is DataStatepg.Failure -> {
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
@Composable
fun showLazyList2(data: MutableList<PGdata> , onReadClick: () -> Unit) {
    LazyColumn(
        Modifier.padding(bottom = 55.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ){
        items(data){
                eachpg ->
            run {
//                if(eachpg.Location == query)
                cardItem1(eachpg , onReadClick)
            }
        }

    }

}
@Composable
fun cardItem1(eachpg: PGdata  , onReadClick: () -> Unit) {
        Column(

        ) {
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
                            text = "${eachpg.Name.toString()} (For ${eachpg.Gender})",
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.overline,
                            fontWeight = FontWeight.SemiBold,
                            color = Black
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        Text(text = "Distance : ${eachpg.Distance} km",
                        color = SecondaryColor)
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Vacancy",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.overline,
                                color = Black
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            if (eachpg.vacancy != "") {
                                for (i in 1..eachpg.vacancy!!.toInt()) {
                                    Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = "",
                                        tint = SecondaryColor
                                    )
                                }
                            }

//                            Icon(
//                                painter = painterResource(id = R.drawable.baseline_star_outline_24),
//                                tint = Color(0xFFF6B266),
//                                contentDescription = null
//                            )
//
//                            Icon(
//                                painter = painterResource(id = R.drawable.baseline_star_outline_24),
//                                tint = Color(0xFFF6B266),
//                                contentDescription = null
//                            )
//                            Icon(
//                                painter = painterResource(id = R.drawable.baseline_star_outline_24),
//                                tint = Color(0xFFF6B266),
//                                contentDescription = null
//                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        OutlinedButton(
                            shape = RoundedCornerShape(8.dp),
                            //colors = ,
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Black,
                                //containerColor = Color.White
                                backgroundColor = PrimaryColor
                            ),
                            onClick = {
                                onReadClick()

                            }
                        ) {
                            Text(
                                text = "Read More",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.overline
                            )
                        }
                    }

                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.size(width = 100.dp, height = 150.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.hostelimage),
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }



//
//    Card(
//        shape = RoundedCornerShape(50.dp),
//        modifier = Modifier.fillMaxSize().height(50.dp).width(50.dp),
//        backgroundColor = PrimaryColor
//    ) {
//        Column(
//            verticalArrangement = Arrangement.SpaceEvenly,
//            horizontalAlignment = Alignment.Start,
//            modifier = Modifier.height(50.dp)
//        ) {
//            Box(
//                modifier = Modifier.fillMaxWidth().height(50.dp).width(50.dp),
//            ) {
////            Text(text = eachpg.Name.toString(),
////            modifier = Modifier.padding(top = 5.dp),
////            textAlign = TextAlign.Justify)
////            Text(text = "Name: ${eachpg.Name}",modifier = Modifier.padding(top = 10.dp), textAlign = TextAlign.Center)
//                Text(
//                    text = "Location: ${eachpg.Location}",
//                    fontSize = 18.sp,
//                    color = SecondaryColor,
//                    textAlign = TextAlign.Start
//                )
////            Text(text = eachpg.mono.toString(),modifier = Modifier.padding(top = 20.dp), textAlign = TextAlign.Justify)
//                Text(
//                    text = "Distance: ${eachpg.Distance} km", fontSize = 18.sp,
//                    color = SecondaryColor,
//                    textAlign = TextAlign.Center
//                )
//                Text(
//                    text = "Vacancy: ${eachpg.vacancy}", fontSize = 18.sp,
//                    color = SecondaryColor,
//                    textAlign = TextAlign.End
//                )
////            Text(text = eachpg.Rent.toString(),modifier = Modifier.padding(top = 35.dp), textAlign = TextAlign.Justify)
//            }
//        }
//
//    }
val auth = Firebase.auth
var user = auth.currentUser
@Composable
fun HeaderProfileComponent(autherViewModel: AutherViewModel ) {
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
                    modifier = Modifier,
                    text = "Welcome back",
                    fontWeight = FontWeight.Bold,
                    fontFamily = nunitoLight,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    color = SecondaryColor
                )
                if (user != null) {
                    Text(
                        text = user!!.email.toString(),
                        fontFamily = nunitoMedium,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start,
                        color = SecondaryColor
                    )
                }
            }
        }

        BadgedBox(badge = { Badge(backgroundColor = Green) }) {
            IconButton(onClick = {
            /*TODO*/
                auth.signOut()
//                onLogoutClick()
            }) {
                Icon(
                    Icons.Default.ExitToApp,
                    contentDescription = "Notifications",
                    tint = SecondaryColor
                )
            }
        }

    }
}

//@Preview
@Composable
fun SearchInputComponent() {

    var list = mutableListOf<PGdata>()
//    for(i in templist){
//        list.add(i)
//    }
    var query : MutableState<String> = remember { mutableStateOf("") }

    val contexto = LocalContext.current
    var search by remember { mutableStateOf("") }
    OutlinedTextField(
        value = query.value, onValueChange = {
                    query.value = it
        },
        placeholder = { Text(text = "Search", fontFamily = nunitoLight) },
        leadingIcon = {
            IconButton(onClick = {
                Toast.makeText(contexto , "$query" , Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = {

            }) {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "Filter Icon"
                )
            }
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
@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier,
    circleSize: Dp = 25.dp,
    circleColor: Color = PrimaryColor,
    spaceBetween: Dp = 10.dp,
    travelDistance: Dp = 20.dp
) {
    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(key1 = animatable) {
            delay(index * 100L)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1200
                        0.0f at 0 with LinearOutSlowInEasing
                        1.0f at 300 with LinearOutSlowInEasing
                        0.0f at 600 with LinearOutSlowInEasing
                        0.0f at 1200 with LinearOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }

    val circleValues = circles.map { it.value }
    val distance = with(LocalDensity.current) { travelDistance.toPx() }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween)
    ) {
        circleValues.forEach { value ->
            Box(
                modifier = Modifier
                    .size(circleSize)
                    .graphicsLayer {
                        translationY = -value * distance
                    }
                    .background(
                        color = circleColor,
                        shape = CircleShape
                    )
            )
        }
    }

}

@Composable
fun AnimatedShimmer() {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )

    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )

    ShimmerGridItem(brush = brush)
}

@Composable
fun ShimmerGridItem(brush: Brush) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(brush)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(fraction = 0.7f)
                    .background(brush)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(fraction = 0.9f)
                    .background(brush)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ShimmerGridItemPreview() {
    ShimmerGridItem(
        brush = Brush.linearGradient(
            listOf(
                Color.LightGray.copy(alpha = 0.6f),
                Color.LightGray.copy(alpha = 0.2f),
                Color.LightGray.copy(alpha = 0.6f),
            )
        )
    )
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun ShimmerGridItemDarkPreview() {
    ShimmerGridItem(
        brush = Brush.linearGradient(
            listOf(
                Color.LightGray.copy(alpha = 0.6f),
                Color.LightGray.copy(alpha = 0.2f),
                Color.LightGray.copy(alpha = 0.6f),
            )
        )
    )
}