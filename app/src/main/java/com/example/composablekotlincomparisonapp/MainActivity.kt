package com.example.composablekotlincomparisonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var textViewCounter: TextView
    lateinit var buttonIncrement: Button
    lateinit var buttonDecrement: Button

    var initialCounterValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialise the Views
        textViewCounter = findViewById(R.id.textViewCounter)
        buttonIncrement = findViewById(R.id.buttonIncrement)
        buttonDecrement = findViewById(R.id.buttonDecrement)

        //Initialise the counter value
        textViewCounter.text = initialCounterValue.toString()

        //Set the click listeners
        //Increment the counter value
        buttonIncrement.setOnClickListener {
            initialCounterValue++
            textViewCounter.text = initialCounterValue.toString()
        }

        //Set the click listeners
        //Decrement the counter value
        buttonDecrement.setOnClickListener {
            if(initialCounterValue==0){
                Toast.makeText(this,"Counter value cannot be decreased",Toast.LENGTH_SHORT).show()
            }else{
                initialCounterValue--
                textViewCounter.text = initialCounterValue.toString()
            }
        }
    }
}