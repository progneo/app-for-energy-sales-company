package com.enplus.energetic.ui.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Icons.Backspace: ImageVector
    get() {
        if (_backspace != null) {
            return _backspace!!
        }
        _backspace = Builder(name = "Backspace", defaultWidth = 32.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, fillAlpha = 0.5f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(21.8854f, 16.0001f)
                lineTo(23.7707f, 14.1147f)
                curveTo(24.0136f, 13.8633f, 24.148f, 13.5265f, 24.1449f, 13.1769f)
                curveTo(24.1419f, 12.8273f, 24.0017f, 12.4929f, 23.7545f, 12.2457f)
                curveTo(23.5073f, 11.9984f, 23.1728f, 11.8582f, 22.8232f, 11.8552f)
                curveTo(22.4736f, 11.8521f, 22.1368f, 11.9865f, 21.8854f, 12.2294f)
                lineTo(20.0f, 14.1147f)
                lineTo(18.1147f, 12.2294f)
                curveTo(17.9917f, 12.1021f, 17.8446f, 12.0005f, 17.6819f, 11.9306f)
                curveTo(17.5192f, 11.8607f, 17.3443f, 11.824f, 17.1672f, 11.8224f)
                curveTo(16.9902f, 11.8209f, 16.8146f, 11.8546f, 16.6508f, 11.9217f)
                curveTo(16.4869f, 11.9887f, 16.338f, 12.0877f, 16.2128f, 12.2129f)
                curveTo(16.0877f, 12.3381f, 15.9887f, 12.4869f, 15.9216f, 12.6508f)
                curveTo(15.8546f, 12.8147f, 15.8208f, 12.9902f, 15.8224f, 13.1673f)
                curveTo(15.8239f, 13.3443f, 15.8607f, 13.5193f, 15.9306f, 13.682f)
                curveTo(16.0005f, 13.8446f, 16.102f, 13.9918f, 16.2294f, 14.1147f)
                lineTo(18.1147f, 16.0001f)
                lineTo(16.2294f, 17.8854f)
                curveTo(16.102f, 18.0084f, 16.0005f, 18.1555f, 15.9306f, 18.3182f)
                curveTo(15.8607f, 18.4809f, 15.8239f, 18.6558f, 15.8224f, 18.8329f)
                curveTo(15.8208f, 19.0099f, 15.8546f, 19.1855f, 15.9216f, 19.3494f)
                curveTo(15.9887f, 19.5132f, 16.0877f, 19.6621f, 16.2128f, 19.7873f)
                curveTo(16.338f, 19.9125f, 16.4869f, 20.0115f, 16.6508f, 20.0785f)
                curveTo(16.8146f, 20.1456f, 16.9902f, 20.1793f, 17.1672f, 20.1777f)
                curveTo(17.3443f, 20.1762f, 17.5192f, 20.1394f, 17.6819f, 20.0695f)
                curveTo(17.8446f, 19.9997f, 17.9917f, 19.8981f, 18.1147f, 19.7707f)
                lineTo(20.0f, 17.8854f)
                lineTo(21.8854f, 19.7707f)
                curveTo(22.0084f, 19.8981f, 22.1555f, 19.9997f, 22.3182f, 20.0695f)
                curveTo(22.4808f, 20.1394f, 22.6558f, 20.1762f, 22.8328f, 20.1777f)
                curveTo(23.0099f, 20.1793f, 23.1855f, 20.1456f, 23.3493f, 20.0785f)
                curveTo(23.5132f, 20.0115f, 23.662f, 19.9125f, 23.7872f, 19.7873f)
                curveTo(23.9124f, 19.6621f, 24.0114f, 19.5132f, 24.0785f, 19.3494f)
                curveTo(24.1455f, 19.1855f, 24.1792f, 19.0099f, 24.1777f, 18.8329f)
                curveTo(24.1762f, 18.6558f, 24.1394f, 18.4809f, 24.0695f, 18.3182f)
                curveTo(23.9996f, 18.1555f, 23.8981f, 18.0084f, 23.7707f, 17.8854f)
                lineTo(21.8854f, 16.0001f)
                close()
                moveTo(13.104f, 6.6667f)
                horizontalLineTo(26.6667f)
                curveTo(27.374f, 6.6667f, 28.0522f, 6.9477f, 28.5523f, 7.4478f)
                curveTo(29.0524f, 7.9479f, 29.3334f, 8.6262f, 29.3334f, 9.3334f)
                verticalLineTo(22.6667f)
                curveTo(29.3334f, 23.374f, 29.0524f, 24.0523f, 28.5523f, 24.5524f)
                curveTo(28.0522f, 25.0525f, 27.374f, 25.3334f, 26.6667f, 25.3334f)
                horizontalLineTo(13.104f)
                curveTo(12.3969f, 25.3333f, 11.7187f, 25.0522f, 11.2187f, 24.5521f)
                lineTo(3.6094f, 16.9427f)
                curveTo(3.3594f, 16.6927f, 3.219f, 16.3536f, 3.219f, 16.0001f)
                curveTo(3.219f, 15.6465f, 3.3594f, 15.3075f, 3.6094f, 15.0574f)
                lineTo(11.2187f, 7.4481f)
                curveTo(11.7187f, 6.9479f, 12.3969f, 6.6669f, 13.104f, 6.6667f)
                close()
            }
        }
        .build()
        return _backspace!!
    }

private var _backspace: ImageVector? = null
