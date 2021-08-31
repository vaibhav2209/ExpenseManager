package com.example.expensemanager.network

import com.example.expensemanager.utils.Resource
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.callbackFlow
import timber.log.Timber


class FirebaseService {

    private val mAuth = FirebaseAuth.getInstance()

    suspend fun createUserWithEmailAndPassword(email: String, password: String): Task<AuthResult> {
        return mAuth.createUserWithEmailAndPassword(email, password)
    }

    suspend fun signInWithEmail(email: String, password: String): Task<AuthResult> {
        return mAuth.signInWithEmailAndPassword(email, password)
    }

    @ExperimentalCoroutinesApi
    fun signWithEmailAndPassword(email:String, password: String): Flow<Resource<FirebaseUser>> = callbackFlow {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    task.result?.user?.let { user ->
                        trySend(Resource.Success(user))
                    }
                }
            }
            .addOnFailureListener { e ->
                trySend(Resource.Error(e))
                close(e)
            }
    }



    suspend fun currentUser(): FirebaseUser? {
        return mAuth.currentUser
    }
}