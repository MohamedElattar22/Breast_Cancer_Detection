package com.graduation.breastcancer.ui.authentication.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class SignUpViewModel : ViewModel() {
    val auth = Firebase.auth
    val data = MutableLiveData<String>()
    val navigate = MutableLiveData<Boolean>()
    fun registerUser(email: String, pass: String) {
        auth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    navigate.postValue(true)


                } else {
                    navigate.postValue(false)
                    data.postValue(
                        task.exception?.localizedMessage
                    )

                }
            }


    }
}