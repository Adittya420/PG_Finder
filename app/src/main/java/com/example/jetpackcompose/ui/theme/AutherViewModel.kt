package com.example.jetpackcompose.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.data.Auther
import com.example.jetpackcompose.data.Node_authors
import com.google.firebase.database.FirebaseDatabase

class AutherViewModel : ViewModel() {

    private val _result  = MutableLiveData<Exception?>()
    val result : LiveData<Exception?>
         get() = _result

    fun addAuther(auther: Auther){
        val dbAuther = FirebaseDatabase.getInstance().getReference(Node_authors)
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
}