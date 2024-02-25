package com.graduation.breastcancer.repositories

import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class AuthenticationImpl(
) : AuthenticationRepo {
    override suspend fun signUpUser(email: String, password: String): Task<AuthResult?> {
        val auth  = Firebase.auth
        val result = auth.createUserWithEmailAndPassword(email,password)
        return result
    }
}