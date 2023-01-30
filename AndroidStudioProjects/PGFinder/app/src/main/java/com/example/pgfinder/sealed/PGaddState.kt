package com.example.pgfinder.sealed

import com.example.pgfinder.PGdata

sealed class PGaddState {
    class Success(val message: String) : PGaddState()
    class Failure(val message :String) : PGaddState()
    object Loading :PGaddState()
    object Empty : PGaddState()
}