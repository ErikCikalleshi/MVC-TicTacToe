package com.example.tic_tac_toe.Controller

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tic_tac_toe.Model.TicTacToeGame
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.View.Interface

class MainActivity : AppCompatActivity(), Interface.AddListener, Interface.WinnerShowListener {
    private var buttons =  arrayOf<ArrayList<Button>>(arrayListOf(), arrayListOf(), arrayListOf())
    private lateinit var game: TicTacToeGame;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        game = TicTacToeGame(this)
        for(i in 0..2){
            for(j in 0..2){
                val buttonId = "button$i$j"

                val resId = resources.getIdentifier(buttonId, "id", packageName)
                buttons[i].add(findViewById(resId))

                buttons[i][j].setOnClickListener{ v ->
                    onClicked(v)
                }

            }
        }


    }

    override fun onClicked(v: View) {
        val res = findViewById<TextView>(R.id.gameStateTextView)
        for(row in 0..2){
            for(col in 0..2){
                if(v.id == buttons[row][col].id){
                    game.pressedButtonAt(row, col)
                }
                buttons[row][col].text = game.setStringButtonAt(row, col)
            }
        }
        res.text = game.stringForGameState()
    }

    override fun onWinShow(player: String) {
        TODO("Not yet implemented")
    }



}