package com.example.bottomnav.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.bottomnav.presentation.screens.auth.ScanQRText

@Composable
fun QRScannerTargetBackground(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val height = configuration.screenHeightDp.dp

    Box {
        Box(
            modifier = modifier
                .clip(CutOutShape(height / 1.2f))
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.34f))
        ) // Background with center cutout shape to fit QR target

        QRTargetCanvas(
            modifier = Modifier
                .height(height / 3f)
                .width(height / 3f)
                .align(Alignment.Center)
        )

        ScanQRText(
            modifier = Modifier
                .offset(0.dp, height / 1.5f)
                .padding(top = 24.dp)
        )
    }
}

@Composable
private fun QRTargetCanvas(modifier: Modifier = Modifier) {
    val density = LocalDensity.current

    Canvas(modifier = modifier) {
        // Path drawing logic
        val cornerLengthPx = with(density) { 48.dp.toPx() }
        val strokeWidthPx = with(density) { 3.dp.toPx() }
        val cornerRadiusPx = with(density) { 12.dp.toPx() }
        val lineColor = Color(0xFF159946)

        val path = Path().apply {
            // Top-left corner
            moveTo(cornerRadiusPx, 0f) // Start horizontal line
            lineTo(cornerLengthPx, 0f) // Horizontal line
            moveTo(0f, cornerRadiusPx) // Start vertical line
            lineTo(0f, cornerLengthPx) // Vertical line
            addArc(
                oval = Rect(
                    left = 0f,
                    top = 0f,
                    right = 2 * cornerRadiusPx,
                    bottom = 2 * cornerRadiusPx
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f
            )

            // Top-right corner
            moveTo(size.width - cornerRadiusPx, 0f) // Start horizontal line
            lineTo(size.width - cornerLengthPx, 0f) // Horizontal line
            moveTo(size.width, cornerRadiusPx) // Start vertical line
            lineTo(size.width, cornerLengthPx) // Vertical line
            addArc(
                oval = Rect(
                    left = size.width - 2 * cornerRadiusPx,
                    top = 0f,
                    right = size.width,
                    bottom = 2 * cornerRadiusPx
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f
            )

            // Bottom-left corner
            moveTo(cornerRadiusPx, size.height) // Start horizontal line
            lineTo(cornerLengthPx, size.height) // Horizontal line
            moveTo(0f, size.height - cornerRadiusPx) // Start vertical line
            lineTo(0f, size.height - cornerLengthPx) // Vertical line
            addArc(
                oval = Rect(
                    left = 0f,
                    top = size.height - 2 * cornerRadiusPx,
                    right = 2 * cornerRadiusPx,
                    bottom = size.height
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f
            )

            // Bottom-right corner
            moveTo(size.width - cornerRadiusPx, size.height) // Start horizontal line
            lineTo(size.width - cornerLengthPx, size.height) // Horizontal line
            moveTo(size.width, size.height - cornerRadiusPx) // Start vertical line
            lineTo(size.width, size.height - cornerLengthPx) // Vertical line
            addArc(
                oval = Rect(
                    left = size.width - 2 * cornerRadiusPx,
                    top = size.height - 2 * cornerRadiusPx,
                    right = size.width,
                    bottom = size.height
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f
            )
        }

        drawPath(
            path = path,
            color = lineColor,
            style = Stroke(
                width = strokeWidthPx,
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
        )
    }
}