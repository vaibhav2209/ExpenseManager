package com.example.expensemanager.auth.domain.use_cases

import com.example.expensemanager.auth.domain.model.RegisterUser
import com.example.expensemanager.auth.domain.repository.IAuthRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val IAuthRepository: IAuthRepository
) {

    @ExperimentalCoroutinesApi
    operator fun invoke(registerUser: RegisterUser) =
        IAuthRepository.registerUserWithEmailAndPassword(registerUser)


}
