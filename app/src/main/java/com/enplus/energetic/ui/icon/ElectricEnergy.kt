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

val EnIcons.ElectricEnergy: ImageVector
    get() {
        if (_electricEnergy != null) {
            return _electricEnergy!!
        }
        _electricEnergy = Builder(name = "ElectricEnergy", defaultWidth = 20.0.dp, defaultHeight
                = 21.0.dp, viewportWidth = 20.0f, viewportHeight = 21.0f).apply {
            path(fill = SolidColor(Color(0xFFFF8E00)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(3.75f, 8.6382f)
                curveTo(3.75f, 5.2809f, 6.5617f, 2.5833f, 10.0f, 2.5833f)
                curveTo(13.4383f, 2.5833f, 16.25f, 5.2809f, 16.25f, 8.6382f)
                curveTo(16.25f, 10.5998f, 15.4391f, 12.3697f, 13.9209f, 13.4858f)
                curveTo(13.8161f, 13.5629f, 13.7527f, 13.6584f, 13.7306f, 13.7522f)
                curveTo(13.6817f, 13.96f, 13.6275f, 14.2007f, 13.572f, 14.4591f)
                curveTo(13.5555f, 14.5361f, 13.4875f, 14.5912f, 13.4088f, 14.5912f)
                horizontalLineTo(10.7917f)
                curveTo(10.6996f, 14.5912f, 10.625f, 14.5166f, 10.625f, 14.4245f)
                verticalLineTo(13.8712f)
                lineTo(11.4994f, 12.4978f)
                curveTo(11.672f, 12.2268f, 11.6109f, 11.869f, 11.3582f, 11.6706f)
                lineTo(9.859f, 10.4932f)
                lineTo(10.5272f, 9.4437f)
                curveTo(10.7126f, 9.1526f, 10.6268f, 8.7662f, 10.3357f, 8.5808f)
                curveTo(10.0445f, 8.3955f, 9.6582f, 8.4812f, 9.4728f, 8.7724f)
                lineTo(8.5006f, 10.2994f)
                curveTo(8.328f, 10.5705f, 8.3891f, 10.9282f, 8.6418f, 11.1266f)
                lineTo(10.141f, 12.304f)
                lineTo(9.4728f, 13.3535f)
                curveTo(9.4089f, 13.4538f, 9.375f, 13.5703f, 9.375f, 13.6892f)
                verticalLineTo(14.4245f)
                curveTo(9.375f, 14.5166f, 9.3004f, 14.5912f, 9.2083f, 14.5912f)
                horizontalLineTo(6.5912f)
                curveTo(6.5125f, 14.5912f, 6.4445f, 14.5361f, 6.428f, 14.4591f)
                curveTo(6.3725f, 14.2007f, 6.3183f, 13.96f, 6.2694f, 13.7522f)
                curveTo(6.2473f, 13.6584f, 6.1839f, 13.5629f, 6.0791f, 13.4858f)
                curveTo(4.5609f, 12.3697f, 3.75f, 10.5998f, 3.75f, 8.6382f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF8E00)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(6.9008f, 15.8412f)
                curveTo(6.797f, 15.8412f, 6.7185f, 15.9351f, 6.7362f, 16.0374f)
                curveTo(6.823f, 16.5408f, 6.8871f, 16.9936f, 6.9057f, 17.2998f)
                curveTo(6.9582f, 18.1675f, 7.5973f, 18.8822f, 8.4519f, 19.0669f)
                lineTo(8.6152f, 19.1021f)
                curveTo(9.5272f, 19.2992f, 10.4728f, 19.2992f, 11.3848f, 19.1021f)
                lineTo(11.5481f, 19.0669f)
                curveTo(12.4027f, 18.8822f, 13.0418f, 18.1675f, 13.0943f, 17.2998f)
                curveTo(13.1128f, 16.9936f, 13.177f, 16.5408f, 13.2638f, 16.0374f)
                curveTo(13.2815f, 15.9351f, 13.203f, 15.8412f, 13.0992f, 15.8412f)
                horizontalLineTo(6.9008f)
                close()
            }
        }
        .build()
        return _electricEnergy!!
    }

private var _electricEnergy: ImageVector? = null
