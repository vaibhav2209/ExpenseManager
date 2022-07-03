package com.example.expensemanager.auth.data.repository

import com.example.expensemanager.auth.data.remote.AuthRemoteApi
import com.example.expensemanager.auth.domain.mapper.toUser
import com.example.expensemanager.auth.domain.model.RegisterUser
import com.example.expensemanager.auth.domain.repository.IAuthRepository
import com.example.expensemanager.common.utils.Constants
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.userProfileChangeRequest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class IAuthRepositoryImpl@Inject constructor(
    private val authRemoteApi: AuthRemoteApi
): IAuthRepository {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun registerUserWithEmailAndPassword(registerUser: RegisterUser)= callbackFlow {
        authRemoteApi.createUserWithEmailAndPassword(registerUser).addOnSuccessListener {
            it?.user?.let { firebaseUser ->
                val profileUpdates = userProfileChangeRequest {
                    this.displayName = registerUser.username
                }
                firebaseUser.updateProfile(profileUpdates)
                    .addOnSuccessListener {
                        trySend(firebaseUser.toUser())
                    }
                    .addOnFailureListener {e->
                        throw Exception(e.message ?: Constants.UNKNOWN_ERROR)
                    }
            }

        }.addOnFailureListener { e->
            throw Exception(e.message ?: Constants.UNKNOWN_ERROR)
        }
        awaitClose {  }
    }

    override fun signInUserWithEmailAndPassword(email: String, password: String): Task<AuthResult> {
        return authRemoteApi.signInWithEmailAndPassword(email, password)
    }

    override fun currentUser(): FirebaseUser? {
        return authRemoteApi.currentUser()
    }
}