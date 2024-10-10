package com.example.mylogin

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
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

@Composable
fun LoginScreen(){

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isRememberMeChecked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCF4EB)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.download),
            contentDescription = "Login Image ",
            modifier = Modifier.size(200.dp))

        Text(text = "Welcome Back", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        
        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Login To Your Account ")

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email Address") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Remember Me di sebelah kiri
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isRememberMeChecked,
                    onCheckedChange = { isRememberMeChecked = it }
                )
                Text(text = "Remember Me")
            }
            TextButton(
                onClick = { }
            ) {
                Text(
                    text = "Forgot Password?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            Log.i(
                "Credential",
                "Email: $email, Password: $password, Remember Me: $isRememberMeChecked"
            )
        }) {
            Text(text = "LOGIN")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Belum mempunyai akun? ", fontSize = 14.sp)
            TextButton(onClick = { }) {
                Text(text = "Sign Up", fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
