package com.example.testproject.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.testproject.R

class RoundedSquare(context: Context, val positionX: Float, val positionY: Float, val radius: Float, val color: Int?) :
    Figure(context) {
    private val mPaint = Paint()
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.color = color!!
        canvas?.drawRoundRect(
            positionX - radius,
            positionY - radius,
            positionX + radius,
            positionY + radius,
            30.0f,
            30.0f,
            mPaint
        )
    }
}