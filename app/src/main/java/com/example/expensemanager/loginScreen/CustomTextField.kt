package com.example.expensemanager.loginScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.expensemanager.ui.theme.*

@Composable
fun CustomTextField(
    value: String = "",
    hint :String = "",
    isError:Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    maxLine:Int = 1,
    onValueChange: (String) -> Unit
) {

    val isPasswordToggleDisplay by remember {
        mutableStateOf(keyboardType == KeyboardType.Password)
    }


    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    TextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = RegularDescription1,
        placeholder = {
            Text(
                text = hint,
                style = RegularDescription1_60
            )
        },
        maxLines = maxLine,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        isError = isError,
        visualTransformation =
            if (!isPasswordVisible && isPasswordToggleDisplay)
                PasswordVisualTransformation()
            else
                VisualTransformation.None,
        trailingIcon = {
            if (isPasswordToggleDisplay){
                IconButton(onClick = {
                    isPasswordVisible = !isPasswordVisible
                }) {
                    Icon(
                        imageVector = if
                                (isPasswordVisible) Icons.Filled.VisibilityOff
                            else
                                Icons.Filled.Visibility ,
                        contentDescription = "password"
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(12.dp)),
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = White,
            backgroundColor = White.copy(0.06f),
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}