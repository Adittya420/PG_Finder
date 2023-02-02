package com.example.pgfinder



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.example.pgfinder.ui.theme.*
import com.google.accompanist.insets.LocalWindowInsets
import kotlin.math.max
import kotlin.math.min


@Composable
fun MainFragment(pg: PGdata) {
    val scrollState = rememberLazyListState()

    Box {
        Content(pg, scrollState)
        ParallaxToolbar(pg, scrollState)
    }
}

@Composable
fun ParallaxToolbar(pg: PGdata, scrollState: LazyListState) {
    val imageHeight = AppBarExpendedHeight - AppBarCollapsedHeight

    val maxOffset =
        with(LocalDensity.current) { imageHeight.roundToPx() } - LocalWindowInsets.current.systemBars.layoutInsets.top

    val offset = min(scrollState.firstVisibleItemScrollOffset, maxOffset)

    val offsetProgress = max(0f, offset * 3f - 2f * maxOffset) / maxOffset

    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = PlaceholderColor,
        modifier = Modifier
            .height(
                AppBarExpendedHeight
            )
            .offset { IntOffset(x = 0, y = -offset) },
        elevation = if (offset == maxOffset) 4.dp else 0.dp
    ) {
        Column {
            Box(
                Modifier
                    .height(imageHeight)
                    .graphicsLayer {
                        alpha = 1f - offsetProgress
                    }) {
                Image(
                    painter = painterResource(id = R.drawable.pglogo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    Pair(0.4f, Transparent),
                                    Pair(1f, PlaceholderColor)
                                )
                            )
                        )
                )

                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "Boys",
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .clip(Shapes.small)
                            .background(LightGray)
                            .padding(vertical = 6.dp, horizontal = 16.dp)
                    )
                }
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(AppBarCollapsedHeight),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Pratham's PG",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = (16 + 28 * offsetProgress).dp)
                        .scale(1f - 0.25f * offsetProgress)
                )

            }
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(AppBarCollapsedHeight)
            .padding(horizontal = 16.dp)
    ) {
        CircularButton(R.drawable.ic_arrow_back)
        //CircularButton(R.drawable.ic_favorite)
    }
}

@Composable
fun CircularButton(
    @DrawableRes iconResouce: Int,
    color: Color = Gray,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(),
        shape = Shapes.small,
        colors = ButtonDefaults.buttonColors(backgroundColor = White, contentColor = color),
        elevation = elevation,
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
    ) {
        Icon(painterResource(id = iconResouce), null)
    }
}

@Composable
fun Content(pg: PGdata, scrollState: LazyListState) {
    LazyColumn(contentPadding = PaddingValues(top = AppBarExpendedHeight), state = scrollState) {
        item {
            BasicInfo(pg)
            Description(pg)

            ShoppingListButton()
            highlights()
            description()
            Reviews(pg)
            comment()
            //Images()
        }
    }
}
//
//@Composable
//fun Images() {
//    Row(Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
//        Image(
//            painter = painterResource(id = R.drawable.strawberry_pie_2),
//            contentDescription = null,
//            modifier = Modifier
//                .weight(1f)
//                .clip(Shapes.small)
//        )
//        Spacer(modifier = Modifier.weight(0.1f))
//        Image(
//            painter = painterResource(id = R.drawable.strawberry_pie_3),
//            contentDescription = null,
//            modifier = Modifier
//                .weight(1f)
//                .clip(Shapes.small)
//        )
//    }
//}

@Composable
fun Reviews(pg: PGdata) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "Reviews", fontWeight = Bold)
//            Text(pg.reviews, color = DarkGray)
        }
        Button(
            onClick = {  }, elevation = null, colors = ButtonDefaults.buttonColors(
                backgroundColor = Transparent, contentColor =  Color.Black
            )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("See all")
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = null
                )
            }
        }

    }
}

@Composable
fun ShoppingListButton() {
    Button(
        onClick = {  },
        elevation = null,
        shape = Shapes.small,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = PrimaryColor,
            contentColor = Color.Black
        ), modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Add to favourite list", modifier = Modifier.padding(8.dp))
    }

}


@Composable
fun Description(pg: PGdata) {
    Text(
        text = templist.get(0).Location.toString(),
        fontWeight = Medium,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
    )
}

@Composable
fun BasicInfo(pg: PGdata) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        InfoColumn(R.drawable.ic_clock, "${templist.get(0).Distance.toString()}0 min")
        InfoColumn(R.drawable.ic_person, "${templist.get(0).vacancy.toString()} Person")
        InfoColumn(R.drawable.ic_star, pg.Gender.toString())
    }
}

@Composable
fun InfoColumn(@DrawableRes iconResouce: Int, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = iconResouce),
            contentDescription = null,
            tint = PrimaryColor,
            modifier = Modifier.height(24.dp)
        )
        Text(text = text, fontWeight = Medium)
    }
}

@Composable
fun highlights(){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Highlights",color = Color.Black, fontWeight = FontWeight.Bold)
        Text(text = "◆  Minimal Rent")
        Text(text = "◆  Good Facilities")
        Text(text = "◆  Secure & safe")
        Text(text = "◆  AC / Non-AC Both available")
        Text(text = "◆  max 3 people ")



    }
}

@Composable
fun description(){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Description",color = Color.Black, fontWeight = FontWeight.Bold)
        Text(text = "Owner Name : Prathamesh Kothawade")
        Text(text = "Contact : 907645321")

    }
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row() {
            Text(text = "Rent",color = Color.Black, fontWeight = FontWeight.Bold)
            Text(text = "(Per Month)")
        }
        Text(text = "1 BHK(Non-AC) : 15000 ")
        Text(text = "1 BHK(AC) : 10000 ")
        Text(text = "....for further details contact owner",color = Color.Gray,fontStyle = FontStyle.Italic)
    }
}

@Composable
fun comment(){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Comment Box")
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text(text = "Comment") },
            placeholder = { Text(text = "Comment here...",color = Color.Gray) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = PrimaryColor,
                // textColor = PrimaryColor
            )
        )
    }
}