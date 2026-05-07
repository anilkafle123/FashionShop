package com.example.fashionshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.fashionshop.ui.screens.HomeScreen
import com.example.fashionshop.ui.screens.ShopScreen
import com.example.fashionshop.ui.theme.FashionShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FashionShopTheme {
                var showHome by remember { mutableStateOf(true) }

                if (showHome) {
                    HomeScreen(onEnterShop = { showHome = false })
                } else {
                    ShopScreen()
                }
            }
        }
    }
}