package com.example.mylogin.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Pengaturan Dark Mode
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Dark Mode",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = false, // Ubah sesuai dengan status Dark Mode
                onCheckedChange = { /* Tambahkan logika untuk Dark Mode */ }
            )
        }

        // Pengaturan Notifikasi
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Notifikasi",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = true, // Ubah sesuai dengan status Notifikasi
                onCheckedChange = { /* Tambahkan logika untuk Notifikasi */ }
            )
        }

        // Tombol Logout
        Button(
            onClick = { /* Tambahkan logika untuk Logout */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Text(text = "Logout")
        }
    }
}

