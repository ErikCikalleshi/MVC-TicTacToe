package com.example.tic_tac_toe.Controller

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.tic_tac_toe.Model.AppDatabase
import com.example.tic_tac_toe.Model.TicTacToeGame
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.View.Interface
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), Interface.OnClickedListener, Interface.OnRestartListener,
    Interface.LoadBoard {
    private var buttons = arrayOf<ArrayList<Button>>(arrayListOf(), arrayListOf(), arrayListOf())
    private lateinit var game: TicTacToeGame;

    private lateinit var player1: String
    private lateinit var player2: String

    // instance for class TicTacToeGame
    companion object {
        lateinit var instance: MainActivity
        lateinit var db: AppDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //before super.onCreate to prevent Android Injections
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "player")
            .fallbackToDestructiveMigration().allowMainThreadQueries().build()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instance = this

        game = TicTacToeGame(this)
        gameStateTextView.text = game.stringForGameState().capitalize(Locale.ROOT)

        if (checkDuplicate(p1) && checkDuplicate(p2)) {
            player1 = p1.text.toString().toLowerCase(Locale.ROOT)
            player2 = p2.text.toString().toLowerCase(Locale.ROOT)
            p1points.text = displayPoints(player1)
            p2points.text = displayPoints(player2)
        }
        newGameButton.setOnClickListener {
            restartView()
        }


        p1points.text = displayPoints(p1.text.toString())
        p2points.text = displayPoints(p2.text.toString())


        add1.setOnClickListener {
            if (checkDuplicate(p1)) {
                player1 = p1.text.toString().toLowerCase(Locale.ROOT)
                p1points.text = displayPoints(player1)
                gameStateTextView.text = game.stringForGameState().capitalize(Locale.ROOT)
            }
        }

        add2.setOnClickListener {
            if (checkDuplicate(p2)) {
                player2 = p2.text.toString().toLowerCase(Locale.ROOT)
                p2points.text = displayPoints(player2)
                gameStateTextView.text = game.stringForGameState().capitalize(Locale.ROOT)
            }
        }
        loadBoard()
    }

    private fun checkDuplicate(player: EditText): Boolean {
        if (db.playerDao().getPlayerName(player.text.toString().toLowerCase(Locale.ROOT)) != player.text.toString().toLowerCase(Locale.ROOT)) {
            db.playerDao().insertPlayer(player.text.toString().toLowerCase(Locale.ROOT), 0)
            Log.e("Error", "false")
            return false
        }
        Log.e("Error", "true")
        return true
    }

    private fun displayPoints(player: String): String {
        var x = db.playerDao().getPlayersPoint(db.playerDao().getPlayerName(player)).toString()
        Log.e("Error", x)
        return x
    }

    override fun restartView() {
        game.resetGame()
        for (row in 0..2) {
            for (col in 0..2) {
                buttons[row][col].text = ""
            }
        }
        gameStateTextView.text = game.stringForGameState().capitalize(Locale.ROOT)
        p1points.text = displayPoints(player1)
        p2points.text = displayPoints(player2)
    }

    override fun onClicked(v: View) {
        for (row in 0..2) {
            for (col in 0..2) {
                if (v.id == buttons[row][col].id) {
                    game.pressedButtonAt(row, col)
                }
                buttons[row][col].text = game.setStringButtonAt(row, col)
            }
        }
        gameStateTextView.text = game.stringForGameState().capitalize(Locale.ROOT)
    }

    override fun loadBoard() {
        for (row in 0..2) {
            for (col in 0..2) {
                val buttonId = "button$row$col"
                val resId = resources.getIdentifier(buttonId, "id", packageName)
                buttons[row].add(findViewById(resId))
                buttons[row][col].setOnClickListener { v ->
                    onClicked(v)
                }
            }
        }
    }

}