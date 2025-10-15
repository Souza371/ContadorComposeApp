package com.example.contadorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contadorcompose.ui.theme.ContadorComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContadorComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContadorApp()
                }
            }
        }
    }
}

@Composable
fun ContadorApp() {
    var count by remember { mutableStateOf(0) }
    
    // Função para determinar a cor de fundo baseada no valor do contador
    val backgroundColor = when {
        count < 0 -> Color(0xFFFFEBEE) // Rosa claro para valores negativos
        count == 0 -> Color(0xFFF5F5F5) // Cinza claro para zero
        count in 1..5 -> Color(0xFFE8F5E8) // Verde claro para valores baixos
        count in 6..10 -> Color(0xFFE3F2FD) // Azul claro para valores médios
        else -> Color(0xFFFFF3E0) // Laranja claro para valores altos
    }
    
    // Função para determinar a mensagem especial
    val specialMessage = when (count) {
        0 -> "Comece a contar!"
        5 -> "Você chegou ao 5! 🎉"
        10 -> "Parabéns! Você chegou a 10! 🎊"
        15 -> "Incrível! 15 é um ótimo número! ⭐"
        20 -> "Uau! 20 pontos! 🚀"
        else -> null
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        // Título do app
        Text(
            text = "Contador Compose",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Valor atual do contador
        Text(
            text = "Valor atual: $count",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(16.dp))
        
        // Mensagem especial se houver
        specialMessage?.let { message ->
            Card(
                modifier = Modifier.padding(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(
                    text = message,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(12.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Botões para incrementar e decrementar
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botão de diminuir (apenas se count > 0 para validação)
            Button(
                onClick = { if (count > 0) count-- },
                enabled = count > 0, // Desabilita o botão quando count é 0
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error,
                    disabledContainerColor = MaterialTheme.colorScheme.errorContainer
                )
            ) {
                Text(
                    text = "–",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Botão de aumentar
            Button(
                onClick = { count++ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = "+",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Informação adicional sobre o estado
        Text(
            text = if (count == 0) "O contador não pode ser negativo" else "Continue contando!",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContador() {
    ContadorComposeTheme {
        ContadorApp()
    }
}