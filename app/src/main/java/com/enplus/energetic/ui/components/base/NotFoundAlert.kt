package com.enplus.energetic.ui.components.base

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enplus.energetic.R
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun NotFoundAlert(
    onDismissRequest: () -> Unit,
) {
    AlertDialog(
        title = stringResource(R.string.not_found_alert_title),
        description = stringResource(R.string.not_found_alert_desc),
        onDismissRequest = onDismissRequest,
        confirmButton = {
            Text(
                modifier = Modifier
                    .offset(x = 8.dp, y = 4.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { onDismissRequest() }
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                text = stringResource(R.string.not_found_alert_button),
                color = EnColor.Blue,
            )
        },
    )
}

@Preview(name = "Not found alert")
@Composable
fun NoPermissionAlertPreview() {
    EnergeticTheme {
        NotFoundAlert(
            onDismissRequest = {},
        )
    }
}
