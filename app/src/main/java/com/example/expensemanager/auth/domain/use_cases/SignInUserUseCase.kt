package com.example.expensemanager.auth.domain.use_cases

import com.example.expensemanager.common.utils.Resource
import com.example.expensemanager.auth.domain.repository.IAuthRepository
import com.example.expensemanager.common.utils.Constants
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class SignInUserUseCase @Inject constructor(
    private val IAuthRepository: IAuthRepository
) {

    @ExperimentalCoroutinesApi
    fun signInUserWithEmailAndPassword(email:String, password:String) = callbackFlow<Resource<FirebaseUser>> {
        trySend(Resource.Loading())
       IAuthRepository.signInUserWithEmailAndPassword(email, password).addOnSuccessListener {
           it?.user?.let { user ->
               trySend(Resource.Success(user))
           }

        }.addOnFailureListener { e->
           trySend(Resource.Error(e.message ?: Constants.UNKNOWN_ERROR))
       }
        awaitClose {  }
    }
}