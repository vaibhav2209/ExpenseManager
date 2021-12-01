package com.example.expensemanager.feature_login.presentation.registration

import com.example.expensemanager.model.User

data class RegisterState(
    val isLoading:Boolean = false,
    val user: User? = null,
    val error: String = ""
)
