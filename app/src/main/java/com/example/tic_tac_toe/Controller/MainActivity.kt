package com.example.tic_tac_toe.Controller

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.tic_tac_toe.Model.AppDatabase
import com.example.tic_tac_toe.Model.TicTacToeGame
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.View.Interface

class MainActivity : AppCompatActivity(), Interface.OnClickedListener, Interface.OnRestartListener {
    private var buttons =  arrayOf<ArrayList<Button>>(arrayListOf(), arrayListOf(), arrayListOf())
    private lateinit var game: TicTacToeGame;


    // instance for class TicTacToeGame
    companion object{
        @JvmStatic
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
        findViewById<TextView>(R.id.gameStateTextView).text = game.stringForGameState()





        val restart = findViewById<Button>(R.id.newGameButton)
        restart.setOnClickListener{
            restartView()
        }
        db.playerDao().insertPlayer(findViewById<TextView>(R.id.p1).text.toString(), 0)
        db.playerDao().insertPlayer(findViewById<TextView>(R.id.p2).text.toString(), 0)

        findViewById<TextView>(R.id.p1).setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE){
                db.playerDao().insertPlayer(findViewById<TextView>(R.id.p1).text.toString(), 0)
                findViewById<TextView>(R.id.p1Points).text = db.playerDao().getPlayersPoint(db.playerDao().getPlayerByName(findViewById<TextView>(R.id.p1).text.toString())).toString()

                true
            } else {
                false
            }
        }
        findViewById<TextView>(R.id.p2).setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE){
                db.playerDao().insertPlayer(findViewById<TextView>(R.id.p2).text.toString(), 0)
                findViewById<TextView>(R.id.p1Points).text = db.playerDao().getPlayersPoint(db.playerDao().getPlayerByName(findViewById<TextView>(R.id.p2).text.toString())).toString()
                true
            } else {
                false
            }
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

    override fun restartView() {
        game.resetGame()
        for(row in 0..2) {
            for (col in 0..2) {
                buttons[row][col].text = ""
            }
        }
        findViewById<TextView>(R.id.gameStateTextView).text = game.stringForGameState()
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

}