package com.example.fashionshop.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fashionshop.model.ClothingItem
import com.example.fashionshop.ui.components.BagRowItem
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BagBottomSheet(
    bagItems: Map<ClothingItem, Int>,
    onDismiss: () -> Unit,
    onAdd: (ClothingItem) -> Unit,
    onRemove: (ClothingItem) -> Unit
) {
    val total = bagItems.entries.sumOf { it.key.price * it.value }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = Color.White,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("My Bag", fontWeight = FontWeight.Black,
                    fontSize = 22.sp, color = Color(0xFF1A1A2E))
                Text("${bagItems.values.sum()} items",
                    fontSize = 13.sp, color = Color(0xFF9B9BAE))
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (bagItems.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Your bag is empty", color = Color(0xFF9B9BAE), fontSize = 15.sp)
                }
            } else {
                LazyColumn(modifier = Modifier.weight(1f, fill = false)) {
                    items(bagItems.entries.toList()) { (item, qty) ->
                        BagRowItem(
                            item = item,
                            quantity = qty,
                            onAdd = { onAdd(item) },
                            onRemove = { onRemove(item) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Total", fontSize = 13.sp, color = Color(0xFF9B9BAE))
                        Text("$${String.format(Locale.US, "%.2f", total)}",
                            fontWeight = FontWeight.Black,
                            fontSize = 22.sp, color = Color(0xFF1A1A2E))
                    }
                    Button(
                        onClick = onDismiss,
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF1A1A2E)
                        ),
                        modifier = Modifier
                            .height(52.dp)
                            .width(160.dp)
                    ) {
                        Text("Checkout", fontWeight = FontWeight.Bold,
                            fontSize = 15.sp, color = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}