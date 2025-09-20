package com.aluastudio.test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircularCountdownView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    private var totalTime: Long = 0L
    private var remainingTime: Long = 0L

    private val circlePaint = Paint().apply {
        color = Color.LTGRAY
        style = Paint.Style.STROKE
        strokeWidth = 20f
        isAntiAlias = true
    }

    private val progressPaint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.STROKE
        strokeWidth = 20f
        isAntiAlias = true
    }

    private val textPaint = Paint().apply {
        color = Color.BLACK
        textSize = 64f
        textAlign = Paint.Align.CENTER
        isAntiAlias = true
    }

    fun setTotalTime(time: Long) {
        totalTime = time
        remainingTime = time
        invalidate()
    }

    fun start() {
        // Tu peux ajouter une animation ici si tu veux
        invalidate()
    }

    fun updateTime(time: Long) {
        remainingTime = time
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = (width.coerceAtMost(height) / 2f) - 30f

        // Cercle de fond
        canvas.drawCircle(centerX, centerY, radius, circlePaint)

        // Progression
        val sweepAngle = 360f * (remainingTime.toFloat() / totalTime)
        canvas.drawArc(
            centerX - radius, centerY - radius,
            centerX + radius, centerY + radius,
            -90f, sweepAngle, false, progressPaint
        )

        // Texte au centre
        val seconds = (remainingTime / 1000) % 60
        val minutes = (remainingTime / 1000 / 60) % 60
        val hours = (remainingTime / 1000 / 3600)

        val timeText = String.format("%02d:%02d:%02d", hours, minutes, seconds)
        canvas.drawText(timeText, centerX, centerY + 20f, textPaint)
    }
}
