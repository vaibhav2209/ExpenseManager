package com.example.expensemanager.auth.domain.repository

import com.example.expensemanager.auth.domain.model.RegisterUser
import com.example.expensemanager.model.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface IAuthRepository {
    fun signInUserWithEmailAndPassword(email: String, password: String): Task<AuthResult>
    fun currentUser(): FirebaseUser?
    fun registerUserWithEmailAndPassword(registerUser: RegisterUser): Flow<User>
}