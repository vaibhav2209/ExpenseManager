package com.example.expensemanager.feature_login.domain.mapper

import com.example.expensemanager.feature_login.domain.model.RegisterUser
import com.example.expensemanager.model.User
import com.google.firebase.auth.FirebaseUser

fun FirebaseUser.toUser() = User(
    username = displayName,
    email = email,
    phone = phoneNumber,
    isEmailVerified = isEmailVerified,
    providerId = providerId,
    uId = uid
)