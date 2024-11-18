package com.example.mylogin.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylogin.R

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCF4EB))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Bagian Gambar Profil dan Notifikasi
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile), // ganti dengan resource gambar profil Anda
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.LightGray, shape = CircleShape)
                    .padding(4.dp),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notification Icon",
                modifier = Modifier.size(48.dp),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nama dan Email Pengguna
        Text(
            text = "Surya Miftahul Khair",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "suryamiftahul@gmail.com",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Tombol "Edit Profil"
        Button(
            onClick = { /* Aksi untuk Edit Profil */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Edit Profil")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol "Lihat Statistik"
        Button(
            onClick = { /* Aksi untuk Lihat Statistik */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Lihat Statistik")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Status Membership
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Membership Aktif\n5 Hari Tersisa",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Button(onClick = { /* Tindakan untuk memperbarui paket */ }) {
                Text(text = "Ubah Paket")
            }
        }
    }
}
