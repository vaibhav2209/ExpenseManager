package com.example.expensemanager.auth.presentation.registration

import com.example.expensemanager.model.User

data class RegisterState(
    val isLoading:Boolean = false,
    val user: User? = null,
    val error: String = ""
)
