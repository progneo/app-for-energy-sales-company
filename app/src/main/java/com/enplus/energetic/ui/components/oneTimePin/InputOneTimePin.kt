package com.enplus.energetic.ui.components.oneTimePin

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enplus.energetic.R
import com.enplus.energetic.ui.entities.PinStateUiModel
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun InputOneTimePin(
    modifier: Modifier = Modifier,
    title: String,
    pinStateUiModel: PinStateUiModel,
    pinLength: Int = 4,
    pinInputtedLength: Int,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = title,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 19.sp,
                fontWeight = FontWeight.Medium,
            ),
        )

        AnimatedContent(
            targetState = pinStateUiModel,
            transitionSpec = {
                fadeIn(
                    animationSpec = tween(1000)
                ) togetherWith fadeOut(animationSpec = tween(1000))
            },
            label = "animated content",
        ) { state ->
            when (state) {
                PinStateUiModel.INPUT_PROCESS -> {
                    Row(
                        modifier = modifier,
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        repeat(pinLength) {
                            val animatedColor by animateColorAsState(
                                targetValue = if (it < pinInputtedLength) {
                                    EnColor.Orange
                                } else {
                                    EnColor.LightGray_Light
                                },
                                label = "animated color",
                            )

                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(CircleShape)
                                    .background(color = animatedColor),
                            )
                        }
                    }
                }
                PinStateUiModel.SUCCESS -> {
                    Row(
                        modifier = modifier,
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        val animatedColor by animateColorAsState(
                            targetValue = EnColor.Success,
                            label = "animated color",
                        )

                        repeat(pinLength) {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(CircleShape)
                                    .background(color = animatedColor),
                            )
                        }
                    }
                }
                PinStateUiModel.ERROR -> {
                    Row(
                        modifier = modifier,
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        val animatedColor by animateColorAsState(
                            targetValue = EnColor.Error,
                            label = "animated color",
                        )

                        repeat(pinLength) {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(CircleShape)
                                    .background(color = animatedColor),
                            )
                        }
                    }

                }
            }
        }
    }
}

@Preview(name = "Empty input PIN")
@Composable
fun InputOneTimePinPreview() {
    EnergeticTheme {
        InputOneTimePin(
            title = stringResource(id = R.string.pin_screen_input_pin_title),
            pinStateUiModel = PinStateUiModel.INPUT_PROCESS,
            pinInputtedLength = 0,
        )
    }
}

@Preview(name = "Inputting PIN")
@Composable
fun InputOneTimePinWithInputtedPinPreview() {
    EnergeticTheme {
        InputOneTimePin(
            title = stringResource(id = R.string.pin_screen_input_pin_title),
            pinStateUiModel = PinStateUiModel.INPUT_PROCESS,
            pinInputtedLength = 3,
        )
    }
}

@Preview(name = "Correct input PIN")
@Composable
fun CorrectInputPinPreview() {
    EnergeticTheme {
        InputOneTimePin(
            title = stringResource(id = R.string.pin_screen_input_pin_title),
            pinStateUiModel = PinStateUiModel.SUCCESS,
            pinInputtedLength = 4,
        )
    }
}

@Preview(name = "Incorrect input PIN")
@Composable
fun IncorrectInputPinPreview() {
    EnergeticTheme {
        InputOneTimePin(
            title = stringResource(id = R.string.pin_screen_input_pin_title),
            pinStateUiModel = PinStateUiModel.ERROR,
            pinInputtedLength = 4,
        )
    }
}
