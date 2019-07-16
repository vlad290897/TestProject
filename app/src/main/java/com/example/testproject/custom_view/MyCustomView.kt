package com.example.testproject.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.testproject.R

class MyCustomView : View, View.OnTouchListener {

    var figures = mutableListOf<Figure>()
    val defaultColor = prepareDefaultColor()
    var colors = mutableListOf(defaultColor)

    lateinit var myCustomView: MyCustomView
    private val SIRCLE = 0
    private val SQUARE = 1
    private val ROUNDED_SQUARE = 2
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                val randomFigure = (0..2).random()
                val randomRadius = (40..100).random()
                when (randomFigure) {
                    SIRCLE -> figures.add(Sircle(context, event.x, event.y, randomRadius.toFloat()))
                    SQUARE -> figures.add(Square(context, event.x, event.y, randomRadius.toFloat()))
                    ROUNDED_SQUARE -> figures.add(RoundedSquare(context, event.x, event.y, randomRadius.toFloat()))
                }
                invalidate()
            }
        }
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for (figure in figures) {
            figure.draw(canvas)
        }
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    fun prepareDefaultColor(): Int {

    }

    private fun init() {
        myCustomView = findViewById(R.id.myCoustomView_ID)
        myCustomView.setOnTouchListener(this)
    }

}