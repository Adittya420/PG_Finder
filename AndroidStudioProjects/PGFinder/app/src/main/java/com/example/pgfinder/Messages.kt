package com.example.pgfinder

import com.google.firebase.database.Exclude

data class Messages(
    var au: Auther = Auther(),
    @get:Exclude
    var id: String? = null,
    var message: String? = null,
    var name: String = au.name1.toString()
)
