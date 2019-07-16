package com.example.testproject.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect

class Square(context: Context, val positionX: Float, val positionY: Float, val radius: Float) : Figure(context) {
    private val mPaint = Paint()
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.setColor(Color.YELLOW);
        canvas?.drawRect(positionX - radius, positionY - radius, positionX + radius, positionY + radius, mPaint)
    }
}