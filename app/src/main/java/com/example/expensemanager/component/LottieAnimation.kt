package com.example.expensemanager.component

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.*

@Composable
fun LottieAnim(
    @RawRes lottieFile: Int,
    autoPlay:Boolean = true,
    iterations: Int = LottieConstants.IterateForever,
    modifier: Modifier
    ) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(lottieFile))
    val animationState by animateLottieCompositionAsState (
        composition = composition,
        iterations = iterations,
        restartOnPlay = autoPlay
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        LottieAnimation(
            composition = composition,
            animationState
        )
    }
}