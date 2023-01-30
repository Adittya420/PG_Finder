package com.example.pgfinder

import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pgfinder.sealed.DataState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
//
//private lateinit var auth: FirebaseAuth
val dbAuther =  FirebaseDatabase.getInstance().getReference("Users")
class AutherViewModel : ViewModel() {
    var auth = Firebase.auth
    var user = auth.currentUser
    var aut = Auther()

//    val _authers = MutableLiveData<List<Auther>>()
//    val authers : LiveData<List<Auther>>
//    get() = _authers

    val response:MutableState<DataState> = mutableStateOf(DataState.Empty)
    private val _result  = MutableLiveData<Exception?>()
    val result : LiveData<Exception?>
        get() = _result


    fun addAuther(auther: Auther){
        auther.id = dbAuther.push().key
        dbAuther.child(auther.id!!).setValue(auther)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    _result.value = null

                }else{
                    _result.value = it.exception
                }
            }
    }
    init {
        FetchAuther()
    }

    fun FetchAuther(){
        dbAuther.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    var authers = mutableListOf<Auther>()
                    response.value = DataState.Loading
                    for (authorSnapshot in snapshot.children){
                        val author = authorSnapshot.getValue(Auther::class.java)
                        //                        author?.id = authorSnapshot.key
                        //                        author?.let { authers.add(it) }
                        if(author!=null){
                            authers.add(author)
                        }
                        response.value = DataState.Success(authers)
                    }
                    //                    _authers.value = authers
                }
            }

            override fun onCancelled(error: DatabaseError) {
                response.value = DataState.Failure(error.message)
            }

        })
    }
}