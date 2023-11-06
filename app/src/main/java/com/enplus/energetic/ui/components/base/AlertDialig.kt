package com.enplus.energetic.ui.components.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.enplus.energetic.ui.theme.EnColor

@Composable
fun AlertDialog(
    title: String,
    description: String,
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    dismissButton: @Composable (() -> Unit)? = null,
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = EnColor.Background,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp,
            ),
            shape = RoundedCornerShape(size = 8.dp),
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 16.dp,
                    end = 20.dp,
                    bottom = 20.dp,
                    start = 20.dp,
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    color = EnColor.TextTitle,
                )
                Text(
                    text = description,
                    fontSize = 16.sp,
                    color = EnColor.TextTitle,
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 8.dp,
                        alignment = Alignment.End,
                    ),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    dismissButton?.invoke()
                    confirmButton()
                }
            }
        }
    }
}
