package com.example.simplecounter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*

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


        val btn : Button = findViewById<Button>(R.id.button)
        val plusOne : Button = findViewById<Button>(R.id.plusone)
        val timesTwo = findViewById<Button>(R.id.timestwo)
        val countable : TextView = findViewById<TextView>(R.id.countable)
        var num = 0
        var increment = 1

        val plusCost = findViewById<TextView>(R.id.plusCost)
        val timesCost = findViewById<TextView>(R.id.timesCost)

        var plusVal : Int = 100
        var timesVal : Int = 250
        var placeholder = ""

        fun bigEnough(taps : Int,cost : Int) : Boolean {

            return taps>=cost

        }

        fun setNum(num : Int) {
            countable.text = num.toString()
        }



        btn.setOnClickListener{
            num += increment
            setNum(num)

        }

        plusOne.setOnClickListener { // add if conditional later

            if (bigEnough(num,plusVal)){
                increment +=1
                num -= plusVal
                setNum(num)
                plusVal += 100
                placeholder = "Cost: $plusVal"
                plusCost.text = placeholder


            }




        }

        timesTwo.setOnClickListener {

            if(bigEnough(num,timesVal)) {

                increment *= 2
                num -= timesVal
                setNum(num)
                timesVal *= 3
                placeholder = "Cost: $timesVal"
                timesCost.text = placeholder
            }
        }



    }
}