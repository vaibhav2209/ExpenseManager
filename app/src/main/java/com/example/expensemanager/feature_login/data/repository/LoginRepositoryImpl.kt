package com.example.expensemanager.feature_login.data.repository

import com.example.expensemanager.feature_login.data.data_source.LoginFirebaseService
import com.example.expensemanager.feature_login.domain.model.RegisterUser
import com.example.expensemanager.feature_login.domain.repository.LoginRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class LoginRepositoryImpl@Inject constructor(
    private val loginFirebaseService: LoginFirebaseService
): LoginRepository {

    override fun registerUserWithEmailAndPassword(registerUser: RegisterUser): Task<AuthResult> {
        return loginFirebaseService.createUserWithEmailAndPassword(registerUser)
    }

    override fun signInUserWithEmailAndPassword(email: String, password: String): Task<AuthResult> {
        return loginFirebaseService.signInWithEmailAndPassword(email, password)
    }

    override fun currentUser(): FirebaseUser? {
        return loginFirebaseService.currentUser()
    }
}