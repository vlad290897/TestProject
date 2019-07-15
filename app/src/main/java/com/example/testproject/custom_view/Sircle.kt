package com.example.testproject.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View

class Sircle(context: Context, val xPosition: Float, val yPosition: Float) : Figure(context) {
    private val mPaint = Paint()
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d("MyLog", "MI TIT")
        mPaint.setColor(Color.YELLOW);
        canvas?.drawCircle(xPosition, yPosition, 50f, mPaint)
    }
}