package com.example.expensemanager.auth.presentation.registration.viewmodel

import androidx.compose.runtime.State
import com.example.expensemanager.auth.domain.model.RegisterUser
import com.example.expensemanager.auth.presentation.registration.RegisterState

interface RegisterViewModelContract {

    fun registerUserWithEmailAndPassword(registerUser: RegisterUser)

    fun doObserverRegisterState(): State<RegisterState>
}