package com.example.bottomnav.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bottomnav.R
import com.example.bottomnav.presentation.components.CustomButton
import com.example.bottomnav.presentation.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecurityCodeSignInScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    var otpValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth(),
            title = { Text("") },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp()}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Back"
                    )
                }
            },
        )
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(38.dp))
            IconWithText(
                iconRes = R.drawable.splash_logo,
                iconContentDescription = stringResource(R.string.app_name),
                text = stringResource(R.string.your_business_communication_companion),
                textColor = colorResource(R.color.on_background),
                spaceAfterIcon = 16.dp
            )
            Spacer(modifier = Modifier.height(84.dp))
            Text(
                stringResource(R.string.enter_security_code),
                color = colorResource(R.color.on_background),
                lineHeight = 12.sp,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            OtpField(
                otpValue,
                onOtpChange = { newValue ->
                    otpValue = newValue
                }
            )
        }

        Box(
            Modifier.padding(bottom = 48.dp)
        ) {
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                text = stringResource(
                    R.string.sign_in,
                ),
                onClick = { },
                textColor = colorResource(R.color.white),
                backgroundColor = if (otpValue.length == 6) {
                    colorResource(R.color.primary)
                } else {
                    colorResource(R.color.bg_button_disabled)
                },
                borderColor = colorResource(R.color.bg_button_disabled),
                shape = RoundedCornerShape(8.dp),
                enabled = otpValue.length == 6
            )
        }
    }
}

@Composable
fun OtpField(otpValue: String, onOtpChange: (String) -> Unit) {
    val focusRequester = remember { FocusRequester() }

    BasicTextField(
        value = otpValue,
        onValueChange = {
            if (it.length <= 6) {
                onOtpChange(it)
            }
        },
        modifier = Modifier.focusRequester(focusRequester),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
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