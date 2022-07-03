package com.example.expensemanager.auth.presentation.registration

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.expensemanager.R
import com.example.expensemanager.auth.presentation.login.components.AppTextField
import com.example.expensemanager.auth.presentation.registration.viewmodel.RegisterViewModel
import com.example.expensemanager.common.component.LoaderButton
import com.example.expensemanager.common.utils.Constants
import com.example.expensemanager.navigation.Screen
import com.example.expensemanager.ui.theme.LargeHeading1
import com.example.expensemanager.ui.theme.RegularDescription2_60
import com.example.expensemanager.ui.theme.ThemeBackgroundDark
import com.example.expensemanager.ui.theme.ThemeBlue

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {

}


@Composable
fun RegisterBody(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .background(ThemeBackgroundDark)
            .padding(top = 50.dp, bottom = 20.dp)
            .padding(horizontal = 24.dp)
    ) {

        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Image(
                painter = painterResource(id = R.drawable.vg_register),
                contentDescription = "Register Illustration"
            )

            Text(
                text = stringResource(id = R.string.register),
                style = LargeHeading1,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(bottom = 15.dp, top = 50.dp)
            )

           RegisterFields(
               modifier = Modifier.padding(top = 15.dp)
           )

            LoaderButton(
                modifier = Modifier.padding(top = 34.dp),
                btnText = stringResource(id = R.string.register),
                isLoading = false
            ) {

            }

            SocialLogin(
                modifier = Modifier
                    .padding(top = 42.dp),
                onGoogleClick = {

                }
            )

        }

        Text(
            text = buildAnnotatedString {
                append(Constants.alreadyHaveAccount)
                withStyle(style = SpanStyle(
                    color = ThemeBlue
                )){
                    append(" ")
                    append(Constants.login)
                }
            },
            style = RegularDescription2_60,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {

                }
        )
    }
}

@Composable
fun RegisterFields(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        val name = remember {
            mutableStateOf("")
        }

        val password = remember {
            mutableStateOf("")
        }

        val email = remember {
            mutableStateOf("")
        }

        AppTextField(
            value = name.value,
            hint = stringResource(id = R.string.name),
            onValueChange = {
                name.value = it
            }
        )

        Spacer(
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
        )

        AppTextField(
            value = email.value,
            hint = stringResource(id = R.string.email),
            keyboardType = KeyboardType.Email,
            onValueChange = {
                email.value = it
            }
        )

        Spacer(
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
        )

        AppTextField(
            value = password.value,
            hint = stringResource(id = R.string.password),
            keyboardType = KeyboardType.Password,
            onValueChange = {
                password.value = it
            }
        )

    }
}


@Composable
fun SocialLogin(
    modifier: Modifier = Modifier,
     onGoogleClick:() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = Constants.loginUsing,
            style = RegularDescription2_60,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
        )

        Image(
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = "Login using google",
            modifier = Modifier
                .padding(5.dp)
                .size(width = 24.dp, height = 24.dp)
                .align(Alignment.CenterHorizontally)
                .clickable(onClick = onGoogleClick)
        )
    }

}


@Preview
@Composable
fun PreviewRegister() {
    RegisterBody(

    )

}