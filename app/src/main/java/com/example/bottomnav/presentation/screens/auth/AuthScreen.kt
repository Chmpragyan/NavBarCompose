package com.example.bottomnav.presentation.screens.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomnav.R
import com.example.bottomnav.presentation.components.CustomButton

@Composable
fun AuthScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
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

        Column(
            modifier = Modifier
                .padding(top = 264.dp)
                .matchParentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painterResource(R.drawable.image_qr),
                contentDescription = stringResource(R.string.scan_qr),
                tint = Color.Unspecified,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(R.string.scan_qr),
                fontSize = 20.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            )
            Text(
                text = stringResource(R.string.tap_to_open_scanner),
                Modifier.padding(top = 16.dp),
                color = colorResource(R.color.on_surface_variant)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 52.dp),
        ) {
            Row(
                modifier = Modifier.padding(bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(0.2f),
                    thickness = 1.dp,
                    color = colorResource(R.color.outline)
                )
                Text(
                    "Or",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    color = colorResource(R.color.on_surface_variant)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(0.2f),
                    thickness = 1.dp,
                    color = colorResource(R.color.outline)
                )
            }

            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                text = stringResource(
                    R.string.sign_in_with_security_code,
                ),
                onClick = { },
                textColor = colorResource(R.color.on_muted_container),
                backgroundColor = Color.Transparent,
                borderColor = colorResource(R.color.muted_outline),
                shape = RoundedCornerShape(8.dp),
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
    spaceAfterIcon: Dp,
    textColor: Color
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
        Text(text = text, color = textColor)
    }
}