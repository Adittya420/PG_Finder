package com.example.jetpackcompose.data

import com.google.firebase.database.Exclude

data class Auther(
    @get:Exclude
    var id:String? = null,
    var name :String? = null,
    var age:Int? = null,
    var mobNumber: Number? = null,
    var email: String? = null,
    var institute:String? = null
)
