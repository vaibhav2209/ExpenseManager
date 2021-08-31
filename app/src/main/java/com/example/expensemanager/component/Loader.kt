package com.example.expensemanager.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.expensemanager.R
import com.example.expensemanager.ui.theme.ThemeBackgroundDark

@Composable
fun Loader(

) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnim(
            lottieFile = R.raw.loading,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(0.06f)),
        )


    }
}