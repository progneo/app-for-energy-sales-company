package com.enplus.energetic.ui.components.oneTimePin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enplus.energetic.R
import com.enplus.energetic.ui.theme.TextGray

@Composable
internal fun LogoutButton(
    onLogoutButtonClick: () -> Unit,
) {
    Box(
        modifier = Modifier.height(64.dp),
    ) {
        TextButton(
            modifier = Modifier.align(Alignment.Center),
            onClick = { onLogoutButtonClick() },
            content = {
                Text(
                    text = stringResource(R.string.logout),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Normal,
                        color = TextGray,
                    ),
                )
            },
        )
    }
}
