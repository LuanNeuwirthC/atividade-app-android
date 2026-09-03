package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme



@Composable
fun MotoristasScreen() {
    val context = LocalContext.current
    var textoPesquisa by remember { mutableStateOf("") }
    var filtroSelecionado by remember { mutableStateOf("Proximos") }

    val corFundoTela = Color(0xFFF5F5F5)
    val corAzulEscuro = Color(0xFF1A3C6E)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(corFundoTela)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 14.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "🔍",
                fontSize = 16.sp,
                modifier = Modifier.padding(end = 8.dp)
            )

            OutlinedTextField(
                value = textoPesquisa,
                onValueChange = { textoPesquisa = it },
                placeholder = { Text("Para onde vamos hoje?", fontSize = 14.sp) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val filtros = listOf("Proximos", "Menor Preco", "Melhor Avaliacao")
            for (filtro in filtros) {
                val selecionado = filtroSelecionado == filtro
                Box(
                    modifier = Modifier
                        .background(if (selecionado) corAzulEscuro else Color(0xFFE0E0E0))
                        .clickable { filtroSelecionado = filtro }
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = filtro,
                        fontSize = 12.sp,
                        color = if (selecionado) Color.White else Color(0xFF444444),
                        fontWeight = if (selecionado) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Motoristas Disponiveis",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(14.dp))

        CardMotorista(
            nome = "Lucas Alencar",
            nota = "★ 4.9",
            saida = "Saida as 07:15 - Unidade Centro",
            preco = "R$ 20,00",
            corridas = "128 caronas",
            carro = "Civic Cinza - ABC1D23",
            onSolicitarClick = {
                Toast.makeText(context, "Carona solicitada com Lucas Alencar!", Toast.LENGTH_SHORT).show()
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        CardMotorista(
            nome = "Mariana Souza",
            nota = "★ 4.8",
            saida = "Saida as 07:30 - Unidade Sul",
            preco = "R$ 18,50",
            corridas = "94 caronas",
            carro = "Onix Branco - XYZ9W87",
            onSolicitarClick = {
                Toast.makeText(context, "Carona solicitada com Mariana Souza!", Toast.LENGTH_SHORT).show()
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        CardMotorista(
            nome = "Rodrigo Melo",
            nota = "★ 5.0",
            saida = "Saida as 07:45 - Unidade Norte",
            preco = "R$ 22,00",
            corridas = "210 caronas",
            carro = "Corolla Preto - KKK2J34",
            onSolicitarClick = {
                Toast.makeText(context, "Carona solicitada com Rodrigo Melo!", Toast.LENGTH_SHORT).show()
            }
        )
    }
}

@Composable
fun CardMotorista(
    nome: String,
    nota: String,
    saida: String,
    preco: String,
    corridas: String,
    carro: String,
    onSolicitarClick: () -> Unit
) {
    val corAzulEscuro = Color(0xFF1A3C6E)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(14.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = nome,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = nota,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF2A900)
            )
        }

        Text(
            text = saida,
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp, bottom = 10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = preco,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = corAzulEscuro
                )
                Text(
                    text = corridas,
                    fontSize = 10.sp,
                    color = Color.Gray
                )
            }

            Text(
                text = carro,
                fontSize = 12.sp,
                color = Color.DarkGray
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onSolicitarClick() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = corAzulEscuro),
            contentPadding = PaddingValues(vertical = 10.dp)
        ) {
            Text(
                text = "Solicitar Carona",
                color = Color.White,
                fontSize = 13.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MotoristasScreenPreview() {
    MaterialTheme {
        MotoristasScreen()
    }
}