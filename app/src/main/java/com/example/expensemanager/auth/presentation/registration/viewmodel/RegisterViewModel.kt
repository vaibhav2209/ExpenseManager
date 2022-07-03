package com.example.expensemanager.auth.presentation.registration.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensemanager.common.utils.Constants.UNKNOWN_ERROR
import com.example.expensemanager.common.utils.Resource
import com.example.expensemanager.common.viewModel.BaseViewModel
import com.example.expensemanager.auth.domain.model.RegisterUser
import com.example.expensemanager.auth.domain.use_cases.AuthUseCases
import com.example.expensemanager.auth.domain.use_cases.RegisterUserUseCase
import com.example.expensemanager.auth.presentation.registration.RegisterState
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor (
    private val authUseCases: AuthUseCases
): ViewModel() , RegisterViewModelContract {


    private val registerUiState = mutableStateOf(RegisterState())

    override fun registerUserWithEmailAndPassword(registerUser: RegisterUser){
        viewModelScope.launch {
            registerUiState.value = RegisterState(isLoading = true)

            authUseCases.ucRegisterUserUseCase(registerUser).catch { e->
                registerUiState.value = RegisterState(
                    isLoading = false,
                    error = e.message ?: UNKNOWN_ERROR
                )
            }.collect { user ->
                registerUiState.value = RegisterState(
                    isLoading = false,
                    user = user
                )
            }
        }

    }

    override fun doObserverRegisterState(): State<RegisterState> =
        registerUiState


}