package com.example.xandogameee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startGame = findViewById<Button>(R.id.startGame)
        val playerOne = findViewById<EditText>(R.id.playerOne)
        val playerTwo = findViewById<EditText>(R.id.playerTwo)

        startGame.setOnClickListener{


            val playerOne1 : String = playerOne.text.toString()
            val playerTwo2 : String = playerTwo.text.toString()

            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("player1", playerOne1)
            intent.putExtra("player2", playerTwo2)

            startActivity(intent)
        }

    }

}