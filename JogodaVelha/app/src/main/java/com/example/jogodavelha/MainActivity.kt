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
    }
}