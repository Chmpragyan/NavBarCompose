package com.example.bottomnav.presentation.components

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class CutOutShape(private val sizeDp: Dp) : Shape {
    override fun createOutline(
        size: Size, layoutDirection: LayoutDirection, density: Density
    ): Outline {
        val cutOutSizePx = with(density){sizeDp.toPx() * 0.20f}
        val cornerRadiusPx = with(density){12f.dp.toPx()}
        val center = Offset(size.width / 2f, size.height / 2f)

        // Full screen path
        val outlinePath = Path().apply {
            addRect(Rect(Offset(0f, 0f), size)) // Full size
        }

        // Cutout path in the center
        val cutOutPath = Path().apply {
            addRoundRect(
                RoundRect(
                    Rect(
                        topLeft = center - Offset(cutOutSizePx, cutOutSizePx),
                        bottomRight = center + Offset(cutOutSizePx, cutOutSizePx)
                    ), CornerRadius(cornerRadiusPx, cornerRadiusPx)
                )
            )
        }

       // Combine the paths: Create a transparent cutout in the middle and retain the corners
        val finalPath = Path.combine(
            PathOperation.Difference, outlinePath, cutOutPath
        )

        return Outline.Generic(finalPath)
    }
}