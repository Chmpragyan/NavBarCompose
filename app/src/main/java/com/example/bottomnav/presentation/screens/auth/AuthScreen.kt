package com.example.bottomnav.presentation.screens.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bottomnav.R

@Preview
@Composable
fun AuthScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(72.dp))
            IconWithText(
                iconRes = R.drawable.splash_logo,
                iconContentDescription = stringResource(R.string.app_name),
                text = stringResource(R.string.your_business_communication_companion),
                spaceAfterIcon = 16.dp
            )
        }
    }
}

@Composable
fun IconWithText(
    modifier: Modifier = Modifier,
    iconRes: Int,
    iconContentDescription: String,
    text: String,
    spaceAfterIcon: Dp
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = iconContentDescription,
            tint = Color.Unspecified,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(spaceAfterIcon))
        Text(text = text)
    }
}