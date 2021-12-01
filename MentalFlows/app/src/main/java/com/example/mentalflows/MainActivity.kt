package com.example.mentalflows

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity()
{
    private lateinit var leftButtonPressed : TextView
    private lateinit var rightButtonPressed : TextView
    private lateinit var quotesView : TextView
    private lateinit var authorsView : TextView
    private lateinit var allHearts : ImageView
    private var arrayIndex = 0
    private lateinit var shareQuote : Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        leftButtonPressed = findViewById(R.id.leftBtn)
        rightButtonPressed = findViewById(R.id.rightBtn)
        quotesView = findViewById(R.id.quotes)
        authorsView = findViewById(R.id.authors)
        shareQuote = findViewById(R.id.shareContents)
        allHearts = findViewById(R.id.hearts)

        shareQuote.setOnClickListener{ //Help assist from https://www.youtube.com/watch?v=4kP_nqEhnPw
            val shareSpecificQuote = quotesView.text
            val shareSpecificAuthor = authorsView.text

            //Intent to share the specific quote and author
            val shareContent = Intent()
            shareContent.action = Intent.ACTION_SEND
            shareContent.type = "text/plain"
            shareContent.putExtra(Intent.EXTRA_TEXT, shareSpecificQuote)
            //shareContent.putExtra(Intent.EXTRA_TEXT, shareSpecificAuthor)
            startActivity(Intent.createChooser(shareContent, "Share quote via"))
        }

    }

    // Total number of array elements: 20
    var contentForQuotes = arrayOf<String>("Love begins from within, and flows from the heart.", "Breathe in for 4 seconds. Hold it. Breathe out for 3 seconds. Repeat.",
        "Life goes on. Let's live on. Life goes on. Let's live on.", "Everything you need will be provided to you at the right place and the right time.", "Great things come from hard work and perserverance.",
        "Appreciate where you are in life and how far you've come. Gratitude attracts more blessings.", "You are balanced. You are loved. You are winning. You are peaceful. You are alive.",
        "All our dreams can come true, if we have the courage to pursue them.", "Your angels are protecting you on your journey. Have faith and trust in what you are doing.",
        "Focus on getting healthy, getting money and evolving your life.", "You are worthy of what you desire. You are resilient and capable of reaching your dreams. Take everything one day at a time.",
        "The only way to do great work is to love what you do. If you haven’t found it yet, keep searching. It may find you.", "The journey of a million miles begins with a single step.",
        "Have faith in yourself and in the future.", "Do what you can, with what you have, where you are.", "You are a masterpiece.", "Success is peace of mind, which is a direct result of self-satisfaction in knowing you made the effort to become the best of which you are capable.",
        "Be a positive energy trampoline – absorb what you need and rebound more back.", "Talent wins games, but teamwork and intelligence win championships.", "Love your family, work super hard, live your passion.")
    var contentForAuthors = arrayOf<String>("~ Alex Hawkins", "~ Jhené Aiko", "~ Anonymous", "~ 444bunny", "~ Kobe Bryant", "~ Carmelo Anthony", "~ 444bunny", "~ Walt Disney", "~ Anonymous", "~ GoldSuite", "~ Anonymous", "~ Steve Jobs", "~ Lao Tzu", "~ Ted Kennedy", "~ Theodore Roosevelt",
        "~ Anonymous", "~ John Wooden", "~ Dave Carolan", "~ Michael Jordan", "~ Gary Vaynerchuk")
    val AllHeartsOnOff = arrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false) //Val named AllHeartsOnOff set to an array full of hearts at 0 (false state).
    //var heartSet = false

    fun changeContentOnLeftClick(view: View)
    {
        if (arrayIndex > 0)
        {
            arrayIndex -= 1
        }

        quotesView.text = contentForQuotes[arrayIndex]
        authorsView.text = contentForAuthors[arrayIndex]

        if (AllHeartsOnOff[arrayIndex] == true)
        {
            allHearts.setImageResource(R.drawable.heart100);
        }

        else if (AllHeartsOnOff[arrayIndex] == false)
        {
            allHearts.setImageResource(R.drawable.heart0);
        }
    }

    fun changeContentOnRightClick(view: View)
    {
        if (arrayIndex < (contentForQuotes.count() - 1))
        {
            arrayIndex += 1
        }

        quotesView.text = contentForQuotes[arrayIndex]
        authorsView.text = contentForAuthors[arrayIndex]

        if (AllHeartsOnOff[arrayIndex] == true)
        {
            allHearts.setImageResource(R.drawable.heart100);
        }

        else if (AllHeartsOnOff[arrayIndex] == false)
        {
            allHearts.setImageResource(R.drawable.heart0);
        }
    }

    fun changeHeart(view: View)
    {
        //  allHearts.setImageResource(R.drawable.heart100);
        //  allHearts.setImageResource(R.drawable.heart0);

        if (allHearts.isPressed() && (AllHeartsOnOff[arrayIndex] == false))
        {
            AllHeartsOnOff[arrayIndex] = true
            allHearts.setImageResource(R.drawable.heart100);
        }

        else if (allHearts.isPressed() && (AllHeartsOnOff[arrayIndex] == true))
        {
            AllHeartsOnOff[arrayIndex] = false
            allHearts.setImageResource(R.drawable.heart0);
        }

    }

}
