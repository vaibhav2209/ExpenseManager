package com.example.expensemanager.model

import androidx.annotation.Nullable

data class User(
    val name: String,
    val email:String,
    @Nullable
    val phone: String,
    val uId: String
)
