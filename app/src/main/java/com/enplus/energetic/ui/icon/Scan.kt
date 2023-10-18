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

val EnIcons.Scan: ImageVector
    get() {
        if (_scan != null) {
            return _scan!!
        }
        _scan = Builder(
            name = "Scan",
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
                moveTo(9.1667f, 4.0f)
                horizontalLineTo(5.8333f)
                curveTo(5.6123f, 4.0f, 5.4004f, 4.0878f, 5.2441f, 4.2441f)
                curveTo(5.0878f, 4.4004f, 5.0f, 4.6123f, 5.0f, 4.8333f)
                verticalLineTo(8.1667f)
                moveTo(9.1667f, 19.0f)
                horizontalLineTo(5.8333f)
                curveTo(5.6123f, 19.0f, 5.4004f, 18.9122f, 5.2441f, 18.7559f)
                curveTo(5.0878f, 18.5996f, 5.0f, 18.3877f, 5.0f, 18.1667f)
                verticalLineTo(14.8333f)
                moveTo(15.8333f, 19.0f)
                horizontalLineTo(19.1667f)
                curveTo(19.3877f, 19.0f, 19.5996f, 18.9122f, 19.7559f, 18.7559f)
                curveTo(19.9122f, 18.5996f, 20.0f, 18.3877f, 20.0f, 18.1667f)
                verticalLineTo(14.8333f)
                moveTo(15.8333f, 4.0f)
                horizontalLineTo(19.1667f)
                curveTo(19.3877f, 4.0f, 19.5996f, 4.0878f, 19.7559f, 4.2441f)
                curveTo(19.9122f, 4.4004f, 20.0f, 4.6123f, 20.0f, 4.8333f)
                verticalLineTo(8.1667f)
                moveTo(16.6667f, 11.5f)
                horizontalLineTo(8.3333f)
                moveTo(16.6667f, 8.1667f)
                horizontalLineTo(8.3333f)
                moveTo(16.6667f, 14.8333f)
                horizontalLineTo(8.3333f)
            }
        }
            .build()
        return _scan!!
    }

private var _scan: ImageVector? = null
