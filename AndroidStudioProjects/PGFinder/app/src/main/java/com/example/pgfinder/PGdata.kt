package com.example.pgfinder

import androidx.compose.ui.graphics.Color
import com.google.firebase.database.Exclude

data class PGdata(
    @get:Exclude
    var id: String? = null,
    var Name: String? = null,
    var owner: String? = null,
    var Location: String? = null,
    var mono: String? = null,
    var vacancy: String? = null,
    var Rent: String? = null,
    var Distance: String? = null,
    var Gender:String? = null,
    var Details:String? = null,
    var PGide:Int? = null

)
