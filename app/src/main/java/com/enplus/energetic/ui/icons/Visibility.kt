package com.enplus.energetic.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EnIcons.Visibility: ImageVector
    get() {
        if (_visibility != null) {
            return _visibility!!
        }
        _visibility = Builder(
            name = "Visibility",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 24.0f,
            viewportHeight = 24.0f,
        ).apply {
            path(
                fill = SolidColor(Color(0x00000000)),
                stroke = SolidColor(Color(0xFFffffff)),
                strokeLineWidth = 2.0f,
                strokeLineCap = Round,
                strokeLineJoin =
                StrokeJoin.Companion.Round,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero,
            ) {
                moveTo(3.5868f, 13.7788f)
                curveTo(5.3662f, 15.5478f, 8.4695f, 17.9999f, 12.0002f, 17.9999f)
                curveTo(15.5308f, 17.9999f, 18.6335f, 15.5478f, 20.413f, 13.7788f)
                curveTo(20.8823f, 13.3123f, 21.1177f, 13.0782f, 21.2671f, 12.6201f)
                curveTo(21.3738f, 12.2933f, 21.3738f, 11.7067f, 21.2671f, 11.3799f)
                curveTo(21.1177f, 10.9218f, 20.8823f, 10.6877f, 20.413f, 10.2211f)
                curveTo(18.6335f, 8.4521f, 15.5308f, 6.0f, 12.0002f, 6.0f)
                curveTo(8.4695f, 6.0f, 5.3662f, 8.4521f, 3.5868f, 10.2211f)
                curveTo(3.1171f, 10.688f, 2.8823f, 10.9216f, 2.7328f, 11.3799f)
                curveTo(2.6262f, 11.7067f, 2.6262f, 12.2933f, 2.7328f, 12.6201f)
                curveTo(2.8823f, 13.0784f, 3.1171f, 13.3119f, 3.5868f, 13.7788f)
                close()
            }
            path(
                fill = SolidColor(Color(0x00000000)),
                stroke = SolidColor(Color(0xFFffffff)),
                strokeLineWidth = 2.0f,
                strokeLineCap = Round,
                strokeLineJoin =
                StrokeJoin.Companion.Round,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero,
            ) {
                moveTo(10.0f, 12.0f)
                curveTo(10.0f, 13.1046f, 10.8954f, 14.0f, 12.0f, 14.0f)
                curveTo(13.1046f, 14.0f, 14.0f, 13.1046f, 14.0f, 12.0f)
                curveTo(14.0f, 10.8954f, 13.1046f, 10.0f, 12.0f, 10.0f)
                curveTo(10.8954f, 10.0f, 10.0f, 10.8954f, 10.0f, 12.0f)
                close()
            }
        }
            .build()
        return _visibility!!
    }

private var _visibility: ImageVector? = null
