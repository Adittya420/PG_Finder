package com.example.pgfinder.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pgfinder.R

// Set of Material typography styles to start with
val nunitoLight = FontFamily(Font(R.font.nunito_light))
val nunitoRegular = FontFamily(Font(R.font.nunito_regular))
val nunitoMedium = FontFamily(Font(R.font.nunito_medium))
val nunitoBold = FontFamily(Font(R.font.nunito_bold))
val ReemKufi = FontFamily(Font(R.font.reemkufi))
val Poppins = FontFamily(Font(R.font.poppins))

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

    val quickSandFont = FontFamily(
        Font(R.font.quicksand_bold, FontWeight.Bold),
        Font(R.font.quicksand_light, FontWeight.Light),
        Font(R.font.quicksand_medium, FontWeight.Medium),
        Font(R.font.quicksand_regular, FontWeight.Normal),
        Font(R.font.quicksand_semibold, FontWeight.SemiBold)
)

val Typography2 = Typography(
    body1 = TextStyle(
        fontFamily = quickSandFont,
        fontWeight = FontWeight.SemiBold,
        fontSize=26.sp)
)



/* Other default text styles to override
button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
),
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/
