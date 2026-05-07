package com.example.fashionshop.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(onEnterShop: () -> Unit) {

    // Animation states
    var visible by remember { mutableStateOf(false) }

    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = "alpha"
    )
    val slideUp by animateDpAsState(
        targetValue = if (visible) 0.dp else 40.dp,
        animationSpec = tween(durationMillis = 900, easing = EaseOutCubic),
        label = "slideUp"
    )
    val buttonAlpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 800, delayMillis = 600),
        label = "buttonAlpha"
    )

    LaunchedEffect(Unit) {
        delay(200)
        visible = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0D0D0D),
                        Color(0xFF1A1A2E),
                        Color(0xFF16213E)
                    )
                )
            )
    ) {
        // Decorative blobs
        Box(
            modifier = Modifier
                .size(300.dp)
                .offset(x = (-60).dp, y = 80.dp)
                .alpha(0.18f)
                .background(
                    Brush.radialGradient(
                        colors = listOf(Color(0xFFE63946), Color.Transparent)
                    ),
                    shape = RoundedCornerShape(50)
                )
        )
        Box(
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.TopEnd)
                .offset(x = 60.dp, y = 200.dp)
                .alpha(0.13f)
                .background(
                    Brush.radialGradient(
                        colors = listOf(Color(0xFF457B9D), Color.Transparent)
                    ),
                    shape = RoundedCornerShape(50)
                )
        )

        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 36.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Tag line badge
            Box(
                modifier = Modifier
                    .offset(y = slideUp)
                    .alpha(alpha)
                    .clip(RoundedCornerShape(50))
                    .background(Color(0x22E63946))
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "✦ NEW COLLECTION 2026 ✦",
                    color = Color(0xFFE63946),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Big headline
            Text(
                text = "Style\nWithout\nLimits.",
                fontSize = 58.sp,
                fontWeight = FontWeight.Black,
                color = Color.White,
                lineHeight = 62.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .offset(y = slideUp)
                    .alpha(alpha)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Subtitle
            Text(
                text = "Curated fashion for every mood,\nevery season, every you.",
                fontSize = 15.sp,
                color = Color(0xFFAAAAAA),
                textAlign = TextAlign.Center,
                lineHeight = 22.sp,
                modifier = Modifier
                    .offset(y = slideUp)
                    .alpha(alpha)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Divider line
            Box(
                modifier = Modifier
                    .alpha(alpha)
                    .width(48.dp)
                    .height(2.dp)
                    .background(Color(0xFFE63946))
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Stats row
            Row(
                modifier = Modifier
                    .alpha(alpha)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem("500+", "Styles")
                StatDivider()
                StatItem("4.9★", "Rating")
                StatDivider()
                StatItem("Free", "Returns")
            }

            Spacer(modifier = Modifier.height(52.dp))

            // CTA Button
            Button(
                onClick = onEnterShop,
                modifier = Modifier
                    .alpha(buttonAlpha)
                    .fillMaxWidth()
                    .height(58.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE63946)
                )
            ) {
                Text(
                    text = "Shop Now  →",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    letterSpacing = 0.5.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Secondary link
            Text(
                text = "Women · Men · Kids",
                fontSize = 13.sp,
                color = Color(0xFF666666),
                modifier = Modifier.alpha(buttonAlpha),
                letterSpacing = 1.sp
            )
        }

        // Bottom brand watermark
        Text(
            text = "FASHIONSHOP",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333),
            letterSpacing = 4.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        )
    }
}

@Composable
fun StatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, fontSize = 20.sp, fontWeight = FontWeight.Black, color = Color.White)
        Spacer(modifier = Modifier.height(2.dp))
        Text(label, fontSize = 12.sp, color = Color(0xFF888888))
    }
}

@Composable
fun StatDivider() {
    Box(
        modifier = Modifier
            .width(1.dp)
            .height(36.dp)
            .background(Color(0xFF333333))
    )
}