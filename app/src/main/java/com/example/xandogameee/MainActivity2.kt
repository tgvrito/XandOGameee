package com.example.xandogameee

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var player1 : TextView
    private lateinit var player2 : TextView

    private lateinit var btn1 : Button
    private lateinit var btn2 : Button
    private lateinit var btn3 : Button
    private lateinit var btn4 : Button
    private lateinit var btn5 : Button
    private lateinit var btn6 : Button
    private lateinit var btn7 : Button
    private lateinit var btn8 : Button
    private lateinit var btn9 : Button
    private lateinit var resetButton : Button
    private lateinit var score1 : TextView
    private lateinit var score2 : TextView

    private var scorefor1 = 0
    private var scorefor2 = 0

    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        player1 = findViewById(R.id.player1)
        player2 = findViewById(R.id.player2)

        val playerOne1 = intent?.extras?.getString("player1", "Player One")
        val playerTwo2 = intent?.extras?.getString("player2", "Player Two")

        player1.text = playerOne1
        player2.text = playerTwo2
        init()
    }
    private fun init(){
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        resetButton = findViewById(R.id.resetButton)
        score1 = findViewById(R.id.score1)
        score2 = findViewById(R.id.score2)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)

        score1.text = "0"
        score2.text = "0"

        if (player1.text.isEmpty()){
            player1.text = "Player 1"
        }

        if (player2.text.isEmpty()){
            player2.text = "Player 2"
        }
    }

    override fun onClick(clickedView: View?) {

        if (clickedView is Button) {

            var buttonNumber = 0

            when (clickedView.id) {
                R.id.btn1 -> buttonNumber = 1
                R.id.btn2 -> buttonNumber = 2
                R.id.btn3 -> buttonNumber = 3
                R.id.btn4 -> buttonNumber = 4
                R.id.btn5 -> buttonNumber = 5
                R.id.btn6 -> buttonNumber = 6
                R.id.btn7 -> buttonNumber = 7
                R.id.btn8 -> buttonNumber = 8
                R.id.btn9 -> buttonNumber = 9
            }
            if (buttonNumber != 0) {
                platGame(clickedView, buttonNumber)
            }
        }

    }

    private fun platGame(clickedView: Button, buttonNumber: Int) {

        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setTextColor(Color.WHITE)
            firstPlayer.add(buttonNumber)
            activePlayer = 2
        } else {
            clickedView.text = "O"
            secondPlayer.add(buttonNumber)
            clickedView.setTextColor(Color.WHITE)
            activePlayer = 1
        }

        clickedView.isEnabled = false
        check()
    }




    private fun check(){
        fun reset(clickedView: Button){
            clickedView.text = ""
            clickedView.isEnabled = true
            firstPlayer.clear()
            secondPlayer.clear()
        }

        resetButton.setOnClickListener(){
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            score1.text = "0"
            score2.text = "0"
        }

        var winnerPlayer = 0

        if (btn1.text.isNotEmpty() && btn2.text.isNotEmpty() && btn3.text.isNotEmpty() && btn4.text.isNotEmpty() && btn5.text.isNotEmpty() && btn6.text.isNotEmpty() && btn7.text.isNotEmpty() && btn8.text.isNotEmpty() && btn9.text.isNotEmpty()){
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
            if (winnerPlayer == 1){
                scorefor1 += 1
                score1.text = "$scorefor1"
            }
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
            scorefor2+=1
            score2.text = "$scorefor2"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 2
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
            scorefor1+=1
            score1.text = "$scorefor1"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
            scorefor2+=1
            score2.text = "$scorefor2"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 2
        }

        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
            scorefor1+=1
            score1.text = "$scorefor1"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
            scorefor2+=1
            score2.text = "$scorefor2"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
            scorefor1+=1
            score1.text = "$scorefor1"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2
            scorefor2+=1
            score2.text = "$scorefor2"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 2
        }

        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
            scorefor1+=1
            score1.text = "$scorefor1"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
            scorefor2+=1
            score2.text = "$scorefor2"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
            scorefor1+=1
            score1.text = "$scorefor1"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
            scorefor2+=1
            score2.text = "$scorefor2"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
            scorefor1+=1
            score1.text = "$scorefor1"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
            scorefor1+=1
            score1.text = "$scorefor1"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer = 1
            scorefor2+=1
            score2.text = "$scorefor2"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer = 2
            scorefor2+=1
            score2.text = "$scorefor2"
            reset(btn1)
            reset(btn2)
            reset(btn3)
            reset(btn4)
            reset(btn5)
            reset(btn6)
            reset(btn7)
            reset(btn8)
            reset(btn9)
            activePlayer = 2
        }

        if (winnerPlayer == 1){
            Toast.makeText(this, "${player1.text} Won!", Toast.LENGTH_SHORT).show()
        }

        if (winnerPlayer == 2){
            Toast.makeText(this, "${player2.text} Won!", Toast.LENGTH_SHORT).show()
        }

    }



}