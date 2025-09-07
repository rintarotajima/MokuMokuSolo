package com.example.mokumokusolo.ui.screen.addItem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mokumokusolo.ui.theme.MokuMokuSoloTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen(
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    var appName by remember { mutableStateOf("") }
    var appAmount by remember { mutableStateOf("") }
    var expenditureName by remember { mutableStateOf("") }
    var expenditureAmount by remember { mutableStateOf("") }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "追加") },
                navigationIcon = {
                    IconButton(onClick = onClose) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SingleChoiceSegmentedButton(
                selectedIndex = selectedIndex,
                onSelectedIndex = { selectedIndex = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (selectedIndex == 0) {
                AddItemTextField(
                    value = appName,
                    onValueChange = { appName = it },
                    label = { Text(text = "アプリ名") },
                    placeholder = { Text(text = "MokuMokuSolo") }
                )
                Spacer(modifier = Modifier.padding(8.dp))
                AddItemTextField(
                    value = appAmount,
                    onValueChange = { appAmount = it },
                    label = { Text(text = "現在の収益(月)") },
                    placeholder = { Text(text = "¥1,000") }
                )
            } else {
                AddItemTextField(
                    value = expenditureName,
                    onValueChange = { expenditureName = it },
                    label = { Text(text = "サービス名") },
                    placeholder = { Text(text = "Netflix") }
                )
                Spacer(modifier = Modifier.padding(8.dp))
                AddItemTextField(
                    value = expenditureAmount,
                    onValueChange = { expenditureAmount = it },
                    label = { Text(text = "現在の支出(月)") },
                    placeholder = { Text(text = "¥1,000") }
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(onClick = {}) {
                Text("登録")
            }
        }
    }
}

@Preview
@Composable
fun AddItemScreenPreview() {
    MokuMokuSoloTheme {
        AddItemScreen(onClose = {})
    }
}
