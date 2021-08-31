package com.example.expensemanager.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.expensemanager.R

// Set of Material typography styles to start with
val montserrat = FontFamily(
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        color = White
    ),
    h2 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        color = White
    ),
    subtitle1 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = White60
    ),
    body1 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = White
    ),

    body2 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = White60
    )
)

val LargeHeading1 = TextStyle(
    fontFamily = montserrat,
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
    color = White
)

val LargeHeading2 = TextStyle(
    fontFamily = montserrat,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    color = White
)

val MediumHeading1 = TextStyle(
    fontFamily = montserrat,
    fontWeight = FontWeight.Medium,
    fontSize = 18.sp,
    color = White
)

val MediumHeading2 = TextStyle(
    fontFamily = montserrat,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    color = White
)


val MediumHeading2_60 = TextStyle(
    fontFamily = montserrat,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    color = White60
)

val RegularBody = TextStyle(
    fontFamily = montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    color = White
)

val RegularBody60 = TextStyle(
    fontFamily = montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    color = White60
)

val RegularDescription1 = TextStyle(
    fontFamily = montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    color = White
)

val RegularDescription1_60 = TextStyle(
    fontFamily = montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    color = White60
)

val RegularDescription2 = TextStyle(
    fontFamily = montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    color = White
)

val RegularDescription2_60 = TextStyle(
    fontFamily = montserrat,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    color = White60
)

val MediumButton = TextStyle(
    fontFamily = montserrat,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    color = White
)



