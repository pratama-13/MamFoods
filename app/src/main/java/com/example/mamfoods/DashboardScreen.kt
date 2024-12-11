package com.example.mamfoods.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mamfoods.R

@Composable
fun DashboardScreen(
    onAddItemClick: () -> Unit,
    onViewAllItemsClick: () -> Unit,
    onDeliveryStatusClick: () -> Unit,
    onProfileClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header with Logo in the top left corner
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
               painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Mam Foods",
                modifier = Modifier.size(30.dp)
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        // Header Text
        Text(
            text = "Mam Foods",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Info Cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            InfoCard("Pending Order", "30")
            InfoCard("Completed order", "10")
            InfoCard("Whole Time Earning", "100K")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Menu Buttons
        ButtonGrid(
            onAddItemClick = onAddItemClick,
            onViewAllItemsClick = onViewAllItemsClick,
            onDeliveryStatusClick = onDeliveryStatusClick,
            onProfileClick = onProfileClick,
            onLogoutClick = onLogoutClick
        )
    }
}

@Composable
fun InfoCard(title: String, value: String) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .background(Color(0xFFFFF0F0), shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Red,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ButtonGrid(
    onAddItemClick: () -> Unit,
    onViewAllItemsClick: () -> Unit,
    onDeliveryStatusClick: () -> Unit,
    onProfileClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuButton("Add Menu", onAddItemClick)
            MenuButton("All Item Menu", onViewAllItemsClick)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuButton("Out For Delivery", onDeliveryStatusClick)
            MenuButton("Profile", onProfileClick)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuButton("Log Out", onLogoutClick)
        }
    }
}

@Composable
fun MenuButton(title: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(140.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFC0C0)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Red,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(
        onAddItemClick = {},
        onViewAllItemsClick = {},
        onDeliveryStatusClick = {},
        onProfileClick = {},
        onLogoutClick = {}
    )
}
