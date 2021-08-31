package com.example.expensemanager.viewModel

import com.example.expensemanager.network.FirebaseService
import com.example.expensemanager.utils.Resource
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val firebaseService: FirebaseService
) {

    suspend fun registerUserWithEmail(email:String, password:String): Task<AuthResult> {
        return firebaseService.createUserWithEmailAndPassword(email, password)
    }

    suspend fun signInUserWithEmail(email: String, password: String): Task<AuthResult> {
        return firebaseService.signInWithEmail(email, password)
    }

    @ExperimentalCoroutinesApi
    fun signInUserWithEmailAndPassword(email: String, password: String): Flow<Resource<FirebaseUser>> {
        return firebaseService.signWithEmailAndPassword(email, password)
    }
    suspend fun currentUser() = firebaseService.currentUser()

}