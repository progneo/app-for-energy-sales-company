package com.enplus.energetic.ui.components.oneTimePin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        ButtonsColumn(
            columnNumber = 1,
            onNumberButtonClick = { onNumberButtonClick(it) },
            content = {
                if (isShowLogoutButton) {
                    LogoutButton(onLogoutButtonClick)
                }
            },
        )

        ButtonsColumn(
            columnNumber = 2,
            onNumberButtonClick = { onNumberButtonClick(it) },
            content = {
                val value = 0
                NumberButton(
                    value = value,
                    onNumberClick = { onNumberButtonClick(value) },
                )
            },
        )

        ButtonsColumn(
            columnNumber = 3,
            onNumberButtonClick = { onNumberButtonClick(it) },
            content = {
                if (isShowBackspaceButton) {
                    BackspaceButton(onBackspaceButtonClick)
                }
            },
        )
    }
}

@Composable
private fun ButtonsColumn(
    columnNumber: Int,
    onNumberButtonClick: (Int) -> Unit,
    content: @Composable (() -> Unit)? = null,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        repeat(3) { row ->
            val value = columnNumber + row * 3

            NumberButton(
                value = value,
                onNumberClick = { onNumberButtonClick(value) },
            )
        }

        content?.let {
            it()
        }
    }
}

@Preview(showBackground = true, name = "Number Pad")
@Composable
fun NumberPadPreview() {
    EnergeticTheme {
        NumberPad(
            isShowBackspaceButton = false,
            isShowLogoutButton = false,
            onNumberButtonClick = { },
            onBackspaceButtonClick = { },
            onLogoutButtonClick = { },
        )
    }
}

@Preview(showBackground = true, name = "Number Pad with backspace button")
@Composable
fun NumberPadWithBackspaceButtonPreview() {
    EnergeticTheme {
        NumberPad(
            isShowBackspaceButton = true,
            isShowLogoutButton = false,
            onNumberButtonClick = { },
            onBackspaceButtonClick = { },
            onLogoutButtonClick = { },
        )
    }
}

@Preview(showBackground = true, name = "Number Pad with logout button")
@Composable
fun NumberPadWithLogoutButtonPreview() {
    EnergeticTheme {
        NumberPad(
            isShowBackspaceButton = false,
            isShowLogoutButton = true,
            onNumberButtonClick = { },
            onBackspaceButtonClick = { },
            onLogoutButtonClick = { },
        )
    }
}
