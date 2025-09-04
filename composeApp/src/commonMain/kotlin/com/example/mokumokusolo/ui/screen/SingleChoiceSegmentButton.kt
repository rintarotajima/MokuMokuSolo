package com.example.mokumokusolo.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SingleChoiceSegmentedButton(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("収益", "支出")

    SingleChoiceSegmentedButtonRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp)
    ) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = RoundedCornerShape(4.dp),
                onClick = { selectedIndex = index },
                selected = index == selectedIndex,
                label = { Text(label) }
            )
        }
    }
}

@Preview
@Composable
fun SingleChoiceSegmentedButtonPreview() {
    SingleChoiceSegmentedButton()
}