package com.example.tic_tac_toe.Model

import android.content.Context
import android.content.res.Resources
import com.example.tic_tac_toe.R


class TicTacToeGame(context: Context) {

    private enum class GameState {
        X_TURN, O_TURN, X_WIN, O_WIN, TIE_GAME
    }

    private var gameState: GameState? = null

    private val boardArray = Array(3) { IntArray(3) }
    private lateinit var context: Context
    private val MARK_NONE = 0
    private val MARK_X = 1
    private val MARK_O = 2
    init {
        this.context = context
        resetGame()
    }

    private fun resetGame() {
        this.gameState = GameState.X_TURN;
    }

    fun pressedButtonAt(row: Int, col: Int) {
        println(row)
        if(this.boardArray[row][col] != 0){
            return
        }
        if(this.gameState == GameState.X_TURN){
            this.boardArray[row][col] = MARK_X
            this.gameState = GameState.O_TURN
        }else if(this.gameState == GameState.O_TURN){
            this.boardArray[row][col] = MARK_O
            this.gameState = GameState.X_TURN
        }
        checkWin()
    }

    private fun checkWin() {
       if(check(MARK_X)){
           this.gameState = GameState.X_WIN
       }else if(check(MARK_O)){
           this.gameState = GameState.O_WIN
       }else if(isFull()){
           this.gameState = GameState.TIE_GAME
       }
    }

    private fun isFull(): Boolean {
        for (row in 0..2){
            for (col in 0..2){
                if(this.boardArray[row][col] == MARK_NONE){
                    return false
                }
            }
        }
        return true
    }

    private fun check(mark: Int): Boolean {
        var win = true
        //Horizontal check
        for (row in 0..2){
            win = true
            for (col in 0..2){
                if(this.boardArray[row][col] != mark){
                    win = false
                    break
                }
            }
            if(win) return true
        }

        //Vertical check
        for (col in 0..2){
            for (row in 0..2) {
                if(this.boardArray[col][row] != mark){
                    win = false
                    break
                }
            }
            if(win) return true
        }

        if(this.boardArray[0][0] == mark && this.boardArray[1][1] == mark && this.boardArray[2][2] == mark) return true
        if(this.boardArray[1][0] == mark && this.boardArray[1][1] == mark && this.boardArray[0][2] == mark) return true

        return false
    }

    fun setStringButtonAt(row: Int, col: Int): String {
        if (row in 0..2 && col>=0 && col < 3)
        {
            if (this.boardArray[row][col] == MARK_X) {
                return "X";
            } else if (this.boardArray[row][col] == MARK_O) {
                return "O";
            }
        }
        return ""
    }

    fun stringForGameState(): String {
        var gameStateLabel = ""
        val r: Resources = context.resources
        gameStateLabel = when (gameState) {
            GameState.X_TURN -> r.getString(R.string.x_turn)
            GameState.O_TURN -> r.getString(R.string.o_turn)
            GameState.X_WIN -> r.getString(R.string.x_win)
            GameState.O_WIN -> r.getString(R.string.o_win)
            else -> r.getString(R.string.tie_game)
        }
        return gameStateLabel
    }

}
