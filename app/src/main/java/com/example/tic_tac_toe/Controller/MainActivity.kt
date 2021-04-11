package com.example.tic_tac_toe.Controller

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tic_tac_toe.Model.TicTacToeGame
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.View.Interface

class MainActivity : AppCompatActivity(), Interface.AddListener, Interface.RestartGame {
    private var buttons =  arrayOf<ArrayList<Button>>(arrayListOf(), arrayListOf(), arrayListOf())
    private lateinit var game: TicTacToeGame;

    companion object{
        @JvmStatic
        lateinit var instance: MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instance = this

        game = TicTacToeGame(this)
        findViewById<TextView>(R.id.gameStateTextView).text = game.stringForGameState()

        val restart = findViewById<Button>(R.id.newGameButton)
        restart.setOnClickListener{
            restartView()
        }

        for(row in 0..2){
            for(col in 0..2){
                val buttonId = "button$row$col"
                val resId = resources.getIdentifier(buttonId, "id", packageName)
                buttons[row].add(findViewById(resId))

                buttons[row][col].setOnClickListener{ v ->
                    onClicked(v)
                }

            }
        }


    }

    override fun onClicked(v: View) {
        for(row in 0..2){
            for(col in 0..2){
                if(v.id == buttons[row][col].id){
                    game.pressedButtonAt(row, col)
                }
                buttons[row][col].text = game.setStringButtonAt(row, col)
            }
        }
        findViewById<TextView>(R.id.gameStateTextView).text = game.stringForGameState()

    }

    override fun restartView() {
        game.resetGame()
        for(row in 0..2) {
            for (col in 0..2) {
                buttons[row][col].text = ""
            }
        }
        findViewById<TextView>(R.id.gameStateTextView).text = game.stringForGameState()
    }

}