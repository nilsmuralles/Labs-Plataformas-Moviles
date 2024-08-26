package com.uvg.contadordinamico.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.contadordinamico.ui.theme.ContadorDinamicoTheme

enum class Type {
    PLUS,
    MINUS
}

@Composable
fun CounterLayout(
    modifier: Modifier = Modifier
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var count by remember { mutableIntStateOf(0) }
        var increments by remember { mutableIntStateOf(0) }
        var decrements by remember { mutableIntStateOf(0) }
        var max by remember { mutableIntStateOf(0) }
        var min by remember { mutableIntStateOf(0) }
        var totalChanges by remember { mutableIntStateOf(0) }
        var changeLog = remember { mutableStateListOf<Type>() }

        Text(
            text = "Nils Muralles Morales",
            style = MaterialTheme.typography.displaySmall
        )
        Counter(
            count = count,
            onMinusChange = {
                count--
                decrements++
                totalChanges++
                if (count > max) max = count
                if (count < min) min = count
                changeLog.add(Type.MINUS)
            },
            onAddChange = {
                count++
                increments++
                totalChanges++
                if (count > max) max = count
                if (count < min) min = count
                changeLog.add(Type.PLUS)
            }
        )
        HorizontalDivider()
        Column (
            modifier = Modifier
                .padding(16.dp)
        ){
            Stat(label = "Total Incrementos: ", amount = increments)
            Stat(label = "Total Decrementos: ", amount = decrements)
            Stat(label = "Valor Máximo: ", amount = max)
            Stat(label = "Valor Mínimo: ", amount = min)
            Stat(label = "Total Cambios: ", amount = totalChanges)
        }
        Text(
            text = "Historial:",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        History(
            changeLog.toList(),
            decrements
        )
    }
}

@Composable
private fun Counter(
    modifier: Modifier = Modifier,
    count: Int,
    onAddChange: () -> Unit,
    onMinusChange: () -> Unit
){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 16.dp)
        ){
            IconButton(
                onClick = onMinusChange,
            ) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Delete button",
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(8.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            Text(
                text = count.toString(),
                style = MaterialTheme.typography.displayLarge
            )
            IconButton(
                onClick = onAddChange,
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Add button",
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(8.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Composable
private fun Stat(
    label: String,
    amount: Int
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = label,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = amount.toString(),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
private fun HistoryItem(
    type: Type,
    value: Int
){
    var bgColor:Color
    when (type) {
        Type.PLUS -> bgColor = Color(0xFF388E3C)
        Type.MINUS -> bgColor = MaterialTheme.colorScheme.error
    }
    Box (
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(bgColor)
            .padding(10.dp)
        ,
        contentAlignment = Alignment.Center
    ){
        Text(
            text = value.toString(),
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun History(
    changes: List<Type>,
    currentCont: Int
){
    LazyVerticalGrid(
        columns = GridCells.FixedSize(55.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        modifier = Modifier
            .padding(16.dp)
    ) {
        changes.forEachIndexed { index, type ->
            if (type == Type.MINUS){
                item {
                    HistoryItem(type = Type.MINUS, value = index + 1 - currentCont)
                }
            }
            if (type == Type.PLUS){
                item {
                    HistoryItem(type = Type.PLUS, value = index + 1)
                }
            }
        }
    }
}

@Preview
@Composable
private fun CounterLayoutPreview(){
    ContadorDinamicoTheme {
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ){
            CounterLayout()
        }
    }
}