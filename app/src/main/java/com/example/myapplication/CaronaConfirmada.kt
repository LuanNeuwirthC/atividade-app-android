package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CaronaConfirmada(innerPadding: PaddingValues = PaddingValues()) {
    val corAzulEscuro = Color(0xFF1A3C6E)
    val corCinzaFundo = Color(0xFFF5F5F5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Box(
            modifier = Modifier
                .size(72.dp)
                .background(corAzulEscuro),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "✓", fontSize = 32.sp, color = Color.White, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Carona Confirmada!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Seu motorista ja esta a caminho.",
            fontSize = 13.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(corCinzaFundo)
                .padding(16.dp)
        ) {
            Text(
                text = "Lucas Andrade ★ 4.9",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.Black
            )
            Text(
                text = "Honda Civic - Cinza (FJD-4A92)",
                fontSize = 12.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Valor combinado",
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "R$ 18,00",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = corAzulEscuro
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = corAzulEscuro),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            Text("Acompanhar no mapa", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CaronaConfirmadaPreview() {
    MaterialTheme {
        CaronaConfirmada()
    }
}