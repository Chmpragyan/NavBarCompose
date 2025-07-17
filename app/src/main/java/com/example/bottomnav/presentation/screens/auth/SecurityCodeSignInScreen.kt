package com.example.bottomnav.presentation.screens.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        }
    }
}