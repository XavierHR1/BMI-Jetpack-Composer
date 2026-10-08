package org.insbaixcamp.bmijetpackcomposer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale
import org.insbaixcamp.bmijetpackcomposer.ui.theme.BMIJetpackComposerTheme

// Cyberpunk Color Palette
val CyberDarkBg = Color(0xFF0B0C10)
val CyberSurface = Color(0xFF12141D)
val CyberCardBg = Color(0xFF181B26)
val CyberNeonCyan = Color(0xFF00F0FF)
val CyberNeonMagenta = Color(0xFFFF0055)
val CyberNeonYellow = Color(0xFFFFE600)
val CyberNeonGreen = Color(0xFF00FF66)
val CyberDarkBlue = Color(0xFF003847)
val CyberTextPrimary = Color(0xFFE2E8F0)
val CyberTextSecondary = Color(0xFF8A99AD)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMIJetpackComposerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = CyberDarkBg
                ) { innerPadding ->
                    BMIScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, backgroundColor = 0xFF0B0C10)
@Composable
fun BMIScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("Josep Maria") }
    var pes by remember { mutableIntStateOf(80) }
    var alcada by remember { mutableIntStateOf(180) }
    var bmi by remember { mutableFloatStateOf(0f) }

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CyberDarkBg)
            .verticalScroll(scrollState)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Cyberpunk HUD Header
        CyberHeader()

        // User Identification Input
        CyberCard(
            title = "// IDENTIFICATION",
            accentColor = CyberNeonCyan
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = {
                    Text(
                        "USER_NAME",
                        color = CyberNeonCyan,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 12.sp
                    )
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = CyberNeonCyan,
                    unfocusedBorderColor = CyberNeonCyan.copy(alpha = 0.4f),
                    focusedTextColor = CyberTextPrimary,
                    unfocusedTextColor = CyberTextPrimary,
                    cursorColor = CyberNeonCyan,
                    focusedContainerColor = CyberSurface,
                    unfocusedContainerColor = CyberSurface
                ),
                textStyle = LocalTextStyle.current.copy(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 16.sp
                ),
                shape = CutCornerShape(topStart = 8.dp, bottomEnd = 8.dp)
            )
        }

        // Weight Section
        CyberCard(
            title = "// MASS (PES)",
            accentColor = CyberNeonMagenta
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "$pes",
                        fontSize = 44.sp,
                        fontWeight = FontWeight.Bold,
                        color = CyberNeonMagenta,
                        fontFamily = FontFamily.Monospace
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "KG",
                        fontSize = 18.sp,
                        color = CyberTextSecondary,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = { if (pes > 1) pes-- },
                        shape = CutCornerShape(4.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = CyberNeonMagenta
                        ),
                        border = BorderStroke(1.dp, CyberNeonMagenta)
                    ) {
                        Text(
                            text = "- 1 KG",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }

                    OutlinedButton(
                        onClick = { pes++ },
                        shape = CutCornerShape(4.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = CyberNeonMagenta
                        ),
                        border = BorderStroke(1.dp, CyberNeonMagenta)
                    ) {
                        Text(
                            text = "+ 1 KG",
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }

        // Height Section
        CyberCard(
            title = "// STATURE (ALÇADA)",
            accentColor = CyberNeonCyan
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "HEIGHT_VAL",
                        color = CyberTextSecondary,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 12.sp
                    )
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "$alcada",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = CyberNeonCyan,
                            fontFamily = FontFamily.Monospace
                        )
                        Text(
                            text = " CM",
                            fontSize = 14.sp,
                            color = CyberTextSecondary,
                            fontFamily = FontFamily.Monospace,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Slider(
                    value = alcada.toFloat(),
                    onValueChange = { alcada = it.toInt() },
                    valueRange = 100f..220f,
                    colors = SliderDefaults.colors(
                        thumbColor = CyberNeonCyan,
                        activeTrackColor = CyberNeonCyan,
                        inactiveTrackColor = CyberDarkBlue
                    )
                )
            }
        }

        // Action Button: Compute BMI
        Button(
            onClick = {
                val alcadaMetres = alcada.toFloat() / 100
                bmi = pes / (alcadaMetres * alcadaMetres)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(
                    width = 1.dp,
                    color = CyberNeonCyan,
                    shape = CutCornerShape(topStart = 12.dp, bottomEnd = 12.dp)
                ),
            shape = CutCornerShape(topStart = 12.dp, bottomEnd = 12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = CyberNeonMagenta
            )
        ) {
            Text(
                text = "⚡ CALCULAR BMI",
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Monospace,
                color = Color.White
            )
        }

        // BMI Result HUD
        if (bmi != 0f) {
            CyberResultDisplay(bmi = bmi, name = name)
        }
    }
}

@Composable
fun CyberHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, CyberNeonCyan.copy(alpha = 0.5f), CutCornerShape(topEnd = 16.dp))
            .background(CyberSurface, CutCornerShape(topEnd = 16.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "SYS.BMI // v2.0",
                color = CyberNeonCyan,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(CyberNeonGreen, shape = RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "ONLINE",
                    color = CyberNeonGreen,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "CYBER BMI CALCULATOR",
            color = CyberTextPrimary,
            fontSize = 22.sp,
            fontWeight = FontWeight.Black,
            fontFamily = FontFamily.Monospace
        )
    }
}

@Composable
fun CyberCard(
    title: String,
    accentColor: Color,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CyberCardBg, CutCornerShape(topStart = 10.dp, bottomEnd = 10.dp))
            .border(1.dp, accentColor.copy(alpha = 0.6f), CutCornerShape(topStart = 10.dp, bottomEnd = 10.dp))
            .padding(16.dp)
    ) {
        Text(
            text = title,
            color = accentColor,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        content()
    }
}

@Composable
fun CyberResultDisplay(bmi: Float, name: String) {
    val (statusText, statusColor) = when {
        bmi < 18.5f -> "UNDERWEIGHT // INFRA-PES" to CyberNeonYellow
        bmi < 25.0f -> "OPTIMAL // PES NORMAL" to CyberNeonGreen
        bmi < 30.0f -> "OVERWEIGHT // SOBREPES" to CyberNeonYellow
        else -> "OBESE // OBESITAT" to CyberNeonMagenta
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(CyberSurface, CyberCardBg)
                ),
                shape = CutCornerShape(12.dp)
            )
            .border(2.dp, statusColor, CutCornerShape(12.dp))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "// DIAGNOSTIC_OUTPUT",
            color = CyberTextSecondary,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (name.isNotBlank()) {
            Text(
                text = "SUBJECT: ${name.uppercase()}",
                color = CyberNeonCyan,
                fontFamily = FontFamily.Monospace,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        Text(
            text = "YOUR BMI IS",
            color = CyberTextSecondary,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp
        )

        Text(
            text = String.format(Locale.US, "%.2f", bmi),
            fontSize = 48.sp,
            fontWeight = FontWeight.Black,
            color = statusColor,
            fontFamily = FontFamily.Monospace
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .background(statusColor.copy(alpha = 0.15f), CutCornerShape(4.dp))
                .border(1.dp, statusColor, CutCornerShape(4.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            Text(
                text = statusText,
                color = statusColor,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
    }
}