package com.rintaroo.afrel.ui.home

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
import com.rintaroo.afrel.ui.theme.AfrelTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppsChip(
    selected: Boolean,
    onClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedFilterChip(
        selected = selected,
        onClick = onClicked,
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
fun AllChip(
    selected: Boolean,
    onClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedFilterChip(
        selected = selected,
        onClick = onClicked,
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
fun ExpenditureChip(
    selected: Boolean,
    onClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedFilterChip(
        selected = selected,
        onClick = onClicked,
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
    AfrelTheme {
        var selectedChip by remember { mutableStateOf("all") }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            AllChip(
                selected = selectedChip == "all",
                onClicked = { selectedChip = "all" }
            )
            AppsChip(
                selected = selectedChip == "apps",
                onClicked = { selectedChip = "apps" }
            )
            ExpenditureChip(
                selected = selectedChip == "expenditures",
                onClicked = { selectedChip = "expenditures" }
            )
        }
    }
}
