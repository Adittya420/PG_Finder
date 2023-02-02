package com.example.pgfinder.sealed

import com.example.pgfinder.PGdata

sealed class ParticularPGState{
    class Success(val data : MutableList<PGdata>) : ParticularPGState()
    class Failure(val message :String) : ParticularPGState()
    object Loading :ParticularPGState()
    object Empty : ParticularPGState()
}
