package com.example.bottomnav.presentation.screens.calls

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bottomnav.R
import com.example.bottomnav.domain.model.CallLog

@Composable
fun CallsScreen(navController: NavController) {
    Scaffold { paddingValues ->
        Box(modifier = Modifier
            .fillMaxHeight()
            .padding(paddingValues)) {

        }
    }
}

private fun dummyData(): List<CallLog> {
    return listOf(
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "JHello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "JHello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "JHello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "JHello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "JHello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "JHello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "JHello World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hello World", "8:02"),
    )
}