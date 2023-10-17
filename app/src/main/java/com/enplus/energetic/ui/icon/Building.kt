package com.enplus.energetic.ui.icon

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EnIcons.Building: ImageVector
    get() {
        if (_building != null) {
            return _building!!
        }
        _building = Builder(name = "Building", defaultWidth = 28.0.dp, defaultHeight = 28.0.dp,
                viewportWidth = 28.0f, viewportHeight = 28.0f).apply {
            path(fill = linearGradient(0.0f to Color(0xFFFF8E00), 1.0f to Color(0x00FF8E00), start =
                    Offset(11.8122f,6.94944f), end = Offset(22.3829f,26.3371f)), stroke = null,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.333f, 23.3333f)
                horizontalLineTo(4.6663f)
                verticalLineTo(7.2336f)
                curveTo(4.6663f, 5.9268f, 4.6663f, 5.2729f, 4.9207f, 4.7738f)
                curveTo(5.1444f, 4.3347f, 5.5011f, 3.978f, 5.9401f, 3.7543f)
                curveTo(6.4392f, 3.5f, 7.0931f, 3.5f, 8.3999f, 3.5f)
                horizontalLineTo(12.5999f)
                curveTo(13.9067f, 3.5f, 14.5592f, 3.5f, 15.0583f, 3.7543f)
                curveTo(15.4973f, 3.978f, 15.8552f, 4.3347f, 16.0789f, 4.7738f)
                curveTo(16.333f, 5.2724f, 16.333f, 5.9255f, 16.333f, 7.2297f)
                verticalLineTo(14.0f)
                curveTo(16.333f, 12.9128f, 16.333f, 12.3695f, 16.5106f, 11.9407f)
                curveTo(16.7474f, 11.3689f, 17.2014f, 10.9144f, 17.7731f, 10.6776f)
                curveTo(18.2019f, 10.5f, 18.7455f, 10.5f, 19.8327f, 10.5f)
                curveTo(20.9199f, 10.5f, 21.4641f, 10.5f, 21.8929f, 10.6776f)
                curveTo(22.4646f, 10.9144f, 22.9185f, 11.3689f, 23.1553f, 11.9407f)
                curveTo(23.3329f, 12.3695f, 23.333f, 12.9128f, 23.333f, 14.0f)
                verticalLineTo(23.3333f)
                horizontalLineTo(16.333f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFFEF1E2)),
                    strokeLineWidth = 1.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(2.333f, 23.3333f)
                horizontalLineTo(4.6663f)
                moveTo(4.6663f, 23.3333f)
                horizontalLineTo(16.333f)
                moveTo(4.6663f, 23.3333f)
                verticalLineTo(7.2336f)
                curveTo(4.6663f, 5.9268f, 4.6663f, 5.2729f, 4.9207f, 4.7738f)
                curveTo(5.1444f, 4.3347f, 5.5011f, 3.978f, 5.9401f, 3.7543f)
                curveTo(6.4392f, 3.5f, 7.0931f, 3.5f, 8.3999f, 3.5f)
                horizontalLineTo(12.5999f)
                curveTo(13.9067f, 3.5f, 14.5592f, 3.5f, 15.0583f, 3.7543f)
                curveTo(15.4973f, 3.978f, 15.8552f, 4.3347f, 16.0789f, 4.7738f)
                curveTo(16.333f, 5.2724f, 16.333f, 5.9255f, 16.333f, 7.2297f)
                verticalLineTo(14.0f)
                moveTo(16.333f, 23.3333f)
                horizontalLineTo(23.333f)
                moveTo(16.333f, 23.3333f)
                verticalLineTo(14.0f)
                moveTo(23.333f, 23.3333f)
                horizontalLineTo(25.6663f)
                moveTo(23.333f, 23.3333f)
                verticalLineTo(14.0f)
                curveTo(23.333f, 12.9128f, 23.3329f, 12.3695f, 23.1553f, 11.9407f)
                curveTo(22.9185f, 11.3689f, 22.4646f, 10.9144f, 21.8929f, 10.6776f)
                curveTo(21.4641f, 10.5f, 20.9199f, 10.5f, 19.8327f, 10.5f)
                curveTo(18.7455f, 10.5f, 18.2019f, 10.5f, 17.7731f, 10.6776f)
                curveTo(17.2014f, 10.9144f, 16.7474f, 11.3689f, 16.5106f, 11.9407f)
                curveTo(16.333f, 12.3695f, 16.333f, 12.9128f, 16.333f, 14.0f)
                moveTo(8.1663f, 11.6667f)
                horizontalLineTo(12.833f)
                moveTo(8.1663f, 8.1667f)
                horizontalLineTo(12.833f)
            }
        }
        .build()
        return _building!!
    }

private var _building: ImageVector? = null
