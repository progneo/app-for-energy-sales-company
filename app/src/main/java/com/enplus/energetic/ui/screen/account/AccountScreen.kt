package com.enplus.energetic.ui.screen.account

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun AccountScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Account screen")
    }
}

@Preview("Account screen")
@Composable
fun AccountScreenPreview() {
    EnergeticTheme {
        AccountScreen()
    }
}
