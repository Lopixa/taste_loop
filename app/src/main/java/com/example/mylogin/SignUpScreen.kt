package com.example.mylogin

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sulseltour.AuthViewModel

@Composable
fun SignUpScreen(
    viewModel: AuthViewModel,  // Pass the ViewModel
    onSignUpSuccess: () -> Unit  // Pass the callback for successful sign-up
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isRegistered by remember { mutableStateOf(false)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCF4EB)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.download),
            contentDescription = "Sign Up Image",
            modifier = Modifier.size(200.dp)
        )

        Text(text = "Create Your Account", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        // Input Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email Address") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input Password
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input Konfirmasi Password
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(text = "Confirm Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

// Tombol Sign Up
        Button(onClick = {
            // Validasi input
            if (password == confirmPassword && email.isNotEmpty() && password.isNotEmpty()) {
                Log.i("SignUp", "Email: $email, Password: $password, Confirm Password: $confirmPassword")
                viewModel.register(email, password) { success ->
                    if (success) {
                        onSignUpSuccess()
                    } else {
                        Log.e("SignUp", "Registrasi gagal")
                    }
                }
            } else {
                // Tampilkan pesan jika validasi gagal (password tidak cocok atau input kosong)
                Log.e("SignUp", "Validasi gagal: Periksa email dan password.")
            }
        }) {
            Text(text = "Register")
        }

        Spacer(modifier = Modifier.height(10.dp))


        // Navigasi kembali ke Login
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Sudah punya akun?", fontSize = 14.sp)
            TextButton(onClick = { onSignUpSuccess() }) {
                Text(text = "Login", fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

