package com.example.pgfinder

import androidx.compose.ui.graphics.Color

data class PGdata(

    var Name: String? = null,
    var owner: String? = null,
    var Location: String? = null,
    var mono: Long? = null,
    var vacancy: Int? = null,
    var Rent: Int? = null,
    var Distance: Int? = null,
    var Gender:String? = null
)
