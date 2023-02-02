package com.example.pgfinder.sealed

import com.example.pgfinder.Messages

sealed class MessageGetState{
    class Success(val data : MutableList<Messages>) : MessageGetState()
    class Failure(val message :String) : MessageGetState()
    object Loading :MessageGetState()
    object Empty : MessageGetState()

}
