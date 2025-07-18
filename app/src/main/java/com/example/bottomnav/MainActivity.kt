package com.example.bottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnav.presentation.components.BottomNav
import com.example.bottomnav.presentation.components.navigationItems
import com.example.bottomnav.presentation.navigation.NavGraph
import com.example.bottomnav.presentation.navigation.Screen
import com.example.bottomnav.presentation.screens.auth.AuthScreen
import com.example.bottomnav.presentation.screens.auth.SecurityCodeSignInScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SecurityCodeSignInScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomNavRoutes = navigationItems.map { it.route }
    val showBottomNav = currentRoute in bottomNavRoutes

    val currentScreen = when (currentRoute) {
        Screen.Calls.route -> Screen.Calls
        Screen.Messages.route -> Screen.Messages
        Screen.Keypad.route -> Screen.Keypad
        Screen.Contacts.route -> Screen.Contacts
        Screen.Account.route -> Screen.Account
        Screen.ContactDetail.route -> Screen.ContactDetail
        else -> null
    }
    val showTopBar = currentScreen != null
    val showTopBarWithBack = currentRoute == Screen.ContactDetail.route

    Scaffold(
        topBar = {
            if (showTopBar) {
                TopAppBar(
                    modifier = Modifier.height(60.dp),
                    title = {
                        Text(
                            text = currentScreen?.title ?: "",
                            textAlign = TextAlign.End,
                            fontSize = 18.sp
                        )
                    },
                    navigationIcon = {
                        if (showTopBarWithBack) {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    },
                )
            }
        },
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomNav) {
                BottomNav(navController = navController)
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavGraph(navController = navController)
        }
    }
}