package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                //Chat(onBackClick = { finish() })

                //MotoristasScreen()
                //Chat()
                CaronaConfirmada()
            }
        }
    }
}

@Composable
fun Chat(onBackClick: () -> Unit = {}) {
    val context = LocalContext.current
    var textoMensagem by remember { mutableStateOf("") }
    var valorSelecionado by remember { mutableStateOf("") }

    val corAzulEscuro = Color(0xFF1A3C6E)
    val corCinzaFundo = Color(0xFFF5F5F5)
    val corCinzaBalao = Color(0xFFEAEAEA)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(corCinzaFundo)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "←",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .clickable { onBackClick() }
                    .padding(end = 12.dp)
            )

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(Color(0xFFB0BEC5)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Carro", fontSize = 11.sp, color = Color.DarkGray)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
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
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            BalaoMensagem(
                texto = "Ola! Tudo bem? Vi que voce pediu a carona para o Campus Centro.",
                horario = "08:14",
                esquerda = true,
                corFundo = corCinzaBalao,
                corTexto = Color.Black
            )
            BalaoMensagem(
                texto = "Oi Lucas, tudo otimo! Sim, vou sair daqui a pouco. Voce consegue passar no Boqueirao?",
                horario = "08:15",
                esquerda = false,
                corFundo = corAzulEscuro,
                corTexto = Color.White
            )
            BalaoMensagem(
                texto = "Consigo sim. Fica no meu trajeto. O que acha de fecharmos por 18 reais pela distancia extra?",
                horario = "08:16",
                esquerda = true,
                corFundo = corCinzaBalao,
                corTexto = Color.Black
            )
            BalaoMensagem(
                texto = "Fechado! Ja aceito esse valor.",
                horario = "08:17",
                esquerda = false,
                corFundo = corAzulEscuro,
                corTexto = Color.White
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(corCinzaFundo)
                .padding(16.dp)
        ) {
            Text(
                text = "Sugerir contraproposta rapida:",
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                BotaoContraproposta(
                    texto = "R$ 18,00",
                    selecionado = valorSelecionado == "18",
                    onClick = {
                        valorSelecionado = "18"
                        Toast.makeText(context, "Valor selecionado: R$ 18,00", Toast.LENGTH_SHORT).show()
                    }
                )

                Spacer(modifier = Modifier.width(10.dp))

                BotaoContraproposta(
                    texto = "R$ 20,00",
                    selecionado = valorSelecionado == "20",
                    onClick = {
                        valorSelecionado = "20"
                        Toast.makeText(context, "Valor selecionado: R$ 20,00", Toast.LENGTH_SHORT).show()
                    }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = textoMensagem,
                    onValueChange = { textoMensagem = it },
                    placeholder = { Text("Escreva uma mensagem...", fontSize = 13.sp) },
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.White),
                    singleLine = true
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        if (textoMensagem.isNotBlank()) {
                            textoMensagem = ""
                            Toast.makeText(context, "Mensagem enviada", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Digite uma mensagem antes de enviar", Toast.LENGTH_SHORT).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = corAzulEscuro),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp)
                ) {
                    Text("Enviar", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun BalaoMensagem(texto: String, horario: String, esquerda: Boolean, corFundo: Color, corTexto: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        contentAlignment = if (esquerda) Alignment.CenterStart else Alignment.CenterEnd
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 280.dp)
                .background(corFundo)
                .padding(10.dp)
        ) {
            Text(text = texto, fontSize = 13.sp, color = corTexto)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = horario,
                fontSize = 9.sp,
                color = if (esquerda) Color.Gray else Color(0xFFD0D0D0),
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Composable
fun BotaoContraproposta(texto: String, selecionado: Boolean, onClick: () -> Unit) {
    val corAzulEscuro = Color(0xFF1A3C6E)
    Box(
        modifier = Modifier
            .background(if (selecionado) corAzulEscuro else Color.White)
            .border(1.dp, corAzulEscuro)
            .clickable { onClick() }
            .padding(horizontal = 14.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = texto,
            fontSize = 12.sp,
            color = if (selecionado) Color.White else corAzulEscuro,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    MaterialTheme {
        Chat()
    }
}