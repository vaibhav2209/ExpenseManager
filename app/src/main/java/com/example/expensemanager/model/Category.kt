package com.example.expensemanager.model

import com.example.expensemanager.others.CategoryType

data class Category(
    val name: String,
    val type: CategoryType,
    val colour: String,
    val note: String,
    val icon: Int
)