package com.uvg.contadordinamico.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.contadordinamico.ui.theme.ContadorDinamicoTheme

@Composable
fun CounterLayout(modifier: Modifier = Modifier){
    Counter()
}

@Composable
fun Counter(modifier: Modifier = Modifier){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(
            onClick = { /*TODO*/ },
            shape = CircleShape
        ) {
            Icon(
                Icons.Filled.Delete,
                contentDescription = "Delete button")
        }
        Text(
            text = "50"
        )
        Button(
            onClick = { /*TODO*/ },
            shape = CircleShape
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Add button")
        }
    }
}

@Preview
@Composable
private fun CounterLayoutPreview(){
    ContadorDinamicoTheme {
        Surface (
            modifier = Modifier.fillMaxWidth()
        ){
            CounterLayout()
        }
    }
}