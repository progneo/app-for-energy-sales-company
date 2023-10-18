package com.enplus.energetic.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EnIcons.HotWater: ImageVector
    get() {
        if (_hotWater != null) {
            return _hotWater!!
        }
        _hotWater = Builder(name = "HotWater", defaultWidth = 20.0.dp, defaultHeight = 21.0.dp,
                viewportWidth = 20.0f, viewportHeight = 21.0f).apply {
            path(fill = SolidColor(Color(0xFFFF8E00)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.0521f, 2.2209f)
                curveTo(9.8108f, 2.1151f, 9.573f, 2.1892f, 9.4201f, 2.3449f)
                curveTo(9.2716f, 2.4962f, 9.1973f, 2.7271f, 9.2494f, 2.9599f)
                curveTo(9.3316f, 3.3273f, 9.375f, 3.7096f, 9.375f, 4.1023f)
                curveTo(9.375f, 4.9988f, 9.149f, 5.6267f, 8.7603f, 6.1473f)
                curveTo(8.365f, 6.6764f, 7.7929f, 7.1072f, 7.0705f, 7.5933f)
                curveTo(7.0592f, 7.6009f, 7.0486f, 7.6097f, 7.039f, 7.6194f)
                lineTo(6.9515f, 7.7076f)
                curveTo(5.4016f, 8.7089f, 4.375f, 10.4523f, 4.375f, 12.4356f)
                curveTo(4.375f, 15.5422f, 6.8934f, 18.0606f, 10.0f, 18.0606f)
                curveTo(13.1066f, 18.0606f, 15.625f, 15.5422f, 15.625f, 12.4356f)
                curveTo(15.625f, 11.5235f, 15.4077f, 10.6615f, 15.022f, 9.8991f)
                curveTo(14.9906f, 9.8371f, 14.9303f, 9.7949f, 14.8613f, 9.7864f)
                curveTo(14.7923f, 9.778f, 14.7237f, 9.8045f, 14.6783f, 9.8572f)
                curveTo(14.6196f, 9.9253f, 14.562f, 9.9925f, 14.5053f, 10.0588f)
                curveTo(13.7734f, 10.9139f, 13.1827f, 11.604f, 11.9718f, 11.9123f)
                curveTo(11.9203f, 11.9254f, 11.8883f, 11.9157f, 11.8656f, 11.9015f)
                curveTo(11.8389f, 11.8848f, 11.8097f, 11.8515f, 11.7896f, 11.7983f)
                curveTo(11.7479f, 11.6873f, 11.7658f, 11.5458f, 11.8513f, 11.4531f)
                curveTo(12.499f, 10.7509f, 12.9591f, 9.7978f, 13.1235f, 8.4418f)
                curveTo(13.4314f, 5.9019f, 12.2771f, 3.1964f, 10.0521f, 2.2209f)
                close()
            }
        }
        .build()
        return _hotWater!!
    }

private var _hotWater: ImageVector? = null
