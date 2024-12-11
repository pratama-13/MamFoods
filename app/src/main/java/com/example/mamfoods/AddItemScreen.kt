package com.example.mamfoods.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mamfoods.ui.theme.TitleText

// Define the red gradient color
val RedGradient1 = Color(0xFFE85353)

@Composable
fun AddItemScreen(onBackClick: () -> Unit, onAddItemClick: () -> Unit) {
    // Remember state for the input fields
    val itemName = remember { mutableStateOf("") }
    val itemPrice = remember { mutableStateOf("") }
    val shortDescription = remember { mutableStateOf("") }
    val ingredients = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
        verticalArrangement = Arrangement.Top // Align content to the top of the screen
    ) {
        // Header dengan tombol kembali dan judul di tengah
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Add Item",
                style = TitleText,
                modifier = Modifier.weight(5f),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1f))
        }


        // Kolom inputan untuk Nama Item
        TextField(
            value = itemName.value,
            onValueChange = { itemName.value = it },
            label = { Text("Item Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Kolom inputan untuk Harga Item
        TextField(
            value = itemPrice.value,
            onValueChange = { itemPrice.value = it },
            label = { Text("Item Price") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Button untuk Upload Gambar
        Button(
            onClick = { /* Open Image Picker */ },
            colors = ButtonDefaults.buttonColors(containerColor = RedGradient1),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Upload Image", color = Color.White)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Kolom inputan untuk Deskripsi Singkat
        TextField(
            value = shortDescription.value,
            onValueChange = { shortDescription.value = it },
            label = { Text("Short Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Kolom inputan untuk Bahan-bahan
        TextField(
            value = ingredients.value,
            onValueChange = { ingredients.value = it },
            label = { Text("Ingredients") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol untuk Menambahkan Item
        Button(
            onClick = {
                onAddItemClick()
            },
            colors = ButtonDefaults.buttonColors(containerColor = RedGradient1),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Item", color = Color.White)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AddItemScreenPreview() {
    AddItemScreen(onBackClick = {}, onAddItemClick = {})
}
