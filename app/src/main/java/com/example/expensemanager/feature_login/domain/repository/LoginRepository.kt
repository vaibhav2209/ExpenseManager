package com.example.expensemanager.feature_login.domain.repository

import com.example.expensemanager.feature_login.domain.model.RegisterUser
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

interface LoginRepository {
    fun registerUserWithEmailAndPassword(registerUser: RegisterUser): Task<AuthResult>
    fun signInUserWithEmailAndPassword(email: String, password: String): Task<AuthResult>
    fun currentUser(): FirebaseUser?
}