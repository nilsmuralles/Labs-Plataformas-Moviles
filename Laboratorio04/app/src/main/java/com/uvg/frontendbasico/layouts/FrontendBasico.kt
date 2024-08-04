package com.uvg.frontendbasico.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.uvg.frontendbasico.R
import com.uvg.frontendbasico.ui.theme.CustomGreen
import com.uvg.frontendbasico.ui.theme.FrontendBasicoTheme

@Composable
fun BasicLayout(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(
                color = CustomGreen,
                width = 8.dp,
                shape = RectangleShape
            ),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo_uvg),
            contentDescription = "Logo Universidad del Valle de Guatemala",
            modifier = Modifier
                .size(350.dp)
                .graphicsLayer {
                    this.alpha = 0.3f
                }
                .zIndex(-1f)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .zIndex(1f),

        ) {
            Box {
                Text(
                    text = "Universidad del Valle de Guatemala",
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
            Box {
                Text(
                    text = "Programación de Plataformas Móviles, Sección 30",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center
                )
            }
            Row (
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column {
                    Text(
                        text = "INTEGRANTES",
                        fontWeight = FontWeight.Bold
                    )
                }
                Column {
                    Text(text = "Nils Muralles")
                    Text(text = "Diego Flores")
                }
            }
            Row (
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column {
                    Text(
                        text = "CATEDRÁTICO",
                        fontWeight = FontWeight.Bold
                    )
                }
                Column {
                    Text(text = "Juan Carlos Durini")
                }
            }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "Nils Muralles")
                Text(text = "23727")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicLayoutPreview(){
    FrontendBasicoTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            BasicLayout()
        }
    }
}