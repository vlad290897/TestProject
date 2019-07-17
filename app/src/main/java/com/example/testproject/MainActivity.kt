package com.example.testproject

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var app: Application

    @Inject
    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        myCoustomView_ID.setFiguresCountChangedListener {
            figuresCountTv.text = it.toString()
        }
        myCoustomView_ID.setMaxCountFiguresListener {
            figuresCountTv.text = ""
            Toast.makeText(this, "Game over", Toast.LENGTH_LONG).show()
        }
    }
}