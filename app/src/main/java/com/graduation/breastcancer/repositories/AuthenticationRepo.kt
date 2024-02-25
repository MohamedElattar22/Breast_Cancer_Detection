package com.graduation.breastcancer.repositories

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthenticationRepo {
    suspend fun signUpUser(email:String , password:String): Task<AuthResult?>

}