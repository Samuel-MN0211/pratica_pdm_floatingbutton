package com.example.guga_floating_button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var message by remember { mutableStateOf("Pressione um botão flutuante") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = message, fontSize = 20.sp)

        FloatingActionButton(
            onClick = { message = "Botão flutuante padrão pressionado" },
            containerColor = Color(0xFF6200EE),
            contentColor = Color.White
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }

        ExtendedFloatingActionButton(
            onClick = { message = "Botão flutuante estendido pressionado" },
            containerColor = Color(0xFF03DAC5),
            contentColor = Color.Black,
            text = { Text("Extended FAB") },
            icon = { Icon(Icons.Filled.ThumbUp, contentDescription = "Thumb Up") }
        )

        SmallFloatingActionButton(
            onClick = { message = "Botão flutuante pequeno pressionado" },
            containerColor = Color(0xFFFF5722),
            contentColor = Color.White
        ) {
            Icon(Icons.Filled.Edit, contentDescription = "Edit")
        }

        LargeFloatingActionButton(
            onClick = { message = "Botão flutuante grande pressionado" },
            containerColor = Color(0xFF4CAF50),
            contentColor = Color.White
        ) {
            Icon(Icons.Filled.Check, contentDescription = "Check")
        }
    }
}
