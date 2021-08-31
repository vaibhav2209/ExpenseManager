package com.example.expensemanager.model

import com.example.expensemanager.others.CategoryType

data class Transaction(
    val amount : String,
    val category: Category,
    val date: String,
    val note: String,
    val payment_method:String,
    val tag: List<String>,
    val type: CategoryType
)
