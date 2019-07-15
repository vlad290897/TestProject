package com.example.testproject.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect

class Square(context: Context,val positionX:Float,val positionY:Float) : Figure(context) {

    lateinit var rect: Rect
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
     
    }
}