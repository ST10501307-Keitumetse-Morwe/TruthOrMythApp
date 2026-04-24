package com.example.truthormyth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val score = intent.getIntExtra("Score", 0)
        val results = intent.getBooleanArrayExtra("Results")



        val tvScore = findViewById<TextView>(R.id.tvScore)
        val tvPersonalFeedBack = findViewById<TextView>(R.id.tvPersonalFeedBack)
        val btnReview = findViewById<Button>(R.id.btnReview)

        btnReview.setOnClickListener {
            val intent = Intent(this, ReviewScreen::class.java)
            intent.putExtra("Results", results)
            startActivity(intent)

        }

        tvScore.text = "And the final score is $score / 9"
        tvPersonalFeedBack.text = when (score){
            9 -> "Perfection! You got every single one right."
            8 -> " Amazing! Just one tiny mistake"
            7,6 -> " Well done! You clearly know your stuff"
            5,4 -> "Good effort! A bit more study and you'll have it."
            3,2 -> "Keep trying! Every mistake is a lesson"
            1 -> "Don't give up! Try again to improve your score."
        else-> "Better luck next time"

        }



    }
}