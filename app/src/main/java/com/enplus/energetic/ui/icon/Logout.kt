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

val EnIcons.Logout: ImageVector
    get() {
        if (_logout != null) {
            return _logout!!
        }
        _logout = Builder(
            name = "Logout",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 24.0f,
            viewportHeight = 24.0f,
        ).apply {
            path(
                fill = SolidColor(Color(0x00000000)),
                stroke = SolidColor(Color(0xFFffffff)),
                strokeLineWidth = 3.0f,
                strokeLineCap = Round,
                strokeLineJoin =
                StrokeJoin.Companion.Round,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero,
            ) {
                moveTo(12.0f, 15.0f)
                lineTo(15.0f, 12.0f)
                moveTo(15.0f, 12.0f)
                lineTo(12.0f, 9.0f)
                moveTo(15.0f, 12.0f)
                horizontalLineTo(4.0f)
                moveTo(9.0f, 7.2486f)
                verticalLineTo(7.2002f)
                curveTo(9.0f, 6.0801f, 9.0f, 5.5196f, 9.218f, 5.0918f)
                curveTo(9.4097f, 4.7155f, 9.7155f, 4.4097f, 10.0918f, 4.218f)
                curveTo(10.5196f, 4.0f, 11.0801f, 4.0f, 12.2002f, 4.0f)
                horizontalLineTo(16.8002f)
                curveTo(17.9203f, 4.0f, 18.4796f, 4.0f, 18.9074f, 4.218f)
                curveTo(19.2837f, 4.4097f, 19.5905f, 4.7155f, 19.7822f, 5.0918f)
                curveTo(20.0f, 5.5192f, 20.0f, 6.079f, 20.0f, 7.1969f)
                verticalLineTo(16.8036f)
                curveTo(20.0f, 17.9215f, 20.0f, 18.4805f, 19.7822f, 18.9079f)
                curveTo(19.5905f, 19.2842f, 19.2837f, 19.5905f, 18.9074f, 19.7822f)
                curveTo(18.48f, 20.0f, 17.921f, 20.0f, 16.8031f, 20.0f)
                horizontalLineTo(12.1969f)
                curveTo(11.079f, 20.0f, 10.5192f, 20.0f, 10.0918f, 19.7822f)
                curveTo(9.7155f, 19.5905f, 9.4097f, 19.2839f, 9.218f, 18.9076f)
                curveTo(9.0f, 18.4798f, 9.0f, 17.9201f, 9.0f, 16.8f)
                verticalLineTo(16.75f)
            }
        }
            .build()
        return _logout!!
    }

private var _logout: ImageVector? = null
