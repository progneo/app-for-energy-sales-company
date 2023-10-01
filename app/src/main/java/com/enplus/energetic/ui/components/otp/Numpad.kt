package com.enplus.energetic.ui.components.otp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enplus.energetic.R
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun NumberPad(
    modifier: Modifier = Modifier,
    isShowBackspaceButton: Boolean,
    isShowLogoutButton: Boolean,
    onNumberButtonClick: (Int) -> Unit,
    onBackspaceButtonClick: () -> Unit,
    onLogoutButtonClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(50.dp),
    ) {
        repeat(3) { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                repeat(3) { column ->
                    val value = column + row * 3 + 1

                    NumberButton(
                        value = value,
                        onNumberClick = { onNumberButtonClick(value) }
                    )
                }
            }
        }

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            val value = 0

            if (isShowLogoutButton) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .clip(MaterialTheme.shapes.small)
                        .clickable { onLogoutButtonClick() },
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        text = stringResource(R.string.logout),
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
            }

            NumberButton(
                modifier = Modifier.align(Alignment.Center),
                value = value,
                onNumberClick = { onNumberButtonClick(value) }
            )

            if (isShowBackspaceButton) {
                IconButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    onClick = { onBackspaceButtonClick() },
                ) {
                    Icon(
                        modifier = Modifier.size(28.dp),
                        imageVector = Icons.Outlined.Backspace,
                        contentDescription = "backspace",
                    )
                }
            }
        }
    }
}

@Composable
fun NumberButton(
    modifier: Modifier = Modifier,
    value: Int,
    onNumberClick: (Int) -> Unit,
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .clickable { onNumberClick(value) },
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = value.toString(),
            style = MaterialTheme.typography.headlineMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NumberPadPreview() {
    EnergeticTheme {
        NumberPad(
            modifier = Modifier.padding(horizontal = 70.dp),
            isShowBackspaceButton = false,
            isShowLogoutButton = false,
            onNumberButtonClick = { },
            onBackspaceButtonClick = { },
            onLogoutButtonClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NumberPadWithBackspaceButtonPreview() {
    EnergeticTheme {
        NumberPad(
            modifier = Modifier.padding(horizontal = 70.dp),
            isShowBackspaceButton = true,
            isShowLogoutButton = false,
            onNumberButtonClick = { },
            onBackspaceButtonClick = { },
            onLogoutButtonClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NumberPadWithLogoutButtonPreview() {
    EnergeticTheme {
        NumberPad(
            modifier = Modifier.padding(horizontal = 70.dp),
            isShowBackspaceButton = false,
            isShowLogoutButton = true,
            onNumberButtonClick = { },
            onBackspaceButtonClick = { },
            onLogoutButtonClick = { },
        )
    }
}
