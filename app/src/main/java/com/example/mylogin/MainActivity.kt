package com.example.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mylogin.ui.theme.MainScreen
import com.example.mylogin.ui.theme.MyLoginTheme
import com.example.mylogin.AuthViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                App(viewModel) // Pastikan ViewModel diteruskan
            }
        }
    }
}

@Composable
fun App(viewModel: AuthViewModel) {  // Tambahkan ViewModel sebagai parameter
    val navController = rememberNavController()

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
                viewModel = viewModel,  // ViewModel diteruskan ke SignUpScreen
                onSignUpSuccess = { navController.navigate("login") }  // Navigasi ke Login setelah berhasil signup
            )
        }
        // Route ke MainScreen (yang akan menampilkan Home, Profile, Settings)
        composable("main") {
            MainScreen()  // MainScreen mengelola navigasi bagian bawah (Bottom Navigation)
        }
    }
}

