package com.example.mylogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mylogin.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    // Menggunakan LaunchedEffect untuk delay
    LaunchedEffect(Unit) {
        delay(2000L)  // Menunggu 2 detik (2000 milidetik) sebelum pindah ke login
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }  // Menghapus splash dari back stack
        }
    }

    // Tampilan Splash Screen dengan logo
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_tasteloop),
            contentDescription = "Splash Logo",
            modifier = Modifier.size(200.dp)  // Sesuaikan ukuran logo
        )
    }
}
