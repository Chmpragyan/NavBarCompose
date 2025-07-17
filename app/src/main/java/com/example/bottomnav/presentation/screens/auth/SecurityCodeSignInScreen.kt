package com.example.bottomnav.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomnav.R

@Preview
@Composable
fun SecurityCodeSignInScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(58.dp))
            IconWithText(
                iconRes = R.drawable.splash_logo,
                iconContentDescription = stringResource(R.string.app_name),
                text = stringResource(R.string.your_business_communication_companion),
                textColor = colorResource(R.color.on_background),
                spaceAfterIcon = 16.dp
            )
            Spacer(modifier = Modifier.height(116.dp))
            Text(
                stringResource(R.string.enter_security_code),
                color = colorResource(R.color.on_background),
                lineHeight = 12.sp,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            OtpField()
        }
    }
}

@Composable
fun OtpField() {
    var otpValue by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }

    BasicTextField(
        value = otpValue,
        onValueChange = {
            if (it.length <= 6) {
                otpValue = it
            }
        },
        modifier = Modifier.focusRequester(focusRequester),
        keyboardOptions = KeyboardOptions(
            showKeyboardOnFocus = true,
            keyboardType = KeyboardType.Number
        ),
        decorationBox = {
            Row {
                repeat(6) { index ->
                    val char = when {
                        index >= otpValue.length -> ""
                        else -> otpValue[index].toString()
                    }
                    val isFocused =
                        (index == otpValue.length) || (otpValue.length == 6 && index == 5)

                    OtpBox(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .background(Color.Transparent),
                        text = char,
                        isFocused = isFocused
                    )
                    Spacer(Modifier.width(8.dp))
                }
            }
        }
    )
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}

@Composable
fun OtpBox(
    modifier: Modifier,
    text: String,
    isFocused: Boolean
) {
    Box(
        modifier = modifier
            .border(
                2.dp,
                if (isFocused) colorResource(R.color.primary) else colorResource(R.color.pin_box_color),
                RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.W500,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}