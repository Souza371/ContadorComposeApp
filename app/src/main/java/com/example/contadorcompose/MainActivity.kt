package com.example.contadorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contadorcompose.ui.theme.ContadorComposeTheme
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.delay

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
    var isIncrementing by remember { mutableStateOf(false) }
    var isDecrementing by remember { mutableStateOf(false) }
    var showCelebration by remember { mutableStateOf(false) }
    
    // Animações
    val scale by animateFloatAsState(
        targetValue = if (isIncrementing || isDecrementing) 1.1f else 1f,
        animationSpec = tween(durationMillis = 150),
        label = "scale_animation"
    )
    
    val countRotation by animateFloatAsState(
        targetValue = if (showCelebration) 360f else 0f,
        animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
        label = "count_rotation"
    )
    
    // Função para determinar as cores de fundo com gradientes
    val backgroundColors = when {
        count < 0 -> listOf(Color(0xFFFFEBEE), Color(0xFFFFCDD2))
        count == 0 -> listOf(Color(0xFFF5F5F5), Color(0xFFE0E0E0))
        count in 1..5 -> listOf(Color(0xFFE8F5E8), Color(0xFFC8E6C9))
        count in 6..10 -> listOf(Color(0xFFE3F2FD), Color(0xFFBBDEFB))
        count in 11..15 -> listOf(Color(0xFFF3E5F5), Color(0xFFE1BEE7))
        else -> listOf(Color(0xFFFFF3E0), Color(0xFFFFE0B2))
    }
    
    val animatedBackgroundColors = backgroundColors.map { color ->
        animateColorAsState(
            targetValue = color,
            animationSpec = tween(durationMillis = 800),
            label = "background_animation"
        ).value
    }
    
    // Função para determinar a mensagem especial
    val specialMessage = when (count) {
        0 -> "Comece a contar!" to "🚀"
        5 -> "Você chegou ao 5!" to "🎉"
        10 -> "Parabéns! Você chegou a 10!" to "🎊"
        15 -> "Incrível! 15 é um ótimo número!" to "⭐"
        20 -> "Uau! 20 pontos!" to "🚀"
        25 -> "Um quarto de 100!" to "🏆"
        30 -> "Você está voando!" to "✨"
        50 -> "Meio caminho para 100!" to "🎯"
        100 -> "INCRÍVEL! 100 PONTOS!" to "👑"
        else -> null
    }

    // Efeito para mostrar celebração
    LaunchedEffect(count) {
        if (specialMessage != null && count > 0) {
            showCelebration = true
            delay(600)
            showCelebration = false
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(animatedBackgroundColors)
            )
            .padding(16.dp)
    ) {
        // Título do app com estilo melhorado
        Card(
            modifier = Modifier
                .shadow(8.dp, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Text(
                text = "Contador Compose",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Valor atual do contador com animação
        Card(
            modifier = Modifier
                .shadow(12.dp, CircleShape)
                .size(120.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            shape = CircleShape
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationZ = countRotation
                        scaleX = scale
                        scaleY = scale
                    }
            ) {
                Text(
                    text = "$count",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        
        // Mensagem especial se houver
        specialMessage?.let { (message, emoji) ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .shadow(6.dp, RoundedCornerShape(20.dp))
                    .graphicsLayer {
                        scaleX = if (showCelebration) 1.1f else 1f
                        scaleY = if (showCelebration) 1.1f else 1f
                    },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = emoji,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = message,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Botões para incrementar e decrementar
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botão de diminuir
            FloatingActionButton(
                onClick = { 
                    if (count > 0) {
                        isDecrementing = true
                        count--
                    }
                },
                modifier = Modifier
                    .size(64.dp)
                    .shadow(8.dp, CircleShape)
                    .graphicsLayer {
                        scaleX = if (isDecrementing) 0.9f else 1f
                        scaleY = if (isDecrementing) 0.9f else 1f
                    },
                containerColor = MaterialTheme.colorScheme.error,
                contentColor = MaterialTheme.colorScheme.onError
            ) {
                Text(
                    text = "−",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Botão de reset
            FloatingActionButton(
                onClick = { 
                    count = 0
                    showCelebration = true
                },
                modifier = Modifier
                    .size(56.dp)
                    .shadow(6.dp, CircleShape),
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Reset",
                    modifier = Modifier.size(24.dp)
                )
            }

            // Botão de aumentar
            FloatingActionButton(
                onClick = { 
                    isIncrementing = true
                    count++
                },
                modifier = Modifier
                    .size(64.dp)
                    .shadow(8.dp, CircleShape)
                    .graphicsLayer {
                        scaleX = if (isIncrementing) 0.9f else 1f
                        scaleY = if (isIncrementing) 0.9f else 1f
                    },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Text(
                    text = "+",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        
        // Efeito para resetar animações dos botões
        LaunchedEffect(isIncrementing) {
            if (isIncrementing) {
                delay(150)
                isIncrementing = false
            }
        }
        
        LaunchedEffect(isDecrementing) {
            if (isDecrementing) {
                delay(150)
                isDecrementing = false
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Informação adicional sobre o estado com estilo melhorado
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .shadow(4.dp, RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = when {
                    count == 0 -> "✨ Pronto para começar a aventura!"
                    count < 10 -> "🌱 Continue crescendo!"
                    count < 20 -> "🔥 Você está pegando fogo!"
                    count < 50 -> "⚡ Velocidade impressionante!"
                    else -> "🚀 Você é imparável!"
                },
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContador() {
    ContadorComposeTheme {
        ContadorApp()
    }
}