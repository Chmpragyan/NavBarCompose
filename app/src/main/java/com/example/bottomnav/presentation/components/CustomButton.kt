package com.example.bottomnav.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    backgroundColor: Color = Color.Transparent,
    borderColor: Color = Color.Black,
    borderWidth: Dp = 1.dp,
    textColor: Color = Color.Black,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            disabledContainerColor = backgroundColor
        ),
        border = BorderStroke(borderWidth, borderColor),
        modifier = modifier,
        enabled = enabled
    ) {
        Text(text, color = textColor)
    }
}