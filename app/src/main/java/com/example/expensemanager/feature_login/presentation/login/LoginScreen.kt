package com.example.expensemanager.feature_login.presentation.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.expensemanager.R
import com.example.expensemanager.feature_login.presentation.login.components.CustomTextField
import com.example.expensemanager.navigation.Screen
import com.example.expensemanager.ui.theme.*
import com.example.expensemanager.common.utils.Constants
import com.example.expensemanager.common.utils.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val name by viewModel.userData.observeAsState()
    LoginScreenBody(navController = navController)
    viewModel.signInUserWithEmailAndPassword("vaibhavpatel221997@gmail.com", "123456" )
}

@ExperimentalCoroutinesApi
@Composable
fun LoginScreenBody(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {
    val context = LocalContext.current

    var emailError by remember {
        mutableStateOf(false)
    }

    var passwordError by remember {
        mutableStateOf(false)
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(color = ThemeBackgroundDark)
            .padding(top = 50.dp, bottom = 24.dp, start = 24.dp, end = 24.dp)

    ){

        Column(
            Modifier
                .fillMaxWidth()
                .align(Center)
        ) {

            Image(
                painter = painterResource(id = R.drawable.login_illustration),
                contentDescription = "login_illustration",
                modifier = Modifier
                    .fillMaxHeight(0.24f)
                    .align(CenterHorizontally)
            )

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(24.dp))

            LoginFields(
                email = viewModel.userEmail.value,
                password = viewModel.userPassword.value,
                onEmailChange = {
                    viewModel.setUserEmail(it)
                },
                onPasswordChange = {
                    viewModel.setUserPassword(it)
                },
                emailError = emailError,
                passwordError = passwordError,
            ) {
                val email = viewModel.userEmail.value
                val password = viewModel.userPassword.value

                emailError = (email.isEmpty() || '@' !in email || email.count() < 5)
                passwordError =  (password.isEmpty())

                if (!emailError && !passwordError){
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                }
            }

            Spacer(modifier = Modifier
                .fillMaxHeight(0.2f))

            Text(
                text = Constants.loginUsing,
                style = RegularDescription2_60,
                modifier = Modifier
                    .align(CenterHorizontally)
            )

            Spacer(modifier = Modifier
                .height(20.dp)
                .fillMaxWidth())

            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "Login using google",
                modifier = Modifier
                    .size(width = 24.dp, height = 24.dp)
                    .align(CenterHorizontally)
                    .clickable {
                        Toast
                            .makeText(
                                context,
                                "google clicked",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
            )

        }

        Text(
            text = buildAnnotatedString {
                append(Constants.newToExpenseManager)
                withStyle(style = SpanStyle(
                    color = ThemeBlue
                )){
                    append(" ")
                    append(Constants.signUp)
                }
            },
            style = RegularDescription2_60,
            modifier = Modifier
                .align(BottomCenter)
                .clickable {
                    navController.navigate(Screen.RegisterScreen.route)
                }
        )
    }

    when(val result = viewModel.userData.value){
        is Resource.Loading->{

        }

        is Resource.Success->{

        }

        is Resource.Error->{

        }
    }

}

@Composable
fun LoginFields(
    email:String,
    password:String,
    emailError:Boolean = false,
    passwordError:Boolean = false,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginBtnClick: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Login",
            style = LargeHeading1,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        CustomTextField(
            value = email,
            hint = Constants.email,
            keyboardType = KeyboardType.Email,
            onValueChange = onEmailChange,
            isError = emailError
        )

        Spacer(modifier = Modifier
            .height(12.dp)
            .fillMaxWidth())

        CustomTextField(
            value = password,
            hint = Constants.password,
            keyboardType = KeyboardType.Password,
            onValueChange = onPasswordChange,
            isError = passwordError
        )

        Spacer(modifier = Modifier
            .height(34.dp)
            .fillMaxWidth())

        TextButton(
            onClick = onLoginBtnClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    color = ThemeBlue,
                    shape = RoundedCornerShape(12.dp)
                )

        ) {
            Text(
                text = Constants.login,
                style = MediumButton,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }
    }
}


