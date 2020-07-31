package com.example.jogodavelha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btClick(view: View){
        val btSelected = view as Button
        //selected bottom
        var cellID = 0
        when(btSelected.id){
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9
        }
        //Toast.makeText(this, "ID: "+cellID,Toast.LENGTH_SHORT).show()
        playGame(cellID, btSelected)
    }

    //Arrays to store each player's moves
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    //player turn
    var activyPlayer = 1

    fun playGame(cellID: Int, btSelected: Button){
        if(activyPlayer==1){
            btSelected.text = "X"
            btSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            activyPlayer = 2
        }else{
            btSelected.text = "O"
            btSelected.setBackgroundColor(Color.MAGENTA)
            player2.add(cellID)
            activyPlayer = 1
        }
        btSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner(){
        var winner = -1

        //Line 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3) ||
            //Line 2
            player1.contains(4) && player1.contains(5) && player1.contains(6) ||
            //Line3
            player1.contains(7) && player1.contains(8) && player1.contains(9) ||
            //column 1
            player1.contains(1) && player1.contains(4) && player1.contains(7) ||
            //column 2
            player1.contains(2) && player1.contains(5) && player1.contains(8) ||
            //column 3
            player1.contains(3) && player1.contains(6) && player1.contains(9) ||
            //diagonal
            player1.contains(1) && player1.contains(5) && player1.contains(9) ||
            player1.contains(3) && player1.contains(5) && player1.contains(7)
        ){
            winner = 1
        }
        else if(player2.contains(1) && player2.contains(2) && player2.contains(3) ||
            //Line 2
            player2.contains(4) && player2.contains(5) && player2.contains(6) ||
            //Line3
            player2.contains(7) && player2.contains(8) && player2.contains(9) ||
            //column 1
            player2.contains(1) && player2.contains(4) && player2.contains(7) ||
            //column 2
            player2.contains(2) && player2.contains(5) && player2.contains(8) ||
            //column 3
            player2.contains(3) && player2.contains(6) && player2.contains(9) ||
            //diagonal
            player2.contains(1) && player2.contains(5) && player2.contains(9) ||
            player2.contains(3) && player2.contains(5) && player2.contains(7)
        ){
            winner = 2
        }

        if(winner != -1){
            Toast.makeText(this, "Player "+winner+" won the game!", Toast.LENGTH_SHORT).show()
        }
    }
}