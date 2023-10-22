package com.enplus.energetic.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val EnIcons.ChevronRight: ImageVector
    get() {
        if (_chevronright != null) {
            return _chevronright!!
        }
        _chevronright = Builder(name = "Chevronright", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFFF8E00)),
                    strokeLineWidth = 3.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(9.0f, 5.0f)
                lineTo(16.0f, 12.0f)
                lineTo(9.0f, 19.0f)
            }
        }
        .build()
        return _chevronright!!
    }

private var _chevronright: ImageVector? = null
