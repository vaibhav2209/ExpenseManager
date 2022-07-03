package com.example.expensemanager.auth.domain.use_cases

data class AuthUseCases(
    val ucRegisterUserUseCase: RegisterUserUseCase,
    val ucSignInUserUseCase: SignInUserUseCase
)
