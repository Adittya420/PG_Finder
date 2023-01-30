package com.example.pgfinder

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.Snapshot
import androidx.lifecycle.ViewModel
import com.example.pgfinder.sealed.DataState
import com.example.pgfinder.sealed.DataStatepg
import com.example.pgfinder.sealed.PGaddState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class PGviewModel : ViewModel() {
    val pgresponse: MutableState<DataStatepg> = mutableStateOf(DataStatepg.Empty)
    val addresponse: MutableState<PGaddState> = mutableStateOf(PGaddState.Empty)


    fun addPG(Pg : PGdata){
        addresponse.value = PGaddState.Loading
        FirebaseDatabase.getInstance().getReference("PGdata").setValue(Pg).addOnCompleteListener {
            if (it.isSuccessful){
                addresponse.value = PGaddState.Success("SUCCESS")
            }else{
                addresponse.value = PGaddState.Failure("Failed")
            }
        }

    }

    init {
        fetchdatafromfirebase()
    }

    private fun fetchdatafromfirebase() {
        var templist = mutableListOf<PGdata>()
        pgresponse.value = DataStatepg.Loading
        FirebaseDatabase.getInstance().getReference("PGdata").addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (datasnap in snapshot.children){
                    val pgdetails = datasnap.getValue(PGdata::class.java)
                    if (pgdetails!=null){
                        templist.add(pgdetails)
                    }
                    pgresponse.value = DataStatepg.Success(templist)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                pgresponse.value = DataStatepg.Failure(error.message)
            }

        })
    }

}