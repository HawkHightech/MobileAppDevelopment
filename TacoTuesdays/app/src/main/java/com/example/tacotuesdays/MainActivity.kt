package com.example.tacotuesdays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createTaco(view: android.view.View)
    {
        var filling: CharSequence = ""
        val layoutRoot = findViewById<ConstraintLayout>(R.id.root_layout)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val fillingId = radioGroup.checkedRadioButtonId

        val salsa = findViewById<CheckBox>(R.id.checkBox)
        val sourCream = findViewById<CheckBox>(R.id.checkBox2)
        val cheese = findViewById<CheckBox>(R.id.checkBox3)
        val guacamole = findViewById<CheckBox>(R.id.checkBox4)

        val spinner = findViewById<Spinner>(R.id.spinner)

        val switch = findViewById<Switch>(R.id.glutenSwitch)

        var cost = 0.0

        var toppinglist = ""

        if (fillingId == -1)
        {
            // snackbar
            val fillingSnackBar = Snackbar.make(layoutRoot, "Please select a filling", Snackbar.LENGTH_SHORT)
            fillingSnackBar.show()
        }

        else
        {
            filling = findViewById<RadioButton>(fillingId).text
            val messageTextView = findViewById<TextView>(R.id.messageTextView)

            if (filling == "chicken")
            {
                cost = cost + 7.75
            }

            if (filling == "steak")
            {
                cost = cost + 9.35
            }

            if (filling == "veggies")
            {
                cost = cost + 4.85
            }

            if (salsa.isChecked)
            {
                toppinglist += " " + salsa.text
                cost = cost + 0.70
            }

            if (sourCream.isChecked)
            {
                toppinglist += " " + sourCream.text
                cost = cost + 0.30
            }

            if (cheese.isChecked)
            {
                toppinglist += " " + cheese.text
                cost = cost + 0.53
            }

            if (guacamole.isChecked)
            {
                toppinglist += " " + guacamole.text
                cost = cost + 0.80
            }

            if (toppinglist.isNotEmpty())
            {
                toppinglist = "with" + toppinglist
            }

        }

        //var filling = findViewById<RadioButton>(fillingId).text
        val messageTextView = findViewById<TextView>(R.id.messageTextView)

        val location = "at " + spinner.selectedItem

        if (switch.isChecked)
        {
            filling = switch.text.toString() + "$filling "
        }


        messageTextView.text = "You'd like $filling tacos $toppinglist $location. Your cost is $$cost."
    }
}