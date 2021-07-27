package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val celsiusTem = findViewById<View>(R.id.tempCelsius) as EditText
        val fahrenheitTemp = findViewById<View>(R.id.TempFahrenheit) as EditText
        val convertBtn = findViewById<Button>(R.id.btnConvert)
        val resetBtn = findViewById<Button>(R.id.btnReset)

        // Convert Celsius to Fahrenheit
        fun celsius_fahrenheit (Temperature: Int ): Double {
           val convertedCelsiusTem = celsiusTem.text.toString().toInt()
            return (convertedCelsiusTem * 1.8) + 32
        }

        // Convert Fahrenheit to Celsius
        fun fahrenheit_celsius (Temperature: Int ): Double {
            val convertedFahrenheitTem = fahrenheitTemp.text.toString().toInt()
            return (((convertedFahrenheitTem - 32) * 5) / 9).toDouble()
        }

        convertBtn.setOnClickListener {
            // Fahrenheit to Celsius
            if(celsiusTem.text.toString().isEmpty()) {
            val tempFahrenheit = fahrenheitTemp.text.toString().toInt()
            val convertedResult = fahrenheit_celsius(tempFahrenheit)
            celsiusTem.setText(convertedResult.toString())
        } else {
            // Celsius to Fahrenheit
            val temCelsius = celsiusTem.text.toString().toInt()
            val results  = celsius_fahrenheit(temCelsius)
            fahrenheitTemp.setText(results.toString()) }
        }

        resetBtn.setOnClickListener {
            celsiusTem.getText().clear()
            fahrenheitTemp.getText().clear() }


    }
}
