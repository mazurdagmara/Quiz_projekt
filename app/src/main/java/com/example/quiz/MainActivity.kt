package com.example.quiz

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kat1 = findViewById<Button>(R.id.buttonKat1)
        val quest = findViewById<TextView>(R.id.textViewOpis)

        kat1.setOnClickListener {
            quest.text=""
        }
    }
}