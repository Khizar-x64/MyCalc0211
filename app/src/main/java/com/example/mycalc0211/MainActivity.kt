package com.example.mycalc0211

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var plus: Button =findViewById(R.id.buttonplus)
        var minus:Button=findViewById(R.id.buttonminus)
        var multiply:Button=findViewById(R.id.buttonmultiply)
        var divide:Button=findViewById(R.id.buttondivide)
        var equal:Button=findViewById(R.id.button_equal)
        var dot:Button=findViewById(R.id.button_dot)
        var clear:Button=findViewById(R.id.button_clear)
        var one:Button=findViewById(R.id.button1)
        var two:Button=findViewById(R.id.button2)
        var three:Button=findViewById(R.id.button3)
        var four:Button=findViewById(R.id.button4)
        var five:Button=findViewById(R.id.button5)
        var six:Button=findViewById(R.id.button6)
        var seven:Button=findViewById(R.id.button7)
        var eight:Button=findViewById(R.id.button8)
        var nine:Button=findViewById(R.id.button9)
        var calculation:EditText=findViewById(R.id.calculation)
        plus.setOnClickListener() {

            calculation.setText(calculation.text.toString()+ "-")
        }
        multiply.setOnClickListener() {

            calculation.setText(calculation.text.toString()+ "*")
        }
        divide.setOnClickListener() {

            calculation.setText(calculation.text.toString()+ "/")
        }
        dot.setOnClickListener() {

            calculation.setText(calculation.text.toString()+ "")
        }
        one.setOnClickListener() {

            calculation.setText(calculation.text.toString()+ "1")
        }
        two.setOnClickListener() {

            calculation.setText(calculation.text.toString()+ "2")
        }
        three.setOnClickListener() {

            calculation.setText(calculation.text.toString()+ "3")
        }
        four.setOnClickListener() {

            calculation.setText(calculation.text.toString()+ "4")
        }
        five.setOnClickListener() {

            calculation.setText(calculation.text.toString()+ "5")
        }
        six.setOnClickListener() {

            calculation.setText(calculation.text.toString()+ "6")
        }
        seven.setOnClickListener() {

            calculation.setText(calculation.text.toString()+ "7")
        }
        eight.setOnClickListener() {

            calculation.setText(calculation.text.toString()+ "8")
        }
       nine.setOnClickListener() {

           calculation.setText(calculation.text.toString()+ "9")
        }
        clear.setOnClickListener() {

            if (calculation.text.toString().isNotEmpty())
            {
                calculation.setText(calculation.text.toString().substring(0, calculation.text.toString().length - 1))
            }
            else
            {
                Toast.makeText(this, "Enter input please!", Toast.LENGTH_SHORT).show()
            }
        }
        equal.setOnClickListener()
        {
            if (calculation.text.toString().length == 0)
            {
                Toast.makeText(this@MainActivity, "Need Digits!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                var DigitList = calculation.text.toString().split("+", "*", "-", "/")
                val OperatorList: MutableList<Char> = mutableListOf()

                for (i in calculation.text.toString())
                {
                    if (i == '+' || i == '-' || i == '*' || i == '/')
                    {
                        OperatorList.add(i)
                    }
                }

                var result: Float = 0.0F
                var index: Int = 0;
                for (i in 0..OperatorList.size - 1) {
                    if (OperatorList[i] == '+') {
                        if (i == 0) {
                            result = DigitList[index].toFloat() + DigitList[index+1].toFloat()
                        } else {
                            result = result + DigitList[index+1].toFloat()
                        }

                    } else if (OperatorList[i] == '-') {
                        if (i == 0) {
                            result = DigitList[index].toFloat() - DigitList[index+1].toFloat()
                        } else {
                            result = result - DigitList[index+1].toFloat()
                        }

                    } else if (OperatorList[i] == '*') {
                        if (i == 0) {
                            result = DigitList[index].toFloat() * DigitList[index+1].toFloat()
                        } else {
                            result = result * DigitList[index+1].toFloat()
                        }

                    } else  {
                        if (i == 0) {
                            result = DigitList[index].toFloat() / DigitList[index+1].toFloat()
                        } else {
                            result = result / DigitList[index+1].toFloat()
                        }

                    }
                }

                calculation.setText(result.toString())
            }
        }
    }

}