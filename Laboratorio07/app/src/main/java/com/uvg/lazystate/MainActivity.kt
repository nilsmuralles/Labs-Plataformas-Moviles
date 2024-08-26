package com.uvg.lazystate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uvg.lazystate.layouts.NotificationLayout
import com.uvg.lazystate.layouts.generateFakeNotifications
import com.uvg.lazystate.ui.theme.LazyStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyStateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val notifications = rememberSaveable {
                        generateFakeNotifications()
                    }
                    NotificationLayout(
                        notifications = notifications,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

