package com.atlas.mobile.agent.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.atlas.mobile.agent.ui.theme.OxCharcoal
import com.atlas.mobile.agent.ui.theme.OxTerracotta

@Composable
fun AgentOxLogo(size: Dp = 32.dp, primaryColor: Color = OxTerracotta, secondaryColor: Color = OxCharcoal) {
    Canvas(modifier = Modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height

        val hornPath = Path().apply {
            moveTo(w * 0.15f, h * 0.22f)
            cubicTo(w * 0.22f, h * 0.05f, w * 0.40f, h * 0.08f, w * 0.50f, h * 0.25f)
            cubicTo(w * 0.60f, h * 0.08f, w * 0.78f, h * 0.05f, w * 0.85f, h * 0.22f)
            lineTo(w * 0.72f, h * 0.32f)
            lineTo(w * 0.50f, h * 0.38f)
            lineTo(w * 0.28f, h * 0.32f)
            close()
        }
        drawPath(hornPath, primaryColor, style = Fill)

        val facePath = Path().apply {
            moveTo(w * 0.30f, h * 0.35f)
            lineTo(w * 0.70f, h * 0.35f)
            lineTo(w * 0.64f, h * 0.75f)
            lineTo(w * 0.50f, h * 0.90f)
            lineTo(w * 0.36f, h * 0.75f)
            close()
        }
        drawPath(facePath, secondaryColor, style = Fill)

        val diamondPath = Path().apply {
            moveTo(w * 0.50f, h * 0.42f)
            lineTo(w * 0.57f, h * 0.52f)
            lineTo(w * 0.50f, h * 0.62f)
            lineTo(w * 0.43f, h * 0.52f)
            close()
        }
        drawPath(diamondPath, primaryColor, style = Fill)
    }
}
