package com.example.expensemanager.auth.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.expensemanager.common.utils.Resource
import com.example.expensemanager.auth.data.repository.IAuthRepositoryImpl
import com.example.expensemanager.auth.domain.repository.IAuthRepository
import com.example.expensemanager.common.viewModel.BaseViewModel
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (
): BaseViewModel() {


}