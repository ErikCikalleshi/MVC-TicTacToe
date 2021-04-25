package com.example.tic_tac_toe.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.example.tic_tac_toe.Controller.MainActivity
import com.example.tic_tac_toe.Model.AppDatabase
import com.example.tic_tac_toe.Model.TicTacToeGame
import com.example.tic_tac_toe.R

class View(layoutInflater: LayoutInflater) {
    private var mRootView = layoutInflater.inflate(R.layout.activity_main, null)
    private var buttons =  arrayOf<ArrayList<Button>>(arrayListOf(), arrayListOf(), arrayListOf())
    private lateinit var game: TicTacToeGame;
    private lateinit var db: AppDatabase


}