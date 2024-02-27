package com.graduation.breastcancer.ui.authentication.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginViewModel : ViewModel() {
    //model - view - viewmodel
    private val auth = Firebase.auth
    val errorMessage = MutableLiveData<String>()
    val error = MutableLiveData<Boolean>()
    val navigate = MutableLiveData<Boolean>()
    fun loginUser(email:String , pass:String){
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {task->
            if(task.isSuccessful){
                error.postValue(false)
                navigate.postValue(true) //observe desgin patten
                val user = auth.currentUser

            }
            else{
                navigate.postValue(false)
                error.postValue(true)
              errorMessage.postValue(task.exception?.localizedMessage)
            }
        }

    }
}