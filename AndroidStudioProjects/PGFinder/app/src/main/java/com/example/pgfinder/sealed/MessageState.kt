package com.example.pgfinder.sealed

import com.example.pgfinder.Auther
import com.example.pgfinder.Messages

sealed class MessageState{
    class Success(val message :String) : MessageState()
    class Failure(val message :String) : MessageState()
    object Loading :MessageState()
    object Empty : MessageState()
}
