package com.rintaroo.afrel.ui.addItem

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AddItemTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    placeholder: @Composable () -> Unit,
    isNumericInput: Boolean = false
) {
    TextField(
        value = value,
        onValueChange = { newValue ->
            if (isNumericInput) {
                if (newValue.isEmpty() || newValue.all { it.isDigit() }) {
                    onValueChange(newValue)
                }
            } else {
                onValueChange(newValue)
            }
        },
        modifier = modifier,
        label = label,
        placeholder = placeholder,
        keyboardOptions = if (isNumericInput) {
            KeyboardOptions(keyboardType = KeyboardType.Number)
        } else {
            KeyboardOptions.Default
        },
        singleLine = true
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