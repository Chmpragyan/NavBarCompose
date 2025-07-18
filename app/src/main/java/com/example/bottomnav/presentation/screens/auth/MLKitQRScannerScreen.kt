package com.example.bottomnav.presentation.screens.auth

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.bottomnav.R
import com.example.bottomnav.presentation.components.CutOutShape
import com.example.bottomnav.utils.QRCodeAnalyzer
import java.util.concurrent.Executors

@Composable
fun MLKitQRScannerScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            CameraPreview(modifier = Modifier.fillMaxSize())

//            QRScannerTargetBackground(modifier = Modifier.fillMaxSize())

            BackIconButton(
                modifier = Modifier.padding(top = 12.dp, start = 4.dp), onTap = {}
            )
        }
    }
}

@Composable
fun CameraPreview(modifier: Modifier) {
    val configuration = LocalConfiguration.current
    val height = configuration.screenHeightDp.dp
    AndroidView(
        { context ->
            val cameraExecutor = Executors.newSingleThreadExecutor()
            val previewView = PreviewView(context).also {
                it.scaleType = PreviewView.ScaleType.FILL_CENTER
            }
            val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
            cameraProviderFuture.addListener({
                val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

                val preview = Preview.Builder()
                    .build()
                    .also {
                        it.surfaceProvider = previewView.surfaceProvider
                    }
                val imageCapture = ImageCapture.Builder().build()

                val imageAnalyzer = ImageAnalysis.Builder()
                    .build()
                    .also {
                        it.setAnalyzer(cameraExecutor, QRCodeAnalyzer {
                            Toast.makeText(context, "Barcode found", Toast.LENGTH_SHORT).show()
                        })
                    }

                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

                try {
                    cameraProvider.unbindAll()

                    cameraProvider.bindToLifecycle(
                        context as ComponentActivity,
                        cameraSelector,
                        preview,
                        imageCapture,
                        imageAnalyzer
                    )

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }, ContextCompat.getMainExecutor(context))
            previewView
        }, modifier = Modifier
            .clip(CutOutShape(height / 1.2f))
    )
}

@Composable
private fun BackIconButton(
    modifier: Modifier = Modifier, onTap: () -> Unit
) {
    Icon(painter = painterResource(R.drawable.ic_back),
        contentDescription = "Back",
        tint = MaterialTheme.colorScheme.surface,
        modifier = modifier
            .size(48.dp)
            .background(Color.Transparent)
            .padding(12.dp)
            .clickable { onTap() })
}