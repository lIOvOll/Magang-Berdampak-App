package com.example.androidnative.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidnative.ui.components.ButtonCustom
import com.example.androidnative.ui.components.HeaderScreen

@Composable
fun Screen2(name: String, navController: NavController) {
    val selectedName = remember {
        navController.currentBackStackEntry
            ?.savedStateHandle
            ?.getStateFlow("selected_name", "")
    }?.collectAsState()

    Scaffold(
        containerColor = Color.White,
        topBar = {
            HeaderScreen(
                label = "Second Screen",
                onBackClick = {navController.popBackStack()}
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonCustom(
                    onClick = {
                            navController.navigate("screen3")
                    },
                    label = "Choose a User"
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Welcome",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = name.replaceFirstChar { it.uppercaseChar() },
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = selectedName?.value?.ifEmpty { "Selected User Name" } ?: "Selected User Name",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}