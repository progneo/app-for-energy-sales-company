package com.enplus.energetic.ui.components.data

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enplus.energetic.R
import com.enplus.energetic.ui.theme.EnColor

@Composable
fun DataScreenHeader(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    icon: ImageVector,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier = Modifier
                .weight(0.8f, fill = false),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                ),
            )

            Text(
                text = subtitle,
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Normal,
                    color = EnColor.TextSubtitle,
                ),
            )
        }

        Box(
            modifier = Modifier
                .padding(start = 16.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(EnColor.OrangeBackground),
        ) {
            Icon(
                modifier = Modifier.align(Alignment.Center),
                imageVector = icon,
                contentDescription = stringResource(id = R.string.logo),
                tint = EnColor.Orange,
            )
        }
    }
}

