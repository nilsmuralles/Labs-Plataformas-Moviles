package com.uvg.frontendrestaurante.layouts

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.frontendrestaurante.R
import com.uvg.frontendrestaurante.ui.theme.FrontendRestauranteTheme
import com.uvg.frontendrestaurante.ui.theme.BgColor
import com.uvg.frontendrestaurante.ui.theme.CustomBlue
import com.uvg.frontendrestaurante.ui.theme.CustomOrange
import com.uvg.frontendrestaurante.ui.theme.CustomPurple
import com.uvg.frontendrestaurante.ui.theme.LightBlue

@Composable
fun RestaurantLayout(modifier: Modifier = Modifier){
    val context = LocalContext.current
    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp, bottom = 50.dp)
            .background(color = BgColor)
    ){
        Column (
            modifier = Modifier
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightBlue)
                    .padding(top = 20.dp, bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                ){
                    Row (
                        modifier = Modifier
                            .weight(2f),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.ic_update),
                            contentDescription = "Recargar",
                            tint = Color.White,
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(color = CustomBlue)
                                .padding(8.dp)
                        )
                        Text(
                            text = "Actualización disponible"
                        )
                    }
                    val intent = remember {
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")
                        )
                    }
                    TextButton(
                        onClick = {
                            context.startActivity(intent)
                        }
                    ) {
                        Text(
                            text = "Descargar",
                            style = TextStyle(
                                color = CustomBlue,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            Row (
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            ){
                Column {
                    Text(
                        text = "Jueves",
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.DarkGray
                    )
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "11 de abril",
                            style = MaterialTheme.typography.titleLarge
                        )
                        OutlinedButton(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = "Terminar jornada",
                                style = MaterialTheme.typography.titleMedium,
                                color = CustomPurple
                            )
                        }
                    }
                }

            }
            Spacer(modifier = Modifier.size(16.dp))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(2.dp),
                shape = RectangleShape
            ){
                Column (
                    modifier = Modifier
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ){
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            text = "Hacienda Real",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.DarkGray
                        )
                        val intent = remember {
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://www.google.com/maps/place/Hacienda+Real+Zona+10/@14.595355,-90.5339196,14.75z/data=!4m10!1m2!2m1!1shacienda+real!3m6!1s0x8589a3c4320f3377:0xf513baa6a60928c2!8m2!3d14.5966117!4d-90.5119474!15sCg1oYWNpZW5kYSByZWFsIgOIAQFaDyINaGFjaWVuZGEgcmVhbJIBC3N0ZWFrX2hvdXNl4AEA!16s%2Fg%2F1hd_vc8zg?entry=ttu")
                            )
                        }
                        IconButton(onClick = {
                            context.startActivity(intent)
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_turnright),
                                contentDescription = "Direcciones",
                                tint = Color.White,
                                modifier = Modifier
                                    .clip(CutCornerShape(50))
                                    .background(color = CustomPurple)
                                    .padding(4.dp),
                            )
                        }
                    }
                    Row {
                        Text(
                            text = "14-67, 5ta Avenida Zona 10",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.DarkGray
                        )
                    }
                    Row {
                        Text(
                            text = "12:00PM-12:00AM",
                            color = Color.Gray
                        )
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Button(
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Nils Muralles Morales",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = CustomOrange, contentColor = Color.White),
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Text(
                                text = "Iniciar",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        OutlinedButton(
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Cortes de carne \nQQQ",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .weight(1f),
                            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent, contentColor = CustomOrange),
                            border = BorderStroke(0.dp, Color.Transparent)
                        ) {
                            Text(
                                text = "Detalles",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
            }
        }
    }
}
@Preview
@Composable
private fun RestaurantLayoutPreview(){
    FrontendRestauranteTheme {
        Surface (
            modifier = Modifier.fillMaxSize()
        ){
            RestaurantLayout()
        }
    }
}