package com.example.fashionshop.model

import com.example.fashionshop.R

data class ClothingItem(
    val id: Int,
    val name: String,
    val brand: String,
    val price: Double,
    val category: String,
    val imageRes: Int,
    val description: String
)

object SampleData {
    val items = listOf(
        ClothingItem(1,  "Floral Midi Dress",     "Zara",         59.99, "Women", R.drawable.item_01, "Light floral print, perfect for spring outings."),
        ClothingItem(2,  "Knit Oversized Blazer", "H&M",          79.99, "Women", R.drawable.item_02, "Cozy knit blazer, works as a top layer all year."),
        ClothingItem(3,  "High-Rise Skinny Jean",  "Levi's",       69.99, "Women", R.drawable.item_03, "Classic 5-pocket, high-rise silhouette."),
        ClothingItem(4,  "Satin Slip Skirt",       "ASOS",         39.99, "Women", R.drawable.item_04, "Bias-cut satin, elegant for day or night."),
        ClothingItem(5,  "Ribbed Turtleneck",      "Uniqlo",       29.99, "Women", R.drawable.item_05, "Ultra-soft ribbed cotton, timeless basic."),
        ClothingItem(6,  "Trench Coat",            "Burberry",    299.99, "Women", R.drawable.item_06, "Iconic double-breasted trench, water-resistant."),
        ClothingItem(7,  "Slim Chino Pants",       "Gap",          54.99, "Men",   R.drawable.item_07, "Stretch chino, tapered leg, wrinkle-resistant."),
        ClothingItem(8,  "Oxford Button-Down",     "Ralph Lauren", 79.99, "Men",   R.drawable.item_08, "Classic Oxford weave, non-iron finish."),
        ClothingItem(9,  "Puffer Jacket",          "North Face",  149.99, "Men",   R.drawable.item_09, "700-fill down, waterproof shell."),
        ClothingItem(10, "Graphic Tee",            "Supreme",      45.99, "Men",   R.drawable.item_10, "100% cotton, bold seasonal graphic."),
        ClothingItem(11, "Slim Jogger",            "Nike",         59.99, "Men",   R.drawable.item_11, "Tapered fleece jogger, zip pockets."),
        ClothingItem(12, "Denim Jacket",           "Levi's",       89.99, "Men",   R.drawable.item_12, "Classic trucker denim, stonewash finish."),
        ClothingItem(13, "Rainbow Hoodie",         "Carter's",     24.99, "Kids",  R.drawable.item_13, "Soft fleece, front kangaroo pocket."),
        ClothingItem(14, "Dino Printed Tee",       "OshKosh",      14.99, "Kids",  R.drawable.item_14, "Fun all-over dino print, tagless."),
        ClothingItem(15, "Cargo Shorts",           "Gap Kids",     19.99, "Kids",  R.drawable.item_15, "Multi-pocket cargo, adjustable waist."),
        ClothingItem(16, "Party Dress",            "Zara Kids",    34.99, "Kids",  R.drawable.item_16, "Tulle overlay, satin bow at the back.")
    )
}