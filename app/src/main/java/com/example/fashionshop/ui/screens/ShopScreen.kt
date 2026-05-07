package com.example.fashionshop.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fashionshop.ui.components.BagIcon
import com.example.fashionshop.ui.components.CategoryChip
import com.example.fashionshop.ui.components.ProductCard
import com.example.fashionshop.viewmodel.ShopViewModel

@Composable
fun ShopScreen() {
    val viewModel: ShopViewModel = viewModel()
    val state by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7FB))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            // Top bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .statusBarsPadding()
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        "FashionShop", fontWeight = FontWeight.Black,
                        fontSize = 22.sp, color = Color(0xFF1A1A2E)
                    )
                    Text("Find your style", fontSize = 12.sp, color = Color(0xFF9B9BAE))
                }
                BagIcon(count = state.bagCount, onClick = { viewModel.toggleBag() })
            }

            // Category chips
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listOf("All", "Women", "Men", "Kids")) { category ->
                    CategoryChip(
                        label = category,
                        selected = state.selectedCategory == category,
                        onClick = { viewModel.selectCategory(category) }
                    )
                }
            }

            // Product grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.filteredItems) { item ->
                    ProductCard(
                        item = item,
                        onAddToBag = { viewModel.addToBag(item) }
                    )
                }
            }
        }

        // Bag bottom sheet
        if (state.showBag) {
            BagBottomSheet(
                bagItems = state.bag,
                onDismiss = { viewModel.toggleBag() },
                onAdd = { viewModel.addToBag(it) },
                onRemove = { viewModel.removeFromBag(it) },
                onCheckout = { viewModel.clearBag() }
            )
        }
    }
}