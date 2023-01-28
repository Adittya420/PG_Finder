package com.example.pgfinder.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes1 = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp)
)

val BottomBoxShape = androidx.compose.material.Shapes(
    medium = RoundedCornerShape(
        topStart = 14.dp,
        topEnd = 14.dp,
        bottomEnd = 0.dp,
        bottomStart = 0.dp
    )
)

val InputBoxShape = androidx.compose.material.Shapes(
    medium = RoundedCornerShape(14.dp)
)