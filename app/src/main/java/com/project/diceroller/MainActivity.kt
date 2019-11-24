package com.project.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.project.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var firstDiceImage: ImageView
    lateinit var secondDiceImage: ImageView
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //load animation
        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce_anim)


        //context shows the current state of the app
        binding.rollDice.setOnClickListener {
            binding.firstDice.startAnimation(bounceAnimation)
            binding.secondDice.startAnimation(bounceAnimation)
            rollDice1()
        }
    }

    private fun rollDice1() {
        val randomValues = Random.nextInt(6) + 1
        val randomValues1 = Random.nextInt(6) + 1
        binding.apply {
            firstDice.setImageResource(
                when (randomValues) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    6 -> R.drawable.dice_6
                    else -> R.drawable.empty_dice
                }
            )

            secondDice.setImageResource(
                when (randomValues1) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    6 -> R.drawable.dice_6
                    else -> R.drawable.empty_dice
                }
            )

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.instructions, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, Instruction::class.java)
        when (item.itemId) {
            R.id.instruction_menu -> startActivity(intent)
        }
        return true
    }
}
