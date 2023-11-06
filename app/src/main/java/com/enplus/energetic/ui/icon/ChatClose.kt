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

val EnIcons.DataNotFoundIcon: ImageVector
    get() {
        if (_dataNotFoundIcon != null) {
            return _dataNotFoundIcon!!
        }
        _dataNotFoundIcon = Builder(name = "DataNotFoundIcon", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFFF8E00)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.0f, 13.0f)
                lineTo(12.0f, 11.0f)
                moveTo(12.0f, 11.0f)
                lineTo(14.0f, 9.0f)
                moveTo(12.0f, 11.0f)
                lineTo(10.0f, 9.0f)
                moveTo(12.0f, 11.0f)
                lineTo(14.0f, 13.0f)
                moveTo(7.1236f, 18.7012f)
                lineTo(5.5996f, 19.9203f)
                curveTo(4.7674f, 20.5861f, 4.3512f, 20.9191f, 4.001f, 20.9195f)
                curveTo(3.6964f, 20.9198f, 3.4084f, 20.7813f, 3.2185f, 20.5433f)
                curveTo(3.0f, 20.2696f, 3.0f, 19.7369f, 3.0f, 18.6712f)
                verticalLineTo(7.2002f)
                curveTo(3.0f, 6.0801f, 3.0f, 5.5196f, 3.218f, 5.0918f)
                curveTo(3.4097f, 4.7155f, 3.7155f, 4.4097f, 4.0918f, 4.218f)
                curveTo(4.5196f, 4.0f, 5.0801f, 4.0f, 6.2002f, 4.0f)
                horizontalLineTo(17.8002f)
                curveTo(18.9203f, 4.0f, 19.4796f, 4.0f, 19.9074f, 4.218f)
                curveTo(20.2837f, 4.4097f, 20.5905f, 4.7155f, 20.7822f, 5.0918f)
                curveTo(21.0f, 5.5192f, 21.0f, 6.079f, 21.0f, 7.1969f)
                verticalLineTo(14.8036f)
                curveTo(21.0f, 15.9215f, 21.0f, 16.4805f, 20.7822f, 16.9079f)
                curveTo(20.5905f, 17.2842f, 20.2843f, 17.5905f, 19.908f, 17.7822f)
                curveTo(19.4806f, 18.0f, 18.921f, 18.0f, 17.8031f, 18.0f)
                horizontalLineTo(9.1221f)
                curveTo(8.706f, 18.0f, 8.4988f, 18.0f, 8.2998f, 18.0408f)
                curveTo(8.1233f, 18.0771f, 7.9522f, 18.1368f, 7.7917f, 18.2188f)
                curveTo(7.6128f, 18.3101f, 7.4525f, 18.4384f, 7.1348f, 18.6926f)
                lineTo(7.1236f, 18.7012f)
                close()
            }
        }
        .build()
        return _dataNotFoundIcon!!
    }

private var _dataNotFoundIcon: ImageVector? = null
