package com.enplus.energetic.ui.screen.data

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun DataScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Data screen")
    }
}

@Preview("Data screen")
@Composable
fun DataScreenPreview() {
    EnergeticTheme {
        DataScreen()
    }
}
