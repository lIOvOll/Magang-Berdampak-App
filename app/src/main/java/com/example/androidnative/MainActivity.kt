package com.example.androidnative

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidnative.navigation.AppNavigation
import com.example.androidnative.ui.screens.Screen1
import com.example.androidnative.ui.screens.Screen2
import com.example.androidnative.ui.screens.Screen3
import com.example.androidnative.ui.theme.AndroidNativeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidNativeTheme {
                AppNavigation()
            }
        }
    }
}

