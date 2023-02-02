package com.example.pgfinder

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pgfinder.sealed.DataStatepg
import com.example.pgfinder.sealed.MessageGetState
import com.example.pgfinder.sealed.MessageState
import com.example.pgfinder.sealed.PGaddState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.childEvents

class MessagesViewModel : ViewModel(){
    val user = com.example.pgfinder.ui.theme.auth.currentUser
    val responseM: MutableState<MessageGetState> = mutableStateOf(MessageGetState.Empty)
    val getresponse: MutableState<MessageState> = mutableStateOf(MessageState.Empty)

    val dbMessages = FirebaseDatabase.getInstance().getReference("Messages")

    fun addMessage(Message : Messages){
        getresponse.value = MessageState.Loading
        Message.id = dbMessages.push().key
        dbMessages.child(Message.id!!).setValue(Message).addOnCompleteListener {
            if (it.isSuccessful){
                getresponse.value = MessageState.Success("SUCCESS")
            }else{
                getresponse.value = MessageState.Failure("Failed")
            }
        }

    }
    init {
        FetchMessage()
    }

    private fun FetchMessage(){
        var templist = mutableListOf<Messages>()

        FirebaseDatabase.getInstance().getReference("Messages").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                templist.clear()
                for (datasnap in snapshot.children){
                    val Message = datasnap.getValue(Messages::class.java)
                    if (Message!=null){
//                        responseM.value = MessageGetState.Empty
                        templist.add(Message)
//                        responseM.value = MessageGetState.Empty
                    }

                }
                responseM.value = MessageGetState.Loading
                responseM.value = MessageGetState.Success(templist)

            }

            override fun onCancelled(error: DatabaseError) {
                responseM.value = MessageGetState.Failure(error.message)
            }

        })
    }
    }


