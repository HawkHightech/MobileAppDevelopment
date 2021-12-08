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
        shareQuote = findViewById(R.id.shareContent)
        allHearts = findViewById(R.id.hearts)

        shareQuote.setOnClickListener{ //Help assist from https://www.youtube.com/watch?v=4kP_nqEhnPw
            val shareSpecificQuote = quotesView.text

            //Intent to share the specific quote and author
            val shareContent = Intent()
            shareContent.action = Intent.ACTION_SEND
            shareContent.type = "text/plain"
            shareContent.putExtra(Intent.EXTRA_TEXT, shareSpecificQuote)
            //shareContent.putExtra(Intent.EXTRA_TEXT, shareSpecificAuthor)
            startActivity(Intent.createChooser(shareContent, "Share quote via"))
        }

    }

    /*
    var contentForQuotes = arrayOf<String>("Love begins from within, and flows from the heart. \n \n ~ Alex Hawkins", "Breathe in for 4 seconds. Hold it. Breathe out for 3 seconds. Repeat. \n \n ~ Jhené Aiko",
        "Life goes on. Let's live on. Life goes on. Let's live on. \n \n ~ Anonymous", "Everything you need will be provided to you at the right place and the right time. \n \n ~ 444bunny", "Great things come from hard work and perserverance. \n \n ~ Kobe Bryant",
        "Appreciate where you are in life and how far you've come. Gratitude attracts more blessings. \n \n ~ Carmelo Anthony", "You are balanced. You are loved. You are winning. You are peaceful. You are alive. \n \n ~ 444bunny",
        "All our dreams can come true, if we have the courage to pursue them. \n \n ~ Walt Disney", "Your angels are protecting you on your journey. Have faith and trust in what you are doing. \n \n ~ Anonymous",
        "Focus on getting healthy, getting money and evolving your life. \n \n ~ GoldSuite", "You are worthy of what you desire. You are resilient and capable of reaching your dreams. Take everything one day at a time. \n \n ~ Anonymous",
        "The only way to do great work is to love what you do. If you haven’t found it yet, keep searching. It may find you. \n \n ~ Steve Jobs", "The journey of a million miles begins with a single step. \n \n ~ Lao Tzu",
        "Have faith in yourself and in the future. \n \n ~ Ted Kennedy", "Do what you can, with what you have, where you are. \n \n ~ Theodore Roosevelt", "You are a masterpiece. \n \n ~ Anonymous",
        "Be a positive energy trampoline – absorb what you need and rebound more back. \n \n ~ Dave Carolan", "Talent wins games, but teamwork and intelligence win championships. \n \n ~ Michael Jordan", "Love your family, work super hard, live your passion. \n \n ~ Gary Vaynerchuk",
        "Every breath we take, every step we make, can be filled with peace, joy and serenity. \n \n ~ Thich Nhat Hanh", "You should feel beautiful and you should feel safe. What you surround yourself with should bring you peace of mind and peace of spirit. \n \n ~ Stacy London",
        "Peace brings with it so many positive emotions that it is worth aiming for in all circumstances. \n \n ~ Estella Eliot", "Peace is a journey of a thousand miles and it must be taken one step at a time. \n \n ~ Lyndon B. Johnson",
        "When the power of love overcomes the love of power the world will know peace. \n \n ~ Jimi Hendrix", "Success is not final; failure is not fatal: It is the courage to continue that counts. \n \n ~ Winston S. Churchill", "The successful warrior is the average man, with laser-like focus. \n \n ~ Bruce Lee",
        "You yourself, as much as anybody in the entire universe, deserve your love and affection. \n \n ~ Buddha", "When you recover or discover something that nourishes your soul and brings joy, care enough about yourself to make room for it in your life. \n \n ~ Jean Shinoda Bolen",
        "Keep calm and carry on. \n \n ~ Winston Churchill", "Keep smiling, because life is a beautiful thing and there’s so much to smile about. \n \n ~ Marilyn Monroe", "All life is an experiment. The more experiments you make, the better. \n \n ~ Ralph Waldo Emerson",
        "The most important thing is your family and taking care of each other and loving each other no matter what. \n \n ~ Stephen Curry", "People like you are like sunshine for this world. Thank you for being the best version of yourself. \n \n ~ Michal Stawicki",
        "To be successful, focus on your strengths and develop them. That's where you should pour your time, energy, and resources. \n \n ~ John C. Maxwell", "I desire to have a life filled with positive energy and satisfaction of living authentically in my purpose. \n \n ~ Keya Briscoe",
        "There’s a direct correlation between positive energy and positive results. \n \n ~ Joe Rogan", "Passion is energy. Feel the power that comes from focusing on what excites you. \n \n ~ Oprah Winfrey", "Wealth flows from energy and ideas. \n \n ~ William Feather",
        "Positive thoughts, words, and actions create positive feelings. Positive feelings generate positive energy. \n \n ~ Nozer Kanga", "Surround yourself with positive energy. \n \n ~ Anonymous")

     */

    //var AllContentRandomized = contentForQuotes.random()
    //val AllHeartsOnOff = arrayOf<Boolean>(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false) //Val named AllHeartsOnOff set to an array full of hearts at 0 (false state).

    var AllHeartsOnOff = Array (40) { false }

    //var heartSet = false

    fun changeContentOnLeftClick(view: View)
    {
        if (arrayIndex > 0)
        {
            arrayIndex -= 1
        }

        //quotesView.text = contentForQuotes[arrayIndex]
        quotesView.text = getString(R.string.quote+arrayIndex)

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
        if (arrayIndex < (AllHeartsOnOff.count() - 1))
        {
            arrayIndex += 1
        }

        //quotesView.text = contentForQuotes[arrayIndex]
        quotesView.text = getString(R.string.quote+arrayIndex)

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