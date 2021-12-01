package com.example.expensemanager.feature_login.data.data_source

import com.example.expensemanager.common.data.FirebaseService
import com.example.expensemanager.common.utils.Resource
import com.example.expensemanager.feature_login.domain.model.RegisterUser
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class LoginFirebaseService:FirebaseService() {

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