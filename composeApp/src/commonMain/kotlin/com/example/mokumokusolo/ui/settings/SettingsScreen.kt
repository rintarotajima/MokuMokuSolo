package com.example.mokumokusolo.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mokumokusolo.util.UrlOpener
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    urlOpener: UrlOpener = koinInject()
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("設定") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "戻る"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Terms of Service
            ListItem(
                headlineContent = { Text("利用規約") },
                trailingContent = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        // TODO: Replace with your actual Terms of Service URL
                        urlOpener.openUrl("https://example.com/terms")
                    }
            )
            HorizontalDivider()

            // Privacy Policy
            ListItem(
                headlineContent = { Text("プライバシーポリシー") },
                trailingContent = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        // TODO: Replace with your actual Privacy Policy URL
                        urlOpener.openUrl("https://slow-blanket-951.notion.site/28e5e2d6531a800bb8f3f44b7bf27ae8")
                    }
            )
            HorizontalDivider()

            // Developer X (Twitter) Link
            ListItem(
                headlineContent = { Text("開発者のXアカウント") },
                trailingContent = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        // TODO: Replace with your actual X (Twitter) profile URL
                        urlOpener.openUrl("https://x.com/rinta________")
                    }
            )
            HorizontalDivider()
        }
    }
}
