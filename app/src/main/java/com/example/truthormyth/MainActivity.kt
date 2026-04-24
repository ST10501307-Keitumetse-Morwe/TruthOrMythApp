package com.example.truthormyth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //button declarations
        val tvAppName = findViewById<TextView>(R.id.tvAppName)
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val tvWelcome2 = findViewById<TextView>(R.id.tvWelcome2)
        val tvWelcome3 = findViewById<TextView>(R.id.tvWelcome3)
        val tvWelcome4 = findViewById<TextView>(R.id.tvWelcome4)
        val btnStart = findViewById<Button>(R.id.btnStart)


        btnStart.setOnClickListener {

            val screen = Intent(this, QuizScreen::class.java)
            startActivity( screen)

        }


    }
}