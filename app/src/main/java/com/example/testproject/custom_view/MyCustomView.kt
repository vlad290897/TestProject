package com.example.testproject.custom_view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.testproject.R

class MyCustomView : View, View.OnTouchListener {

    private var figures = mutableListOf<Figure>()
    private var colors: MutableList<Int>? = ArrayList()
    private var figuresCount: Int = 0
    private val attributesArray: TypedArray
    private var figuresCountChangedListener: ((Int) -> Unit)? = null
    private var maxCountFiguresListener: (() -> Unit)? = null

    lateinit var myCustomView: MyCustomView
    private val SIRCLE = 0
    private val SQUARE = 1
    private val ROUNDED_SQUARE = 2
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                if (figuresCount != 10) {
                    val randomFigure = (0..2).random()
                    val randomRadius = (40..100).random()
                    when (randomFigure) {
                        SIRCLE -> figures.add(
                            Sircle(
                                context,
                                event.x,
                                event.y,
                                randomRadius.toFloat(),
                                colors?.random()
                            )
                        )
                        SQUARE -> figures.add(
                            Square(
                                context,
                                event.x,
                                event.y,
                                randomRadius.toFloat(),
                                colors?.random()
                            )
                        )
                        ROUNDED_SQUARE -> figures.add(
                            RoundedSquare(
                                context,
                                event.x,
                                event.y,
                                randomRadius.toFloat(),
                                colors?.random()
                            )
                        )
                    }
                    figuresCount++
                    figuresCountChangedListener?.invoke(figuresCount)
                } else {
                    maxCountFiguresListener?.invoke()
                    figuresCount = 0
                    figuresCountChangedListener?.invoke(figuresCount)
                    figures.clear()
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
        attributesArray = context.theme.obtainStyledAttributes(attrs, R.styleable.MyCustomView, 0, 0)
        prepareColors()

    }

    fun prepareColors() {
        val colorsArray = attributesArray.getResourceId(R.styleable.MyCustomView_figure_colors_array, 0)

        if (colorsArray == 0) {
            val defaultColor = ContextCompat.getColor(context, R.color.green)
            colors?.add(attributesArray.getColor(R.styleable.MyCustomView_figure_default_color, defaultColor))
        } else {
            val colorsTypedArray = context.resources.obtainTypedArray(colorsArray)
            for (i in 0 until colorsTypedArray.length()) {
                colors?.add(colorsTypedArray.getColor(i, 0))
            }
            colorsTypedArray.recycle()
        }
    }

    fun setFiguresCountChangedListener(listener: (Int) -> Unit) {
        figuresCountChangedListener = listener
    }

    fun setMaxCountFiguresListener(listener: () -> Unit) {
        maxCountFiguresListener = listener
    }

    private fun init() {
        myCustomView = findViewById(R.id.myCoustomView_ID)
        myCustomView.setOnTouchListener(this)
    }

}