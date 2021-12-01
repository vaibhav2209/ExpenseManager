package com.example.expensemanager.model

import androidx.annotation.Nullable

data class User(
    val username: String?,
    val email:String?,
    @Nullable
    val phone: String?,
    val isEmailVerified: Boolean,
    val providerId: String,
    val uId: String
)
