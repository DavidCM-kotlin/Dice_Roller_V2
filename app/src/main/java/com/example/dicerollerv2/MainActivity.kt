package com.example.dicerollerv2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
//      TEXTO Primera parte
//      Update the screen with the dice roll
//      val resultTextView: TextView = findViewById(R.id.textView)
//      resultTextView.text = diceRoll.toString()
//      IMAGEN Segunda parte
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }

    //asdfasdfasdfasd
    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }

}