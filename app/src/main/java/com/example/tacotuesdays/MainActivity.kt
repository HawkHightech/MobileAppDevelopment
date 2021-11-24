package com.example.tacotuesdays

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity()
{

    lateinit var messageTextView : TextView
    lateinit var layoutRoot : ConstraintLayout
    lateinit var radioGroup : RadioGroup
    lateinit var checkBox1 : CheckBox
    lateinit var checkBox2 : CheckBox
    lateinit var checkBox3 : CheckBox
    lateinit var checkBox4 : CheckBox
    lateinit var spinner : Spinner
    lateinit var switch : SwitchMaterial
    lateinit var locationButton : Button
    lateinit var reviewTextView : TextView

    var fillingId = -1
    private var myTacoShop = TacoShop();
    private var selectedLocationPosition = 0
    private val REQUEST_CODE = 1


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //views
        messageTextView = findViewById(R.id.messageTextView)
        layoutRoot = findViewById(R.id.root_layout)
        radioGroup = findViewById(R.id.radioGroup)
        checkBox1 = findViewById(R.id.checkBox) //salsa
        checkBox2 = findViewById(R.id.checkBox2) //sour cream
        checkBox3 = findViewById(R.id.checkBox3) //cheese
        checkBox4 = findViewById(R.id.checkBox4) //guacamole
        spinner = findViewById(R.id.spinner)
        //switch = findViewById(R.id.glutenSwitch)
        locationButton = findViewById(R.id.locationButton)
        reviewTextView = findViewById(R.id.reviewTextView)

        //event listener
        locationButton.setOnClickListener()
        {
            selectedLocationPosition = spinner.selectedItemPosition
            myTacoShop.suggestTacoShop(selectedLocationPosition)
            Log.i("shop suggested", myTacoShop.name);
            Log.i("url suggested", myTacoShop.url);

            //create an intent
            val intent = Intent(this, TacoActivity::class.java)
            intent.putExtra("tacoShopName", myTacoShop.name)
            intent.putExtra("tacoShopURL", myTacoShop.url)

            //startActivity(intent)
            startActivityForResult(intent, REQUEST_CODE)
        }

    }

    fun createTaco(view: View)
    {
        var filling: CharSequence = ""
        var toppinglist = ""
        fillingId = radioGroup.checkedRadioButtonId

        var cost = 0.0

        if (fillingId == -1)
        {
            // snackbar
            val fillingSnackbar = Snackbar.make(layoutRoot, "Please select a filling", Snackbar.LENGTH_SHORT)
            fillingSnackbar.show()
        }

        else
        {
            filling = findViewById<RadioButton>(fillingId).text

            if (filling == "chicken")
            {
                cost += 7.75
            }

            if (filling == "steak")
            {
                cost += 9.35
            }

            if (filling == "veggies")
            {
                cost += 4.85
            }

            if (checkBox1.isChecked)
            {
                toppinglist += " " + checkBox1.text
                cost += 0.70
            }

            if (checkBox2.isChecked)
            {
                toppinglist += " " + checkBox2.text
                cost += 0.30
            }

            if (checkBox3.isChecked)
            {
                toppinglist += " " + checkBox3.text
                cost += 0.53
            }

            if (checkBox4.isChecked)
            {
                toppinglist += " " + checkBox4.text
                cost += 0.80
            }

            if (toppinglist.isNotEmpty())
            {
                toppinglist = "with" + toppinglist
            }

        }

        val location = "at " + spinner.selectedItem

        //if (switch.isChecked)
        //{
        //    filling = switch.text.toString() + "$filling "
        //}


        messageTextView.text = "You'd like $filling tacos $toppinglist $location. Your cost is $$cost."
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)

        if((requestCode == REQUEST_CODE) && (resultCode == Activity.RESULT_OK))
        {
            reviewTextView.setText(data?.let{data.getStringExtra("feedback")})
        }
    }

}