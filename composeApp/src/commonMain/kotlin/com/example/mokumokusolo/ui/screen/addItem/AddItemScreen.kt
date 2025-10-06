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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mokumokusolo.ui.theme.MokuMokuSoloTheme
import org.jetbrains.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen(
    onClose: () -> Unit,
    onAddItem: ((isIncome: Boolean, name: String, amount: String) -> Unit)? = null,
    viewModel: AddItemViewModel = viewModel { AddItemViewModel() },
    modifier: Modifier = Modifier
) {
    val addItemFormState by viewModel.addItemFormState.collectAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "追加",
                        style = MaterialTheme.typography.titleSmall
                    )
                },
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
                selectedIndex = addItemFormState.selectedIndex,
                onSelectedIndex = { newIndex ->
                    viewModel.updateSelectedIndex(newIndex)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (addItemFormState.selectedIndex == 0) {
                AddItemTextField(
                    value = addItemFormState.incomeData.name,
                    onValueChange = { newIncomeName ->
                        viewModel.updateIncomeName(newIncomeName)
                    },
                    label = { Text(text = "アプリ名") },
                    placeholder = { Text(text = "MokuMokuSolo") }
                )
                Spacer(modifier = Modifier.padding(8.dp))
                AddItemTextField(
                    value = addItemFormState.incomeData.amount,
                    onValueChange = { newIncomeAmount ->
                        viewModel.updateIncomeAmount(newIncomeAmount)
                    },
                    label = { Text(text = "現在の収益(月)") },
                    placeholder = { Text(text = "¥1,000") }
                )
            } else {
                AddItemTextField(
                    value = addItemFormState.expenseData.name,
                    onValueChange = { newExpenseName ->
                        viewModel.updateExpenseName(newExpenseName)
                    },
                    label = { Text(text = "サービス名") },
                    placeholder = { Text(text = "Netflix") }
                )
                Spacer(modifier = Modifier.padding(8.dp))
                AddItemTextField(
                    value = addItemFormState.expenseData.amount,
                    onValueChange = { newExpenseAmount ->
                        viewModel.updateExpenseAmount(newExpenseAmount)
                    },
                    label = { Text(text = "現在の支出(月)") },
                    placeholder = { Text(text = "¥1,000") }
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(onClick = {
                val isIncome = addItemFormState.selectedIndex == 0
                val name =
                    if (isIncome) addItemFormState.incomeData.name else addItemFormState.expenseData.name
                val amount =
                    if (isIncome) addItemFormState.incomeData.amount else addItemFormState.expenseData.amount
                onAddItem?.invoke(isIncome, name, amount)
                onClose()
            }) {
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
