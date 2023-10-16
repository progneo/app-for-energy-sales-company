package com.enplus.energetic.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EnIcons.Loader: ImageVector
    get() {
        if (_loader != null) {
            return _loader!!
        }
        _loader = Builder(
            name = "Loader",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 24.0f,
            viewportHeight = 24.0f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFFffffff)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero,
            ) {
                moveTo(23.001f, 12.0f)
                curveTo(23.5527f, 12.0f, 24.0043f, 12.4481f, 23.9584f, 12.9979f)
                curveTo(23.7766f, 15.1778f, 23.0014f, 17.2735f, 21.7082f, 19.0534f)
                curveTo(20.2187f, 21.1036f, 18.1183f, 22.6296f, 15.7082f, 23.4127f)
                curveTo(13.2981f, 24.1958f, 10.7019f, 24.1958f, 8.2918f, 23.4127f)
                curveTo(5.8817f, 22.6296f, 3.7813f, 21.1036f, 2.2918f, 19.0534f)
                curveTo(0.8023f, 17.0033f, 0.0f, 14.5342f, 0.0f, 12.0f)
                curveTo(-0.0f, 9.4658f, 0.8023f, 6.9967f, 2.2918f, 4.9466f)
                curveTo(3.7813f, 2.8964f, 5.8817f, 1.3704f, 8.2918f, 0.5873f)
                curveTo(10.3842f, -0.0926f, 12.6169f, -0.1822f, 14.7463f, 0.3185f)
                curveTo(15.2834f, 0.4448f, 15.57f, 1.0127f, 15.3995f, 1.5374f)
                curveTo(15.229f, 2.0622f, 14.6659f, 2.3441f, 14.1268f, 2.2267f)
                curveTo(12.4011f, 1.8512f, 10.6002f, 1.9381f, 8.9092f, 2.4875f)
                curveTo(6.9004f, 3.1402f, 5.1497f, 4.4122f, 3.9082f, 6.121f)
                curveTo(2.6667f, 7.8298f, 1.998f, 9.8878f, 1.998f, 12.0f)
                curveTo(1.998f, 14.1122f, 2.6667f, 16.1702f, 3.9082f, 17.879f)
                curveTo(5.1497f, 19.5878f, 6.9004f, 20.8598f, 8.9092f, 21.5125f)
                curveTo(10.918f, 22.1652f, 13.082f, 22.1652f, 15.0908f, 21.5125f)
                curveTo(17.0996f, 20.8598f, 18.8503f, 19.5878f, 20.0918f, 17.879f)
                curveTo(21.1369f, 16.4406f, 21.7761f, 14.7547f, 21.9522f, 12.9974f)
                curveTo(22.0072f, 12.4484f, 22.4493f, 12.0f, 23.001f, 12.0f)
                close()
            }
        }
            .build()
        return _loader!!
    }

private var _loader: ImageVector? = null
