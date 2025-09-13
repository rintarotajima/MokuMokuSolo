package com.example.mokumokusolo.ui.screen.addItem

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AddItemTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    placeholder: @Composable () -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = label,
        placeholder = placeholder
    )
}

@Preview
@Composable
fun AddItemTextFieldPreview() {
    AddItemTextField(
        value = "サンプル",
        onValueChange = {},
        label = { Text(text = "アプリ名") },
        placeholder = { Text(text = "MokuMokuSolo") }
    )
}