package com.example.expensemanager.feature_login.domain.use_cases

import com.example.expensemanager.common.utils.Resource
import com.example.expensemanager.feature_login.domain.mapper.toUser
import com.example.expensemanager.feature_login.domain.model.RegisterUser
import com.example.expensemanager.feature_login.domain.repository.LoginRepository
import com.example.expensemanager.model.User
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.userProfileChangeRequest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    fun registerUserWithEmailAndPassword(registerUser: RegisterUser) = callbackFlow<Resource<User>> {
        trySend(Resource.Loading())
        loginRepository.registerUserWithEmailAndPassword(registerUser).addOnSuccessListener {
            it?.user?.let { firebaseUser ->
                val profileUpdates = userProfileChangeRequest {
                    this.displayName = registerUser.username
                }
                firebaseUser.updateProfile(profileUpdates)
                    .addOnSuccessListener {
                        trySend(Resource.Success(firebaseUser.toUser()))
                    }
                    .addOnFailureListener {e->
                        trySend(Resource.Error(e.message ?: "Unknown error occurred"))
                    }
            }

        }.addOnFailureListener { e->
            trySend(Resource.Error(e.message ?: "Unknown error occurred"))
        }
        awaitClose {  }
    }
}
