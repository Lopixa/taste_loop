package com.example.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.mylogin.ui.theme.MainScreen
import com.example.mylogin.ui.theme.MyLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                App()  // Memanggil fungsi App untuk navigasi antara Login dan Sign Up
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onSignUpClick = { navController.navigate("signup") },  // Navigasi ke Sign Up
                onLoginSuccess = { navController.navigate("main") }   // Navigasi ke MainScreen
            )
        }
        composable("signup") {
            SignUpScreen(
                onSignUpSuccess = { navController.navigate("login") } // Navigasi kembali ke Login setelah signup
            )
        }
        composable("main") {
            MainScreen()
        }
    }
}
