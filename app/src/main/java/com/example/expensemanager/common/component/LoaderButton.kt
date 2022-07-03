package com.example.expensemanager.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensemanager.common.utils.Constants
import com.example.expensemanager.ui.theme.MediumButton
import com.example.expensemanager.ui.theme.ThemeBlue

@Composable
fun LoaderButton(
    modifier: Modifier = Modifier,
    btnText: String,
    isLoading: Boolean,
    onBtnClick: () -> Unit
) {
    Button(
        onClick = onBtnClick,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = ThemeBlue)

    ) {
        if (isLoading) {
            Loader()
        } else {
            Text(
                text = btnText,
                style = MediumButton,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }

    }
}

@Preview
@Composable
fun PreviewLoaderButton() {
    val isLoad = remember {
        mutableStateOf(false)
    }
    LoaderButton(
        isLoading = isLoad.value,
        btnText = "Login",
        onBtnClick = {
            isLoad.value = !isLoad.value
        }
    )
}