package com.example.truthormyth

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val results = intent.getBooleanArrayExtra("Results")


        val tvReview = findViewById<TextView>(R.id.tvReview)

         val questions = arrayOf(
            "A picture shows a catastrophic event that looks \"too perfect\" or \"too dramatic.\" It was shared 24 hours ago. Could this be AI-generated?" ,
            "You see a headline on social media that perfectly aligns with your political views. Because you agree with it, it is likely true." ,
            " If a story is breaking, it is better to wait for mainstream media outlets to verify the information than to trust the first social media post." ,
            "You must raise your bed on bricks to prevent the Tokoloshe from attacking you." ,
            "Whistling at night attracts evil spirits or snake." ,
            "People with Albinism have magical powers that can be used for healing." ,
            "Shaving causes hair to grow back thicker and darker" ,
            "Sharks have been on Earth longer than trees have." ,
            "Dolphins give each other unique names through whistles."
        )
        val answers = arrayOf(true, false, true, false, false, false, false, true, true )

        val explanations = arrayOf(
            "In 2026, an estimated 70% of social media images involve AI tools making it crucial to verify the source of highly dramatic visuals." ,
            "This is called confirmation bias. Misinformation is designed to trigger strong emotional reactions, specifically targeting what we already believe to make us share it without questioning." ,
            "Giving news stories time to develop allows initial panic and false information to be debunked, preventing the spread of hoaxes." ,
            "This is a belief found in Zulu mythology used to explain placing bricks under bed legs. However, this is largely attributed to providing storage space in small dwellings rather than actual supernatural protection." ,
            "This is a prevalent superstition designed to keep children quiet after dark, rather than a factual event" ,
            "This is a dangerous superstition. Albinism is a genetic condition caused by lack of melanin." ,
            "Shaving cuts hair at the surface, giving it a blunt edge that feels coarser. It does not alter the hair follicle or increase the density of hair growth." ,
            "Sharks have existed for about 400 million years, while the earliest trees appeared roughly 350 million years ago." ,
            "Research shows bottlenose dolphins develop \"signature whistles\" that act as names to distinguish and call out to specific members of their pod."
        )

        var review = "Have a look at all the answers\n\n"
        var counter = 0
        val TotalScore = results?.size?: 0

        while (counter < (results?.size ?: 0)) {
            val AnswerIsCorrect =results!![counter]
            val CorrectChoice =if (answers[counter]) "Truth" else "Myth"
            val status = if (AnswerIsCorrect) "Correct" else "Incorrect"

            review += "Question ${counter +1 }:\n" +
                    "${questions[counter]}\n\n" +
                    "Your Result: $status\n" +
                    "Correct Answer: $CorrectChoice\n" +
                    "The Fact:\n${explanations[counter]}\n" +
                    "                               \n\n"

            counter++
        }

        tvReview.text = review


    }
}