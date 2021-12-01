package com.example.expensemanager.feature_login.presentation.registration

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.expensemanager.common.utils.Constants.UNKNOWN_ERROR
import com.example.expensemanager.common.utils.Resource
import com.example.expensemanager.feature_login.data.repository.LoginRepositoryImpl
import com.example.expensemanager.common.viewModel.BaseViewModel
import com.example.expensemanager.feature_login.domain.model.RegisterUser
import com.example.expensemanager.feature_login.domain.use_cases.RegisterUserUseCase
import com.example.expensemanager.feature_login.domain.use_cases.SignInUserUseCase
import com.example.expensemanager.feature_login.presentation.registration.RegisterState
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor (
    private val registerUserUseCase: RegisterUserUseCase
): BaseViewModel() {

    private val _userEmail = mutableStateOf("")
    val userEmail: State<String> = _userEmail

    private val _userPassword = mutableStateOf("")
    val userPassword: State<String> = _userPassword

    private val _userData = MutableLiveData<Resource<FirebaseUser>>(Resource.Loading())
    val userData: LiveData<Resource<FirebaseUser>> = _userData

    private val _registerState = mutableStateOf(RegisterState())
    val registerState: State<RegisterState> = _registerState


    fun setUserEmail(email: String) {
        _userEmail.value = email
    }

    fun setUserPassword(password: String) {
        _userPassword.value = password
    }

    fun registerUserWithEmailAndPassword(registerUser: RegisterUser) = viewModelScope.launch{
        registerUserUseCase.registerUserWithEmailAndPassword(registerUser)
            .collect { resource->
            when (resource){
                is Resource.Success->{
                    _registerState.value = RegisterState(user = resource.data)
                }
                is Resource.Error->{
                    _registerState.value = RegisterState(error = resource.message ?: UNKNOWN_ERROR)
                }
                is Resource.Loading->{
                    _registerState.value = RegisterState(isLoading = true)
                }
            }
        }
    }


}