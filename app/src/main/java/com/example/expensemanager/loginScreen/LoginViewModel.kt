package com.example.expensemanager.loginScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensemanager.utils.Resource
import com.example.expensemanager.viewModel.BaseViewModel
import com.example.expensemanager.viewModel.MainRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (
    private val repository: MainRepository
): BaseViewModel() {

    private val _userEmail = mutableStateOf("")
    val userEmail: State<String> = _userEmail

    private val _userPassword = mutableStateOf("")
    val userPassword: State<String> = _userPassword

    private val _userData = MutableLiveData<Resource<FirebaseUser>>(Resource.Loading())
    val userData:LiveData<Resource<FirebaseUser>> = _userData


    fun setUserEmail(email: String){
        _userEmail.value = email
    }

    fun setUserPassword(password: String){
        _userPassword.value = password
    }


    fun registerUserWithEmail(email: String, password: String) = viewModelScope.launch(Dispatchers.IO) {
        _userData.value = Resource.Loading()

        repository.registerUserWithEmail(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                task.result?.user?.let { user ->
                    _userData.value = Resource.Success(user)
                }
            } else {
                task.exception?.let { exception ->
                    _userData.value = Resource.Error(exception)
                }
            }
        }

    }

    fun signInWithEmail(email: String, password: String) = viewModelScope.launch(Dispatchers.IO) {
        _userData.value = Resource.Loading()

        repository.signInUserWithEmail(email, password).addOnCompleteListener {task->
            if (task.isSuccessful) {
                task.result?.user?.let { user ->
                    Timber.d("viewModel called: ${user.email}")
                    _userData.value = Resource.Success(user)
                }
            } else {
                task.exception?.let { exception ->

                    _userData.value = Resource.Error(exception)
                }
            }
        }

    }

    @ExperimentalCoroutinesApi
    fun signInWithEmailAndPassword() = viewModelScope.launch {
        _userData.value = Resource.Loading()

        repository.signInUserWithEmailAndPassword(userEmail.value, userPassword.value).collect { user->
            _userData.value = user
        }
    }

    fun currentUser() = viewModelScope.launch(Dispatchers.IO) {
        _userData.value = Resource.Loading()

        repository.currentUser().also { firebaseUser ->
            if (firebaseUser != null){
                _userData.value =  Resource.Success(firebaseUser)
            } else {
                _userData.value = Resource.Error(Exception("User logged out"))
            }
        }
    }


}