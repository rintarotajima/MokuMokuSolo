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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mokumokusolo.ui.theme.MokuMokuSoloTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

data class AddItemFormState(
    val selectedIndex: Int = 0,
    val incomeData: IncomeData = IncomeData(),
    val expenseData: ExpenseData = ExpenseData()
)

data class IncomeData(
    val name: String = "",
    val amount: String = ""
)

data class ExpenseData(
    val name: String = "",
    val amount: String = ""
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreen(
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    var formState by remember { mutableStateOf(AddItemFormState()) }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "追加", fontSize = 20.sp) },
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
                selectedIndex = formState.selectedIndex,
                onSelectedIndex = { newIndex ->
                    formState = formState.copy(selectedIndex = newIndex)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (formState.selectedIndex == 0) {
                AddItemTextField(
                    value = formState.incomeData.name,
                    onValueChange = { newIncomeName ->
                        formState = formState.copy(
                            incomeData = formState.incomeData.copy(name = newIncomeName)
                        )
                    },
                    label = { Text(text = "アプリ名") },
                    placeholder = { Text(text = "MokuMokuSolo") }
                )
                Spacer(modifier = Modifier.padding(8.dp))
                AddItemTextField(
                    value = formState.incomeData.amount,
                    onValueChange = { newIncomeAmount ->
                        formState = formState.copy(
                            incomeData = formState.incomeData.copy(amount = newIncomeAmount)
                        )
                    },
                    label = { Text(text = "現在の収益(月)") },
                    placeholder = { Text(text = "¥1,000") }
                )
            } else {
                AddItemTextField(
                    value = formState.expenseData.name,
                    onValueChange = { newExpenseName ->
                        formState = formState.copy(
                            expenseData = formState.expenseData.copy(name = newExpenseName)
                        )
                    },
                    label = { Text(text = "サービス名") },
                    placeholder = { Text(text = "Netflix") }
                )
                Spacer(modifier = Modifier.padding(8.dp))
                AddItemTextField(
                    value = formState.expenseData.amount,
                    onValueChange = { newExpenseAmount ->
                        formState = formState.copy(
                            expenseData = formState.expenseData.copy(amount = newExpenseAmount)
                        )
                    },
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
