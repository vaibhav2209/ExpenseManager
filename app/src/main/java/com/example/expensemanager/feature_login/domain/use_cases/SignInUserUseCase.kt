package com.example.expensemanager.feature_login.domain.use_cases

import com.example.expensemanager.common.utils.Resource
import com.example.expensemanager.feature_login.domain.repository.LoginRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import timber.log.Timber
import javax.inject.Inject

class SignInUserUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    @ExperimentalCoroutinesApi
    fun signInUserWithEmailAndPassword(email:String, password:String) = callbackFlow<Resource<FirebaseUser>> {
        trySend(Resource.Loading())
       loginRepository.signInUserWithEmailAndPassword(email, password).addOnSuccessListener {
           it?.user?.let { user ->
               trySend(Resource.Success(user))
           }

        }.addOnFailureListener { e->
           trySend(Resource.Error(e.message ?: "Unknown error occurred"))
       }
        awaitClose {  }
    }
}