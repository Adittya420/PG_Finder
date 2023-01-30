package com.example.pgfinder.sealed

import com.example.pgfinder.PGdata

sealed class DataStatepg{
    class Success(val data : MutableList<PGdata>) : DataStatepg()
    class Failure(val message :String) : DataStatepg()
    object Loading :DataStatepg()
    object Empty : DataStatepg()
}
