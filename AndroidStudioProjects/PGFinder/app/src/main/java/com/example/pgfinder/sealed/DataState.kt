package com.example.pgfinder.sealed

import com.example.pgfinder.Auther

sealed class DataState{
    class Success(val data : MutableList<Auther>) : DataState()
    class Failure(val message :String) : DataState()
    object Loading :DataState()
    object Empty : DataState()
}
