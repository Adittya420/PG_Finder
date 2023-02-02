package com.example.pgfinder

import android.content.Context
import android.content.Intent

public inline fun <reified T:Any> createIntent(
    context: Context
)= Intent(context , T::class.java)

public inline fun <reified T:Any> Context.launchActivity(){
    val intent = createIntent<T>(this)
    startActivity(intent)
}
