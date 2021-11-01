package com.example.halloween

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sayBoo(view: View)
    {
        val booText = findViewById<TextView>(R.id.textMessage)
        val editName = findViewById<EditText>(R.id.editTextName)
        val name = editName.text
        booText.text = "Happy Halloween " + name + "! ^_^"

        val imageGhost = findViewById<ImageView>(R.id.imageView)
        imageGhost.setImageResource(R.drawable.boo)

    }
}