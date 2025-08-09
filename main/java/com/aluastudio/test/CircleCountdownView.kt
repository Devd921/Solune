package com.example.minuteur

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CircleCountdownView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint().apply {
        color = Color.WHITE
        strokeWidth = 12f
        style = Paint.Style.STROKE
        isAntiAlias = true
    }

    private var progress = 1f // 1.0 = plein cercle, 0.0 = vide

    fun setProgress(p: Float) {
        progress = p
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        val padding = 20f
        val rect = RectF(padding, padding, width - padding, height - padding)
        val sweepAngle = 360f * progress
        canvas.drawArc(rect, 270f, -sweepAngle, false, paint)
    }
}
