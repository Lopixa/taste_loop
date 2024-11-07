package com.example.mylogin.ui.theme

import HomeScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.mylogin.R

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) } // Menambahkan BottomNavigationBar
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFCF4EB))
                .padding(innerPadding)
        ) {
            NavigationHost(navController = navController) // Menyediakan area untuk navigasi antar halaman
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Profile,
        NavigationItem.Settings
    )

    NavigationBar(
        containerColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = { Image(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        // Route ke HomeScreen baru
        composable(NavigationItem.Home.route) {
            HomeScreen()  // Menggunakan HomeScreen baru yang menampilkan menu makanan
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()  // ProfileScreen tetap
        }
        composable(NavigationItem.Settings.route) {
            SettingsScreen()  // SettingsScreen tetap
        }
    }
}

@Composable
fun SettingsScreen() {
    Text(text = "Setting Screen")
}

@Composable
fun ProfileScreen() {
    Text(text = "Profile Screen")
}

// Kelas NavigationItem untuk mendefinisikan rute navigasi
sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Profile : NavigationItem("profile", R.drawable.ic_profile, "Profile")
    object Settings : NavigationItem("settings", R.drawable.ic_settings, "Settings")
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
