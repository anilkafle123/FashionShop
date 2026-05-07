package com.example.fashionshop.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fashionshop.model.ClothingItem

@Composable
fun ProductDetailScreen(item: ClothingItem, onBack: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {

        // Full screen image
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = item.name,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )

        // Back button
        Box(
            modifier = Modifier
                .padding(16.dp)
                .statusBarsPadding()
                .size(42.dp)
                .clip(CircleShape)
                .background(Color(0xCC000000))
                .clickable { onBack() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }

        // Item name at the bottom
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color(0xCC000000))
                .padding(20.dp)
        ) {
            Column {
                Text(item.name, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(item.brand, color = Color(0xFFAAAAAA), fontSize = 14.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text("$${String.format("%.2f", item.price)}", color = Color.White, fontWeight = FontWeight.Black, fontSize = 22.sp)
            }
        }
    }
}