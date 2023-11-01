package com.enplus.energetic.ui.components.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enplus.energetic.R
import com.enplus.energetic.ui.components.base.Card
import com.enplus.energetic.ui.icon.ChevronRight
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.theme.EnColor.CharacteristicTitle
import com.enplus.energetic.ui.theme.EnColor.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressDataCard(
    flatNumber: Int,
    personNumber: Long,
    metersCounter: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onClick,
    ) {
        Column(
            modifier = modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 20.dp,
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = stringResource(
                        id = R.string.address_data_card_title,
                        flatNumber,
                        personNumber,
                    ),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                Icon(
                    imageVector = EnIcons.ChevronRight,
                    contentDescription = null,
                    tint = Orange,
                )
            }
            Text(
                text = stringResource(id = R.string.meters_count, metersCounter.toString()),
                color = CharacteristicTitle,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}

@Preview(name = "Card with text")
@Composable
fun AddressDataCardPreview() {
    AddressDataCard(
        flatNumber = 34,
        personNumber = 111209184,
        metersCounter = 3,
        onClick = {},
    )
}
