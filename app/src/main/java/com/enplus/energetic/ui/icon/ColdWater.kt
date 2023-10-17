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

val EnIcons.ColdWater: ImageVector
    get() {
        if (_coldWater != null) {
            return _coldWater!!
        }
        _coldWater = Builder(name = "ColdWater", defaultWidth = 20.0.dp, defaultHeight =
                20.0.dp, viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFFFF8C00)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(9.5234f, 2.2617f)
                curveTo(9.5234f, 3.6094f, 9.4844f, 3.6523f, 8.8086f, 3.0547f)
                curveTo(7.3828f, 1.7461f, 6.9844f, 2.3828f, 8.3711f, 3.8086f)
                lineTo(9.7227f, 5.1992f)
                lineTo(8.6094f, 6.1914f)
                curveTo(6.9063f, 7.6602f, 5.793f, 7.4609f, 5.1992f, 5.5547f)
                curveTo(4.6445f, 3.6914f, 3.8906f, 3.4141f, 4.2461f, 5.1992f)
                lineTo(4.4844f, 6.4297f)
                lineTo(3.2539f, 5.793f)
                curveTo(1.8633f, 5.0781f, 1.5859f, 5.0391f, 1.5859f, 5.4766f)
                curveTo(1.5859f, 5.6367f, 2.1836f, 6.1094f, 2.8555f, 6.5469f)
                lineTo(4.168f, 7.3008f)
                lineTo(2.8555f, 7.6172f)
                curveTo(2.1445f, 7.8164f, 1.668f, 8.1367f, 1.7852f, 8.332f)
                curveTo(1.9063f, 8.5313f, 2.6172f, 8.4922f, 3.4141f, 8.2539f)
                curveTo(5.4375f, 7.6992f, 5.9531f, 8.0156f, 5.9531f, 9.9219f)
                curveTo(5.9531f, 11.8242f, 5.4375f, 12.1445f, 3.3711f, 11.5469f)
                curveTo(2.3008f, 11.2695f, 1.9844f, 11.2695f, 2.1016f, 11.6289f)
                curveTo(2.1836f, 11.8633f, 2.6602f, 12.1836f, 3.2148f, 12.3008f)
                curveTo(4.168f, 12.5391f, 4.168f, 12.5391f, 2.8984f, 13.293f)
                curveTo(2.1836f, 13.7305f, 1.5859f, 14.207f, 1.5859f, 14.3633f)
                curveTo(1.5859f, 14.8008f, 1.8633f, 14.7617f, 3.2539f, 14.0469f)
                lineTo(4.4844f, 13.4141f)
                lineTo(4.2852f, 14.4453f)
                curveTo(3.9688f, 16.1523f, 4.6836f, 16.0313f, 5.1992f, 14.2852f)
                curveTo(5.793f, 12.3828f, 6.8633f, 12.1836f, 8.6094f, 13.6523f)
                lineTo(9.7227f, 14.6445f)
                lineTo(8.3711f, 16.0313f)
                curveTo(6.9844f, 17.4609f, 7.3828f, 18.0938f, 8.8086f, 16.7852f)
                curveTo(9.4844f, 16.1914f, 9.5234f, 16.2305f, 9.5234f, 17.5781f)
                curveTo(9.5234f, 18.4141f, 9.7227f, 19.0469f, 9.9219f, 19.0469f)
                curveTo(10.1602f, 19.0469f, 10.3164f, 18.4141f, 10.3164f, 17.5781f)
                curveTo(10.3164f, 16.2305f, 10.3555f, 16.1914f, 11.0313f, 16.7852f)
                curveTo(12.4609f, 18.0938f, 12.8555f, 17.4609f, 11.4688f, 16.0313f)
                lineTo(10.1172f, 14.6445f)
                lineTo(11.2305f, 13.6523f)
                curveTo(12.9766f, 12.1836f, 14.0469f, 12.3828f, 14.6445f, 14.2852f)
                curveTo(15.1602f, 16.0313f, 15.8711f, 16.1523f, 15.5547f, 14.4453f)
                lineTo(15.3555f, 13.4141f)
                lineTo(16.5859f, 14.0469f)
                curveTo(17.9766f, 14.7617f, 18.2539f, 14.8008f, 18.2539f, 14.3633f)
                curveTo(18.2539f, 14.207f, 17.6602f, 13.7305f, 16.9844f, 13.293f)
                curveTo(15.6758f, 12.5391f, 15.6758f, 12.5391f, 16.6289f, 12.3008f)
                curveTo(17.1836f, 12.1836f, 17.6602f, 11.8633f, 17.7383f, 11.6289f)
                curveTo(17.8555f, 11.2695f, 17.5391f, 11.2695f, 16.4688f, 11.5469f)
                curveTo(14.4063f, 12.1445f, 13.8906f, 11.8242f, 13.8906f, 9.9219f)
                curveTo(13.8906f, 8.0156f, 14.4063f, 7.6992f, 16.4297f, 8.2539f)
                curveTo(17.2227f, 8.4922f, 17.9375f, 8.5313f, 18.0547f, 8.332f)
                curveTo(18.1758f, 8.1367f, 17.6992f, 7.8164f, 16.9844f, 7.6172f)
                lineTo(15.6758f, 7.3008f)
                lineTo(16.9844f, 6.5469f)
                curveTo(17.6602f, 6.1094f, 18.2539f, 5.6367f, 18.2539f, 5.4766f)
                curveTo(18.2539f, 5.0391f, 17.9766f, 5.0781f, 16.5859f, 5.793f)
                lineTo(15.3555f, 6.4297f)
                lineTo(15.5938f, 5.1992f)
                curveTo(15.9531f, 3.4141f, 15.1992f, 3.6914f, 14.6445f, 5.5547f)
                curveTo(14.0469f, 7.4609f, 12.9375f, 7.6602f, 11.2305f, 6.1914f)
                lineTo(10.1172f, 5.1992f)
                lineTo(11.4688f, 3.8086f)
                curveTo(12.8555f, 2.3828f, 12.4609f, 1.7461f, 11.0313f, 3.0547f)
                curveTo(10.3555f, 3.6523f, 10.3164f, 3.6094f, 10.3164f, 2.2617f)
                curveTo(10.3164f, 1.4297f, 10.1602f, 0.793f, 9.9219f, 0.793f)
                curveTo(9.7227f, 0.793f, 9.5234f, 1.4297f, 9.5234f, 2.2617f)
                close()
                moveTo(9.5234f, 7.9375f)
                curveTo(9.5234f, 9.0469f, 9.4844f, 9.0859f, 8.5313f, 8.6523f)
                curveTo(7.1016f, 8.0156f, 7.1445f, 7.8984f, 9.4453f, 6.7852f)
                curveTo(9.4844f, 6.7852f, 9.5234f, 7.2617f, 9.5234f, 7.9375f)
                close()
                moveTo(12.2617f, 7.8555f)
                curveTo(12.5f, 7.9766f, 11.0313f, 9.0859f, 10.6367f, 9.1289f)
                curveTo(10.4375f, 9.1289f, 10.3164f, 8.5703f, 10.3164f, 7.9375f)
                curveTo(10.3164f, 6.707f, 10.3984f, 6.707f, 12.2617f, 7.8555f)
                close()
                moveTo(8.7305f, 9.9219f)
                curveTo(8.7305f, 10.0781f, 8.293f, 10.3984f, 7.7383f, 10.6367f)
                curveTo(6.7852f, 11.0703f, 6.7461f, 11.0313f, 6.7461f, 9.9219f)
                curveTo(6.7461f, 8.8086f, 6.7852f, 8.7695f, 7.7383f, 9.207f)
                curveTo(8.293f, 9.4453f, 8.7305f, 9.7617f, 8.7305f, 9.9219f)
                close()
                moveTo(13.0938f, 9.9219f)
                curveTo(13.0938f, 11.0313f, 13.0547f, 11.0703f, 12.1016f, 10.6367f)
                curveTo(11.5469f, 10.3984f, 11.1094f, 10.0781f, 11.1094f, 9.9219f)
                curveTo(11.1094f, 9.7227f, 12.3828f, 8.9297f, 13.0156f, 8.7695f)
                curveTo(13.0547f, 8.7305f, 13.0938f, 9.2461f, 13.0938f, 9.9219f)
                close()
                moveTo(9.5234f, 11.8633f)
                curveTo(9.5234f, 12.9375f, 9.4844f, 12.9766f, 8.5313f, 12.5781f)
                curveTo(7.9766f, 12.3008f, 7.5391f, 11.9844f, 7.5391f, 11.8633f)
                curveTo(7.5391f, 11.668f, 8.8477f, 10.9141f, 9.4453f, 10.7539f)
                curveTo(9.4844f, 10.7148f, 9.5234f, 11.2305f, 9.5234f, 11.8633f)
                close()
                moveTo(11.668f, 11.3086f)
                curveTo(12.1016f, 11.6289f, 12.3828f, 11.9453f, 12.2617f, 11.9844f)
                curveTo(10.3984f, 13.1367f, 10.3164f, 13.1367f, 10.3164f, 11.9063f)
                curveTo(10.3164f, 10.5938f, 10.5547f, 10.4766f, 11.668f, 11.3086f)
                close()
                moveTo(11.668f, 11.3086f)
            }
        }
        .build()
        return _coldWater!!
    }

private var _coldWater: ImageVector? = null
