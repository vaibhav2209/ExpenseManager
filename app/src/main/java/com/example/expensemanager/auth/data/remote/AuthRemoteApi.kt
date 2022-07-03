package com.example.expensemanager.auth.data.remote

import com.example.expensemanager.auth.domain.model.RegisterUser
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRemoteApi {

    private val mAuth =  FirebaseAuth.getInstance()

    fun createUserWithEmailAndPassword(registerUser: RegisterUser): Task<AuthResult> {
        return mAuth.createUserWithEmailAndPassword(registerUser.email, registerUser.password)
    }

    fun signInWithEmailAndPassword(email: String, password: String): Task<AuthResult> {
        return mAuth.signInWithEmailAndPassword(email, password)
    }

    fun currentUser(): FirebaseUser? {
        return mAuth.currentUser
    }
}