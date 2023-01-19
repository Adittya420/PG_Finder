package com.breens.flowermeditationapp.ui.utils

import androidx.compose.ui.graphics.Color
import com.breens.flowermeditationapp.ui.theme.Black
import com.breens.flowermeditationapp.ui.theme.Green
import com.breens.flowermeditationapp.ui.theme.Grey
import com.breens.flowermeditationapp.ui.theme.Yellow

val FILTER_CONTENT_LIST = listOf(
    FilterContent(Black, Color.Gray, "            PG            "),
    FilterContent(Black, Color.White, "          Hostel       "),
    //FilterContent(Black, Color.White, "Depression"),
    //FilterContent(Black, Color.White, "Anxiety"),
    //FilterContent(Black, Color.White, "Anger"),
    //FilterContent(Black, Color.White, "Excitement"),
    //FilterContent(Black, Color.White, "Fear"),
    //FilterContent(Black, Color.White, "Joy"),
    //FilterContent(Black, Color.White, "Horror")
)

val MEDITATION_TYPE_LIST = listOf(
    MeditationType(
        "PG: 1",
        "Show More",
        "Kothawades PG",
        "2.2km away from VJTI" +
                "            Location: Wadala",
        Yellow,
        Black,
        Green
    ),
    MeditationType(
        "PG: 2",
        "Show More",
        "Thakares PG",
        "5.6km away from VJTI   " +
                "        Location: King Circle,Matunga",
        Green,
        Black,
        Yellow
    ),
    MeditationType(
        "PG: 3",
        "Show More",
        "Chinmay PG",
        "8km away from VJTI" +
                "Location: PQR Street",
        Yellow,
        Black,
        Green
    ),
    MeditationType(
        "PG: 4",
        "Show More",
        "Aditya PG",
        "5.3km away from VJTI" +
                "Location: Behind ICT College",
        Green,
        Black,
        Yellow
    ),
    MeditationType(
        "PG: 5",
        "Show More",
        "Arakhraos PG",
        "1.3km away from VJTI" +
                "Location: Naigoan",
        Yellow,
        Black,
        Green
    ),
    MeditationType(
        "PG: 6",
        "Show More",
        "PQR PG",
        "4.2km away from VJTI" +
                "Location: Behind Don Bosko School",
        Green,
        Black,
        Yellow
    )
)