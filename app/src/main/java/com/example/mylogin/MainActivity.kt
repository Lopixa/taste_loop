package com.example.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mylogin.ui.theme.MainScreen
import com.example.mylogin.ui.theme.MyLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                App()
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
        composable("signup") {
            SignUpScreen(
                onSignUpSuccess = { navController.navigate("login") }  // Navigasi kembali ke Login setelah signup
            )
        }
        // Route ke MainScreen
        composable("main") {
            MainScreen()  // Menampilkan layar utama setelah login
        }
    }
}
