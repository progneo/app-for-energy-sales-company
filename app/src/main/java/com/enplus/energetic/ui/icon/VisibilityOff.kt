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

val EnIcons.VisibilityOff: ImageVector
    get() {
        if (_visibilityoff != null) {
            return _visibilityoff!!
        }
        _visibilityoff = Builder(
            name = "VisibilityOff",
            defaultWidth = 24.0.dp,
            defaultHeight =
            24.0.dp,
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
                moveTo(3.9999f, 4.0f)
                lineTo(19.9999f, 20.0f)
                moveTo(16.4999f, 16.7559f)
                curveTo(15.1473f, 17.4845f, 13.6185f, 17.9999f, 11.9999f, 17.9999f)
                curveTo(8.4692f, 17.9999f, 5.3662f, 15.5478f, 3.5868f, 13.7788f)
                curveTo(3.1171f, 13.3119f, 2.8823f, 13.0784f, 2.7328f, 12.6201f)
                curveTo(2.6262f, 12.2933f, 2.6262f, 11.7066f, 2.7328f, 11.3797f)
                curveTo(2.8823f, 10.9215f, 3.1176f, 10.6875f, 3.5883f, 10.2197f)
                curveTo(4.4851f, 9.3282f, 5.718f, 8.2636f, 7.1722f, 7.4268f)
                moveTo(19.4999f, 14.6335f)
                curveTo(19.8329f, 14.3405f, 20.138f, 14.0523f, 20.4117f, 13.7803f)
                lineTo(20.4146f, 13.7772f)
                curveTo(20.8832f, 13.3114f, 21.1182f, 13.0779f, 21.2674f, 12.6206f)
                curveTo(21.374f, 12.2938f, 21.3738f, 11.7068f, 21.2672f, 11.38f)
                curveTo(21.1178f, 10.9219f, 20.8827f, 10.6877f, 20.4133f, 10.2211f)
                curveTo(18.6338f, 8.4521f, 15.5305f, 6.0f, 11.9999f, 6.0f)
                curveTo(11.6624f, 6.0f, 11.3288f, 6.0224f, 10.9999f, 6.0645f)
                moveTo(13.3228f, 13.5f)
                curveTo(12.9702f, 13.8112f, 12.5071f, 14.0f, 11.9999f, 14.0f)
                curveTo(10.8953f, 14.0f, 9.9999f, 13.1046f, 9.9999f, 12.0f)
                curveTo(9.9999f, 11.4605f, 10.2135f, 10.9711f, 10.5608f, 10.6113f)
            }
        }
            .build()
        return _visibilityoff!!
    }

private var _visibilityoff: ImageVector? = null
