package com.example.testproject.custom_view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.testproject.R

class MyCustomView : View, View.OnTouchListener {

    var figures = mutableListOf<Figure>()
    lateinit var myCustomView: MyCustomView
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                figures.add(Sircle(context, event.x, event.y))
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

    private fun init() {
        myCustomView = findViewById(R.id.myCoustomView_ID)
        myCustomView.setOnTouchListener(this)
    }

}