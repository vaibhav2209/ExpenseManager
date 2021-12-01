package com.example.expensemanager.feature_login.presentation.login

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
class LoginViewModel @Inject constructor (
    private val loginRepository: LoginRepositoryImpl,
    private val signInUserUseCase: SignInUserUseCase
): BaseViewModel() {

    private val _userEmail = mutableStateOf("")
    val userEmail: State<String> = _userEmail

    private val _userPassword = mutableStateOf("")
    val userPassword: State<String> = _userPassword

    private val _userData = MutableLiveData<Resource<FirebaseUser>>(Resource.Loading())
    val userData: LiveData<Resource<FirebaseUser>> = _userData


    fun setUserEmail(email: String) {
        _userEmail.value = email
    }

    fun setUserPassword(password: String) {
        _userPassword.value = password
    }


    fun signInUserWithEmailAndPassword(email: String, password: String) =
        viewModelScope.launch(Dispatchers.IO) {

            Timber.tag("FirebaseSetup").d("viewModel Called:")

            signInUserUseCase.signInUserWithEmailAndPassword(email, password)

        }


}