package com.olahbarbershop.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.olahbarbershop.app.ui.theme.OlahBarbershopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OlahBarbershopTheme {
                OlahApp()
            }
        }
    }
}

@Preview
@Composable
fun defaultPreview() {
    OlahBarbershopTheme {
        OlahApp()
    }
}