package com.example.mokumokusolo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mokumokusolo.ui.theme.MokuMokuSoloTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppsChip(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(false) }
    ElevatedFilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(text = "アプリ") },
        modifier = modifier.padding(4.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Apps,
                contentDescription = null
            )
        }
    )
}

@Composable
fun AllChip(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(false) }
    ElevatedFilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(text = "すべて") },
        modifier = modifier.padding(4.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.List,
                contentDescription = null
            )
        }
    )
}

@Composable
fun ExpenditureChip(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(false) }
    ElevatedFilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(text = "支出") },
        modifier = modifier.padding(4.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.CreditCard,
                contentDescription = null
            )
        }
    )
}


@Preview
@Composable
fun ChipsPreview() {
    MokuMokuSoloTheme {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            AllChip()
            AppsChip()
            ExpenditureChip()
        }
    }
}
