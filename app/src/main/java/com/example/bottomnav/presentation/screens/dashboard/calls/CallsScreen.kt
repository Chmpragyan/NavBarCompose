package com.example.bottomnav.presentation.screens.dashboard.calls

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bottomnav.R
import com.example.bottomnav.domain.model.CallLog
import com.example.bottomnav.presentation.navigation.Screen

@Composable
fun CallsScreen(navController: NavController) {
    Box(modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 0.dp)) {
        RecyclerView(
            dummyData(),
            onItemClick = { navController.navigate(Screen.ContactDetail.route) })
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
        CallLog(R.drawable.ic_incoming_call, "Hell World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hell World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hell World", "8:02"),
        CallLog(R.drawable.ic_incoming_call, "Hell00 World", "8:02"),
    )
}

@Composable
fun RecyclerView(callLogs: List<CallLog>, onItemClick: (CallLog) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(callLogs.size) { index ->
            val callLogItem = callLogs[index]
            Row(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .clickable { onItemClick(callLogItem) },
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = callLogItem.icon),
                    contentDescription = "Call Log type: ${callLogItem.name}",
                    tint = colorResource(R.color.primary500)
                )
                Text(text = callLogItem.name, fontSize = 14.sp)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = callLogItem.date, fontSize = 12.sp)
            }
        }
    }
}