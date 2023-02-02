package com.example.pgfinder

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Typography
//import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
//import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pgfinder.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState


class OnBoardingActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PGFinderTheme {
                // A surface container using the 'background' color from the theme

//
//                items.add(
//                        OnBoardingData(
//                            R.drawable.searchpg1,
//                            "Search PG's",
//                            "Find Favorable Stay."
//                        )
//                    )
////
//                    items.add(
//                        OnBoardingData(
//                            R.drawable.locationpg,
//                            "Preferred location",
//                            "According to your College Location ."
//                        )
//                    )
////
//                    items.add(
//                        OnBoardingData(
//                            R.drawable.customersupportpg,
//                            "Amazing Customer Support",
//                            "quick, easy, personalized, and empathetic customer services."
//                        )
//                    )
////
//                    val pagerState = rememberPagerState(
//                        pageCount = items.size,
//                        initialOffscreenLimit = 2,
//                        infiniteLoop = false,
//                        initialPage = 0,
//                    )
////
//                    OnBoardingPager(
//                        item = items, pagerState = pagerState, modifier = Modifier
//                            .fillMaxWidth()
//                            .background(color = White)
//                    )
//
            }
        }
    }
}





//
//    @ExperimentalPagerApi
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        window.statusBarColor = ContextCompat.getColor(this, R.color.grey_900)
//        setContent {
//            AppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize()) {
//
//                    val items = ArrayList<OnBoardingData>()
//
//                    items.add(
//                        OnBoardingData(
//                            R.drawable.searchpg1,
//                            "Search PG's",
//                            "Find Favorable Stay."
//                        )
//                    )
//
//                    items.add(
//                        OnBoardingData(
//                            R.drawable.locationpg,
//                            "Preferred location",
//                            "According to your College Location ."
//                        )
//                    )
//
//                    items.add(
//                        OnBoardingData(
//                            R.drawable.customersupportpg,
//                            "Amazing Customer Support",
//                            "quick, easy, personalized, and empathetic customer services."
//                        )
//                    )
//
//                    val pagerState = rememberPagerState(
//                        pageCount = items.size,
//                        initialOffscreenLimit = 2,
//                        infiniteLoop = false,
//                        initialPage = 0,
//                    )
//
//                    OnBoardingPager(
//                        item = items, pagerState = pagerState, modifier = Modifier
//                            .fillMaxWidth()
//                            .background(color = Color.White)
//                    )
//
//                }
//            }
//        }
//    }

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Getstarted(onGetstartedCLick:()->Unit){
    val items = ArrayList<OnBoardingData>()
                    items.add(
                        OnBoardingData(
                            R.drawable.searchpg1,
                            "Search PG's",
                            "Find Favorable Stay."
                        )
                    )

                    items.add(
                        OnBoardingData(
                            R.drawable.locationpg,
                            "Preferred location",
                            "According to your College Location ."
                        )
                    )

                    items.add(
                        OnBoardingData(
                            R.drawable.customersupportpg,
                            "Amazing Customer Support",
                            "quick, easy, personalized, and empathetic customer services."
                        )
                    )

                    val pagerState = rememberPagerState(
                        pageCount = items.size,
                        initialOffscreenLimit = 2,
                        infiniteLoop = false,
                        initialPage = 0,
                    )

                    OnBoardingPager(
                        item = items, pagerState = pagerState, modifier = Modifier
                            .fillMaxWidth()
                            .background(color = White),
                        onGetstartedCLick
                    )


}

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun OnBoardingPager(
        item: List<OnBoardingData>,
        pagerState: PagerState,
        modifier: Modifier = Modifier,
        onGetstartedCLick:()->Unit
    ) {
//        var item = ArrayList<OnBoardingData>()
////        var pagerStare = PagerState()
//        val pagerState = rememberPagerState(
//                        pageCount = item.size,
//                        initialOffscreenLimit = 2,
//                        infiniteLoop = false,
//                        initialPage = 0,
//                    )
//        item.add(
//            OnBoardingData(
//                R.drawable.searchpg1,
//                "Search PG's",
//                "Find Favorable Stay."
//            )
//        )
////
//        item.add(
//            OnBoardingData(
//                R.drawable.locationpg,
//                "Preferred location",
//                "According to your College Location ."
//            )
//        )
////
//        item.add(
//            OnBoardingData(
//                R.drawable.customersupportpg,
//                "Amazing Customer Support",
//                "quick, easy, personalized, and empathetic customer services."
//            )
//        )
////
        Box(modifier = Modifier) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                HorizontalPager(state = pagerState) { page ->
                    Column(
                        modifier = Modifier
                            .padding(top = 60.dp)
                            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(id = item[page].image),
                            contentDescription = item[page].title,
                            modifier = Modifier
                                .height(250.dp)
                                .fillMaxWidth()
                        )

                        Text(
                            text = item[page].title,
                            modifier = Modifier.padding(top = 50.dp), color = Grey900,
                            style = Typography2.body1
                        )

                        Text(
                            text = item[page].desc,
                            modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp),
                            color = Grey900,
                            style = Typography2.body1,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )

                    }
                }

                PagerIndicator(item.size, pagerState.currentPage)
            }

            Box(modifier = Modifier.align(Alignment.BottomCenter)){
                BottomSection(pagerState.currentPage , onGetstartedCLick)
            }
        }
    }


    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun rememberPagerState(
        @androidx.annotation.IntRange(from = 0) pageCount: Int,
        @androidx.annotation.IntRange(from = 0) initialPage: Int = 0,
        @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
        @androidx.annotation.IntRange(from = 1) initialOffscreenLimit: Int = 1,
        infiniteLoop: Boolean = false
    ): PagerState = rememberSaveable(saver = PagerState.Saver) {
        PagerState(
            pageCount = pageCount,
            currentPage = initialPage,
            currentPageOffset = initialPageOffset,
            offscreenLimit = initialOffscreenLimit,
            infiniteLoop = infiniteLoop
        )
    }

    @Composable
    fun PagerIndicator(size: Int, currentPage: Int) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 60.dp)
        ) {
            repeat(size) {
                Indicator(isSelected = it == currentPage)
            }
        }
    }

    @Composable
    fun Indicator(isSelected: Boolean) {
        val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

        Box(
            modifier = Modifier
                .padding(1.dp)
                .height(10.dp)
                .width(width.value)
                .clip(CircleShape)
                .background(
                    if (isSelected) MaterialTheme.colors.primary else Grey300.copy(alpha = 0.5f)
                )
        )
    }

    @Composable
    fun BottomSection(currentPager: Int , onGetstartedCLick: () -> Unit) {
        Row(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = if (currentPager != 2) Arrangement.SpaceBetween else Arrangement.Center
        ) {

            if (currentPager == 2){
                OutlinedButton(
                    onClick = {
//                        startActivity(Intent(this@OnBoardingActivity , MainActivity::class.java))
                            onGetstartedCLick()
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = PrimaryColor
                    )
                ) {
                    Text(
                        text = "Get Started",
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 40.dp),
                        color =  Grey900
                    )
                }
            }else{
                SkipNextButton("Skip",Modifier.padding(start = 20.dp))
                //SkipNextButton("Next",Modifier.padding(end = 20.dp))
            }

        }
    }


    @Composable
    fun SkipNextButton(text: String, modifier: Modifier) {
        Text(
            text = text, color = Grey900, modifier = modifier, fontSize = 18.sp,
            style = Typography.body1,
            fontWeight = FontWeight.Medium
        )

    }
