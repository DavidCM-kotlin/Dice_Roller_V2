package com.example.dicerollerv2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
//        rollButton.setOnClickListener {
////            Opción 1. Toast
////            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
////            Opcion 2. Cambiar textview.
////              val resultTextView: TextView = findViewById(R.id.textView)
////              resultTextView.text = "6"
////            Opción 3. Llamar a una funcion.
//                rollDice()
//        }
//        Condensar el código de los click listener
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }

    //asdfasdfasdfasd
    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }

}