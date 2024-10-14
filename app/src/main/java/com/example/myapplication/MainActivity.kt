package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var button: Button
    private lateinit var textView3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        button = findViewById(R.id.button)
        textView3 = findViewById(R.id.textView3)


        button.setOnClickListener {
            calculate()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calculate() {
        val num1String = editText1.text.toString()
        val num2String = editText2.text.toString()

        Log.d("MainActivity", "Number 1: $num1String")
        Log.d("MainActivity", "Number 2: $num2String")

        if (num1String.isNotEmpty() && num2String.isNotEmpty()) {
            val num1 = num1String.toDoubleOrNull()
            val num2 = num2String.toDoubleOrNull()
            val federalTax: Double = 0.0808
            val socialMedTax: Double = 0.0765


            if (num1 != null && num2 != null) {
                val result = num1 * num2

                val fedtaxresult = result * federalTax
                val roundfed: Long = round(fedtaxresult).toLong()

                val smtaxresult = result * socialMedTax
                val roundsmtax: Long = round(smtaxresult).toLong()

                val finalresult: Double = result - roundfed - roundsmtax
                textView3.text = finalresult.toString()
            } else {
                textView3.text = "Invalid input"
            }
        } else {
            textView3.text = "Please enter both numbers."
        }
    }
}