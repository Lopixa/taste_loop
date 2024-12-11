package com.example.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mylogin.ui.theme.MainScreen
import com.example.mylogin.ui.theme.MyLoginTheme
import com.example.sulseltour.AuthViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                SignUpScreen(viewModel) // Panggil App() untuk mengatur navigasi antar layar
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    // NavHost untuk mengatur navigasi antar layar
    NavHost(navController = navController, startDestination = "splash") {
        // Route ke Splash Screen
        composable("splash") {
            SplashScreen(navController)
        }
        // Route ke Login Screen
        composable("login") {
            LoginScreen(
                onSignUpClick = { navController.navigate("signup") },  // Navigasi ke Sign Up
                onLoginSuccess = { navController.navigate("main") }    // Navigasi ke MainScreen setelah login berhasil
            )
        }
        // Route ke Sign Up Screen

        // Route ke MainScreen (yang akan menampilkan Home, Profile, Settings)
        composable("main") {
            MainScreen()  // MainScreen mengelola navigasi bagian bawah (Bottom Navigation)
        }

    }
}