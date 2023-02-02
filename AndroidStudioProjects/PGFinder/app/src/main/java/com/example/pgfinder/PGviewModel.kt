package com.example.pgfinder

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.Snapshot
import androidx.lifecycle.ViewModel
import com.example.pgfinder.sealed.DataState
import com.example.pgfinder.sealed.DataStatepg
import com.example.pgfinder.sealed.PGaddState
import com.example.pgfinder.sealed.ParticularPGState
import com.example.pgfinder.ui.theme.user
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
public var templist = mutableListOf<PGdata>()
class PGviewModel : ViewModel() {
    val pgresponse: MutableState<DataStatepg> = mutableStateOf(DataStatepg.Empty)
    val addresponse: MutableState<PGaddState> = mutableStateOf(PGaddState.Empty)
    val particularresponse: MutableState<ParticularPGState> = mutableStateOf(ParticularPGState.Empty)
    val dbPG = FirebaseDatabase.getInstance().getReference("PGdata")


    fun addPG(Pg : PGdata){
        addresponse.value = PGaddState.Loading
        Pg.id = user?.uid
        dbPG.child(Pg.id!!).setValue(Pg).addOnCompleteListener {
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
        var templist2 = mutableListOf<PGdata>()

        pgresponse.value = DataStatepg.Loading
        FirebaseDatabase.getInstance().getReference("PGdata").addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                templist.clear()
                if(snapshot.exists()) {
                    pgresponse.value = DataStatepg.Loading
//                    particularresponse.value = ParticularPGState.Loading
                    for (datasnap in snapshot.children) {
                        val pgdetails = datasnap.getValue(PGdata::class.java)
                        if (pgdetails != null) {
//                            templist.clear()
                            templist.add(pgdetails)

                        }
                        if (pgdetails != null && pgdetails.id == user?.uid) {
                            templist2.add(pgdetails)
                            particularresponse.value = ParticularPGState.Success(templist2)
                        }
                        particularresponse.value = ParticularPGState.Empty

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